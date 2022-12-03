package com.project.Project.repositories;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Component;

import com.project.Project.models.Element;

@Component
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Element> findElementsByParams(HashMap<String, String> map) {
        Query query = new Query();

        for (String key : map.keySet()) {
            System.out.println("key: " + key + " value: " + map.get(key));
            query.addCriteria(Criteria.where(key).regex(map.get(key)));
        }
        return mongoTemplate.find(query, Element.class);
    }

    @Override
    public List<Element> findAll() {

        return mongoTemplate.findAll(Element.class);
    }

    @Override
    public Element findById(String id) {
        return mongoTemplate.findById(id, Element.class);
    }

    @Override
    public void save(Element element) {
        mongoTemplate.save(element);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(mongoTemplate.findById(id, Element.class));
    }
}
