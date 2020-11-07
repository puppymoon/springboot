package com.moontea.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.moontea.entity.Article;
import com.moontea.entity.Topic;
import com.moontea.repo.ArticleRepository;
import com.moontea.repo.TopicRepository;
import com.moontea.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@Transactional
	@Override
	public Topic saveTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	@Transactional
	@Override
	public Topic findTopic(Long id) {
		Topic topic = topicRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		System.out.println(JSON.toJSONString(topic, true));
		return topic;
	}

	@Transactional
	@Override
	public Topic updateTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	@Transactional
	@Override
	public Topic includeArticle(Long topicId, Long articleId) {
		Topic topic = topicRepository.findById(topicId).orElseThrow(() -> new EntityNotFoundException());
		Article article = articleRepository.findById(articleId).orElseThrow(() -> new EntityNotFoundException());
		topic.getArticles().add(article);
		return topic;
	}

	@Transactional
	@Override
	public Topic unIncludeArticle(Long topicId, Long articleId) {
		Topic topic = topicRepository.findById(topicId).orElseThrow(() -> new EntityNotFoundException());
		Article article = articleRepository.findById(articleId).orElseThrow(() -> new EntityNotFoundException());
		topic.getArticles().remove(article);
		return topic;
	}

	@Transactional
	@Override
	public void deleteTopic(Long id) {
		topicRepository.deleteById(id);
	}
}
