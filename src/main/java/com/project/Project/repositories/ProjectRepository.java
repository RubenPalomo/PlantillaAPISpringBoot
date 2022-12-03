package com.project.Project.repositories;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;

import com.project.Project.models.Element;

@Component
public interface ProjectRepository {

    List<Element> findElementsByParams(HashMap<String, String> map);

    List<Element> findAll();

    Element findById(String id);

    void save(Element element);

    void deleteById(String id);
}
