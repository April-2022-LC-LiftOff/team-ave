import { Component, Input, OnInit, Output, Renderer2 } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-occurrence-card',
  templateUrl: './occurrence-card.component.html',
  styleUrls: ['./occurrence-card.component.css']
})
export class OccurrenceCardComponent implements OnInit {

  @Input('link')
  link!: string;
  @Input('id')
  id!: number;
  @Input('date')
  date!: Date;
  @Input('location')
  location!: string;
  @Input('stressors')
  stressors!: string;
  @Input('destressors')
  destressors!:string;
  @Input('description')
  description!:string;


  @Output('delete') deleteEvent: EventEmitter<void> = new EventEmitter<void>();

  constructor(private renderer: Renderer2) { }

  ngOnInit(): void {
  }

  onXButtonClick(){
    this.deleteEvent.emit();
  }

}
