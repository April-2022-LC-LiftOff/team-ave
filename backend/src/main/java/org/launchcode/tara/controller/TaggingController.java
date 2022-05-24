package org.launchcode.tara.controller;

import org.launchcode.tara.model.Tag;
import org.launchcode.tara.model.User;
import org.launchcode.tara.payloads.request.SignupRequest;
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
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tags")
public class TaggingController {

    @Autowired
    TagRequest tagRequest;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addTags(@Valid @RequestBody TagRequest tagRequest){
        User currentUser = userRepository.getCurrentUser(tagRequest.getUsername());

        ArrayList<String> stressorsRequest = tagRequest.getStressors();
        ArrayList<String> destressorsRequest = tagRequest.getDestressors();
        ArrayList<String> donotsRequest = tagRequest.getDonots();

        Set<Tag> stressors = new HashSet<>();
        Set<Tag> destressors = new HashSet<>();
        Set<Tag> donots = new HashSet<>();

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

        for (Integer i = 0; i < destressorsRequest.size(); i++) {
            String newTag = destressorsRequest.get(i);
            if (tagRepository.existsByName(newTag)) {
                destressors.add(tagRepository.getByName(newTag));
            } else {
                Tag tag = new Tag(newTag);
                tagRepository.save(tag);
                stressors.add(tagRepository.getByName(newTag));
            }
        }

        for (Integer i = 0; i < donotsRequest.size(); i++) {
            String newTag = donotsRequest.get(i);
            if (tagRepository.existsByName(newTag)) {
                donots.add(tagRepository.getByName(newTag));
            } else {
                Tag tag = new Tag(newTag);
                tagRepository.save(tag);
                stressors.add(tagRepository.getByName(newTag));
            }
        }

        currentUser.setStressors(stressors);
        currentUser.setDestressors(destressors);
        currentUser.setDonots(donots);

        userRepository.save(currentUser);
        return ResponseEntity.ok(new MessageResponse("Successfully added tags!"));
    }
}
