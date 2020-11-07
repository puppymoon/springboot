package com.moontea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moontea.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
