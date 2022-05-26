package org.launchcode.tara.controller;

import org.launchcode.tara.model.Tag;
import org.launchcode.tara.model.User;
import org.launchcode.tara.payloads.request.TagRequest;
import org.launchcode.tara.payloads.response.MessageResponse;
import org.launchcode.tara.repository.TagRepository;
import org.launchcode.tara.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tags")
public class TaggingController {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addTags(@Valid @RequestBody TagRequest tagRequest){
        User currentUser = userRepository.findByUsername(tagRequest.getUsername()).get();

        ArrayList<String> stressorsRequest = tagRequest.getStressors();
        ArrayList<String> helpersRequest = tagRequest.getHelpers();
        ArrayList<String> dontsRequest = tagRequest.getDonts();

        Set<Tag> stressors = new HashSet<>();
        Set<Tag> helpers = new HashSet<>();
        Set<Tag> donts = new HashSet<>();

        if (!(stressorsRequest == null)) {
            for (Integer i = 0; i < stressorsRequest.size(); i++) {
                String newTag = stressorsRequest.get(i);
                if (tagRepository.existsByName(newTag)) {
                    stressors.add(tagRepository.getByName(newTag));
                } else {
                    Tag tag = new Tag(newTag);
                    tagRepository.save(tag);
                    stressors.add(tagRepository.getByName(newTag));
                }
            }
        }

        if (!(helpersRequest == null)) {
            for (Integer i = 0; i < helpersRequest.size(); i++) {
                String newTag = helpersRequest.get(i);
                if (tagRepository.existsByName(newTag)) {
                    helpers.add(tagRepository.getByName(newTag));
                } else {
                    Tag tag = new Tag(newTag);
                    tagRepository.save(tag);
                    helpers.add(tagRepository.getByName(newTag));
                }
            }
        }

        if (!(dontsRequest == null)) {
            for (Integer i = 0; i < dontsRequest.size(); i++) {
                String newTag = dontsRequest.get(i);
                if (tagRepository.existsByName(newTag)) {
                    donts.add(tagRepository.getByName(newTag));
                } else {
                    Tag tag = new Tag(newTag);
                    tagRepository.save(tag);
                    donts.add(tagRepository.getByName(newTag));
                }
            }
        }

        for (Tag stressor : stressors) {
            currentUser.setStressors(stressor);
        }
        for (Tag helper : helpers) {
            currentUser.setHelpers(helper);
        }
        for (Tag dont : donts) {
            currentUser.setDonts(dont);
        }

        userRepository.save(currentUser);
        return ResponseEntity.ok(new MessageResponse("Successfully added tags!"));
    }
}
