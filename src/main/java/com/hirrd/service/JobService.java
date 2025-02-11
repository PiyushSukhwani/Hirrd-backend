package com.hirrd.service;

import com.hirrd.dto.JobDTO;
import com.hirrd.exception.JobPortalException;

import java.util.List;

public interface JobService {

    public JobDTO postJob(JobDTO jobDTO) throws JobPortalException;

    public List<JobDTO> getAllJobs() throws JobPortalException;

    public JobDTO getJob(Long id) throws JobPortalException;
}
