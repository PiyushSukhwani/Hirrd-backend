package com.hirrd.service;

import com.hirrd.dto.ApplicantDTO;
import com.hirrd.dto.Application;
import com.hirrd.dto.JobDTO;
import com.hirrd.dto.ResponseDTO;
import com.hirrd.exception.JobPortalException;

import java.util.List;

public interface JobService {

    public JobDTO postJob(JobDTO jobDTO) throws JobPortalException;

    public List<JobDTO> getAllJobs() throws JobPortalException;

    public JobDTO getJob(Long id) throws JobPortalException;

    public void applyJob(Long id, ApplicantDTO applicantDTO) throws JobPortalException;

    public List<JobDTO> getJobsByPosterId(Long id) throws JobPortalException;

    public void changeStatus(Application application) throws JobPortalException;
}
