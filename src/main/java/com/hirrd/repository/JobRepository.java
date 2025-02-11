package com.hirrd.repository;

import com.hirrd.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, Long> {
}
