package com.shalaka.CourseAPIData.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    private List<Topic> topicList = new ArrayList<Topic>( Arrays.asList(
                new Topic("1", "Cpp", "Programming language"),
                new Topic("2", "Dance", "Dancing style"),
                new Topic("3", "Food", "Foodie")
        ));

    public List<Topic> getAllTopics(){
        List<Topic> tlist = new ArrayList<Topic>();
        topicRepository.findAll().forEach(tlist::add);
        return tlist;
    }

    public Topic getTopicById(String id){
        System.out.println(topicRepository.findById(id));
        return topicList.stream().filter(t -> t.gettId().equals(id)).findFirst().get();
    }
    public void addTopic(Topic topic){
        //System.out.println(topic.gettId() + " " + topic.gettName());

        topicRepository.save(topic);
      //  System.out.println("Topic grasped");
    }

    public void updateTopic(String id, Topic topic){
        for(int i=0; i<topicList.size(); i++){
            if(topicList.get(i).gettId().equals(id)){
                topicList.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        for(int i=0; i<topicList.size(); i++){
            if(topicList.get(i).gettId().equals(id)){
                topicList.remove(i);
                return;
            }
        }
    }
}
