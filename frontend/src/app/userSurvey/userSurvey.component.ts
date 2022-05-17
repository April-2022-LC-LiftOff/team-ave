class TagInput {
    public target: any;
    public tags: Array<string> = [];
    public inputVal: string = '';

    private tagTarget: any;
    private inputTarget: any;

    private popOver: any = document.createElement('div');
    private popOverInput: any = document.createElement('input');

    constructor(target: any, existingTags: Array<string> = []) {
        this.target = target;

        this.tagTarget = this.target.getElementsByTagName('span')[0];
        this.inputTarget = this.target.querySelector('#tag');

        if (existingTags.length > 0) {
        	this.tags = existingTags;
			this.renderTags();
        }

        this.inputTarget.oninput = this.bindOnChange;
        this.inputTarget.onkeydown = this.checkBackspaceOnEmpty;

        this.popOver.appendChild(this.popOverInput);
        this.setupPopOver();
    }

    setupPopOver = () => {
        let input = this.popOver.querySelector('input');
        this.popOver.setAttribute('id', 'pop-over-edit');

        input.setAttribute('name', 'tag-edit');
        input.setAttribute('id', 'tag-edit');
        input.setAttribute('value', '');
    }

    /**
     * Checks if the last character is a comma and
     * pushes the value into the array
     * Renders the exisiting tags
     * 
     * @param e {any} oninput event object
     * @memberof TagInput
     */
    bindOnChange = (e: any) => {
        let val: string = e.target.value;
        let lastChar: string = val.substr(val.length - 1);

        if (lastChar === ',') {
            let tagName = val.replace(',', '').toLowerCase();
            
            if (this.checkDuplication(tagName)) {
                this.inputTarget.value = tagName;
                return false;
            }

            this.tags.push(tagName);
            this.inputTarget.value = '';
        }

        if (this.tags.length > 0) {
            this.renderTags();
        }
    }

    /**
     * Checks for duplicate items in the tag list
     * 
     * @param tag {string} tag text
     * @memberof TagInput
     */
    checkDuplication = (tag: string) => {
        return this.tags.indexOf(tag) > -1 ? true : false;
    }

    /**
     * If the user uses Delete or Backspace on an empty form
     * field, set the value to the last tag
     * 
     * @param e {any} keydown event object
     * @memberof TagInput
     */
    checkBackspaceOnEmpty = (e: any) => {
        if (this.tags.length > 0) {
            if (e.keyCode === 13 || e.keyCode === 8) {
                if (e.target.value === '') {
                    let lastVal = this.tags.pop();
                    this.inputTarget.value = lastVal + ' ';
                    this.renderTags();
                }
            }
        }
    }

    /**
     * Removes the tag from the array if clicked on
     * 
     * @param e {any} Click event Anchor
     * @param tag {string} tag that needs to be removed
     * @memberof TagInput
     */
    removeTag = (e: any = null, tag: string = '') => {
        if (e) e.preventDefault();
        let tagToRemove = tag !== '' ? tag : e.target.dataset.tag,
            index = this.tags.indexOf(tagToRemove);
        
        if (index > -1) {
            this.tags.splice(index, 1);
        }

        this.renderTags();
    }

    togglePopOverEdit = (e: any) => {
        let pill = e.target;
        let hasPopOver = pill.querySelector('#pop-over-edit');

        if (hasPopOver) {
            pill.removeChild(pill.querySelector('#pop-over-edit'));
            return false;
        }

        if (!hasPopOver && pill.nodeName === 'SPAN') {
            let curValue = pill.dataset.tag;
            this.popOverInput.value = curValue;

            pill.appendChild(this.popOver);
            this.popOver.oninput = (e: any) => {
                this.bindPopOverInput(e, pill.dataset.tag);
            }
        }
    }

    bindPopOverInput = (e: any, tag: string) => {
        let val = e.target.value,
            index = this.tags.indexOf(tag);
        
        if (val !== '') {
            this.tags[index] = val;
            let curTag = this.tagTarget.querySelector('.tag[data-tag="' + tag + '"]');
            curTag.childNodes[0].nodeValue = val;
            curTag.setAttribute('data-tag', val)
        } else {
            this.removeTag(null, this.tags[index]);
            return false;
        }
    }

    /**
     * Creates the tag pill with the close 'x'
     * 
     * @param tag {string} tag text
     * @memberof TagInput
     */
    constructTag = (tag: string) => {
        let elem = document.createElement('span'),
            close = document.createElement('a');
        elem.classList.add('tag');
        elem.innerText = tag.trim();
        elem.setAttribute('data-tag', tag);

        elem.addEventListener('click', (e) => this.togglePopOverEdit(e));

        close.innerText = 'x';
        close.classList.add('close');
        close.setAttribute('href', '#');
        close.setAttribute('data-tag', tag);
        
        close.addEventListener('click', (e) => this.removeTag(e));

        elem.appendChild(close);

        return elem;
    }

    /**
     * Renders the tags infront of the input field
     * 
     * @memberof TagInput
     */
    renderTags = () => {
        while (this.tagTarget.firstChild) {
            this.tagTarget.removeChild(this.tagTarget.firstChild);
        }

        this.tags.forEach(item => {
            this.tagTarget.appendChild(this.constructTag(item));
        });
    }
}

window.onload = () => {
    let target = document.getElementById('tag-input');
    let tagInputController = new TagInput(target, ['really', 'cool', 'tagging', 'system']);
}
