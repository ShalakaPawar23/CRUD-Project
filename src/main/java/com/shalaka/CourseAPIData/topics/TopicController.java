package com.shalaka.CourseAPIData.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    //create an instance of service
    @Autowired
    public TopicService topicService;
    @RequestMapping(method=RequestMethod.GET, value="/topics")
    public List<Topic> getAllTopics(){

        return topicService.getAllTopics();
    }

    // returns single topic based on id
    @RequestMapping("/topics/{entered_id}")
    public Topic getTopic(@PathVariable("entered_id") String id){

        return topicService.getTopicById(id);
    }

    @PostMapping(value = "/topics")
    public void addTopic(@RequestBody Topic topic){

        topicService.addTopic(topic);
    }
    @PutMapping(value = "/topics/{id}")
    public void updateTopic(@PathVariable String id,@RequestBody Topic topic){

        topicService.updateTopic(id, topic);
    }

    @DeleteMapping(value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){

        topicService.deleteTopic(id);
    }
}
