package project.springboot.template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.springboot.template.dto.request.CreateJobRequest;
import project.springboot.template.entity.common.ApiResponse;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {
    @GetMapping("/test")
    public ResponseEntity<ApiResponse<String>> test() {
        return ResponseEntity.ok(ApiResponse.success("asdadsa"));
    }

    // Get Hiring Jobs
    @GetMapping("/hiring")
    public ResponseEntity<ApiResponse<String>> getHiringJobs() {
        return ResponseEntity.ok(ApiResponse.success("asdadsa"));
    }
    // Get Hiring Detail Job
    @GetMapping("/{id}/hiring")
    public ResponseEntity<ApiResponse<String>> getHiringJobDetail(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ApiResponse.success("asdadsa"));
    }
    // Get All Jobs
    @GetMapping
    public ResponseEntity<ApiResponse<String>> getAllJobs() {
        return ResponseEntity.ok(ApiResponse.success("asdadsa"));
    }
    // Get Detail Jobs
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> getJobDetail(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ApiResponse.success("asdadsa"));
    }
    // Create Job
    @PostMapping
    public ResponseEntity<ApiResponse<String>> createJob(@RequestBody CreateJobRequest request) {
        return ResponseEntity.ok(ApiResponse.success("asdadsa"));
    }
    // Update Job

    // Change Job Status
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateJobStatus(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ApiResponse.success("asdadsa"));
    }
    // Delete Job
}
