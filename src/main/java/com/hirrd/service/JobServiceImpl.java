package com.hirrd.service;

import com.hirrd.dto.*;
import com.hirrd.exception.JobPortalException;
import com.hirrd.model.Applicant;
import com.hirrd.model.Job;
import com.hirrd.repository.JobRepository;
import com.hirrd.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public JobDTO postJob(JobDTO jobDTO) throws JobPortalException {
        if (jobDTO.getId() == 0) {
            jobDTO.setId(Utilities.getNextSequence("jobs"));
            jobDTO.setPostTime(LocalDateTime.now());

            NotificationDTO notiDTO = new NotificationDTO();
            notiDTO.setUserId(jobDTO.getPosterId());
            notiDTO.setAction("Job Posted");
            notiDTO.setMessage("Job posted successfully for " + jobDTO.getJobTitle() + " at " + jobDTO.getCompany());
            notiDTO.setRoute("/posted-job/" + jobDTO.getId());
            try {
                notificationService.sendNotification(notiDTO);
            } catch (JobPortalException e) {
                throw new RuntimeException(e);
            }
        } else {
            Job job = jobRepository.findById(jobDTO.getId()).orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND"));
            if (job.getJobStatus().equals(JobStatus.DRAFT) || jobDTO.getJobStatus().equals(JobStatus.CLOSED)) {
                jobDTO.setPostTime(LocalDateTime.now());
            }
        }
        return jobRepository.save(jobDTO.toEntity()).toDTO();
    }

    @Override
    public List<JobDTO> getAllJobs() throws JobPortalException {
        return jobRepository.findAll().stream().map(Job::toDTO).toList();
    }

    @Override
    public JobDTO getJob(Long id) throws JobPortalException {
        return jobRepository.findById(id).orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND")).toDTO();
    }

    @Override
    public void applyJob(Long id, ApplicantDTO applicantDTO) throws JobPortalException {
        Job job = jobRepository.findById(id).orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND"));
        List<Applicant> applicants = job.getApplicants();
        if (applicants == null) applicants = new ArrayList<>();
        if (!applicants.stream().filter((x) -> x.getApplicantId() == applicantDTO.getApplicantId()).toList().isEmpty())
            throw new JobPortalException("JOB_APPLIED_ALREADY");

        applicantDTO.setApplicationStatus(ApplicationStatus.APPLIED);
        applicants.add(applicantDTO.toEntity());
        job.setApplicants(applicants);
        jobRepository.save(job);
    }

    @Override
    public List<JobDTO> getJobsByPosterId(Long id) throws JobPortalException {
        return jobRepository.findByPosterId(id).stream().map((x) -> x.toDTO()).toList();
    }

    @Override
    public void changeStatus(Application application) throws JobPortalException {
        Job job = jobRepository.findById(application.getId()).orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND"));
        List<Applicant> applicants = job.getApplicants().stream().map((x) -> {
            if (application.getApplicantId() == x.getApplicantId()) {

                x.setApplicationStatus(application.getApplicationStatus());

                if (application.getApplicationStatus().equals(ApplicationStatus.INTERVIEWING)) {
                    x.setInterviewTime((application.getInterviewTime()));
                    NotificationDTO notiDTO = new NotificationDTO();
                    notiDTO.setUserId(application.getApplicantId());
                    notiDTO.setAction("Interview Scheduled");
                    notiDTO.setMessage("Interview scheduled for job id: " + application.getId());
                    notiDTO.setRoute("/job-history");
                    try {
                        notificationService.sendNotification(notiDTO);
                    } catch (JobPortalException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return x;
        }).toList();
        job.setApplicants(applicants);
        jobRepository.save(job);
    }
}
