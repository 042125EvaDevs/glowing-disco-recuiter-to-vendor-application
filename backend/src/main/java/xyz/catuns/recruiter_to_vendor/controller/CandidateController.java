package xyz.catuns.recruiter_to_vendor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("All good");
    }
}
