package com.hirrd.controller;

import com.hirrd.dto.ApplicantDTO;
import com.hirrd.dto.Application;
import com.hirrd.dto.JobDTO;
import com.hirrd.dto.ResponseDTO;
import com.hirrd.exception.JobPortalException;
import com.hirrd.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@Validated
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/postJob")
    public ResponseEntity<JobDTO> postJob(@RequestBody @Valid JobDTO jobDTO) throws JobPortalException {
        return new ResponseEntity<>(jobService.postJob(jobDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<JobDTO>> getAllJobs() throws JobPortalException {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/getJob/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long id) throws JobPortalException {
        return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
    }

    @PostMapping("/apply/{id}")
    public ResponseEntity<ResponseDTO> applyJob( @PathVariable Long id, @RequestBody ApplicantDTO applicantDTO) throws JobPortalException{
        jobService.applyJob(id, applicantDTO);
        return new ResponseEntity<>(new ResponseDTO("Applied Successfully"), HttpStatus.OK);
    }

    @GetMapping("/poster/{id}")
    public ResponseEntity<List<JobDTO>> getJobsByPosterId(@PathVariable Long id) throws JobPortalException {
        return new ResponseEntity<>(jobService.getJobsByPosterId(id), HttpStatus.OK);
    }

    @PostMapping("/changeApplStatus")
    public ResponseEntity<ResponseDTO> changeApplStatus(@RequestBody Application application) throws JobPortalException {
        jobService.changeStatus(application);
        return new ResponseEntity<>(new ResponseDTO("Application Status Changed Successfully"), HttpStatus.OK);
    }

}



























