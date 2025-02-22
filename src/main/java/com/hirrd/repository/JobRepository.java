package com.hirrd.repository;

import com.hirrd.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobRepository extends MongoRepository<Job, Long> {

    public List<Job> findByPosterId(Long postedBy);
}
