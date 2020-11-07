package com.moontea.service;

import com.moontea.entity.Topic;

public interface TopicService {

    Topic saveTopic(Topic topic);

    Topic findTopic(Long id);

    Topic updateTopic(Topic topic);

    Topic includeArticle(Long topicId, Long articleId);

    Topic unIncludeArticle(Long topicId, Long articleId);

    void deleteTopic(Long id);
}
