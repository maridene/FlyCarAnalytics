package com.flycar.analytics.service;

import com.flycar.analytics.domain.Job;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Job}.
 */
public interface JobService {
    /**
     * Save a job.
     *
     * @param job the entity to save.
     * @return the persisted entity.
     */
    Job save(Job job);

    /**
     * Updates a job.
     *
     * @param job the entity to update.
     * @return the persisted entity.
     */
    Job update(Job job);

    /**
     * Partially updates a job.
     *
     * @param job the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Job> partialUpdate(Job job);

    /**
     * Get all the jobs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Job> findAll(Pageable pageable);

    /**
     * Get the "id" job.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Job> findOne(Long id);

    /**
     * Delete the "id" job.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
