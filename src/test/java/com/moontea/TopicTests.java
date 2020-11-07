package com.moontea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.moontea.entity.Topic;
import com.moontea.service.TopicService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTests {

	@Autowired
	private TopicService topicService;

	@Test
	public void saveTopic() {
		Topic topic = new Topic();
		topic.setName("艺术");
		topicService.saveTopic(topic);
	}

	@Test
	public void updateTopic() {
		Topic topic = topicService.findTopic(1L);
		topic.setName("文学");
		topicService.saveTopic(topic);
	}

	@Test
	public void includeArticle() {
		topicService.includeArticle(1L, 2L);
	}

	@Test
	public void findTopic() {
		Topic topic = topicService.findTopic(1L);
//        topic.getArticles();
//        System.out.println(JSON.toJSONString(topic,true));
	}

	@Test
	public void unIncludeArticle() {
		topicService.unIncludeArticle(1L, 2L);
	}

	@Test
	public void deleteTopic() {
		topicService.deleteTopic(1L);
	}

}
