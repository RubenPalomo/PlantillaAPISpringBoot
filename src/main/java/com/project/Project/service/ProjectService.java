package com.project.Project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.Project.models.Element;
import com.project.Project.repositories.ProjectRepository;

@Component
public class ProjectService {
    @Autowired
    ProjectRepository elementRepository;

    public void save(Element element) {
        elementRepository.save(element);
    }

    public List<Element> findAll() {
        return elementRepository.findAll();
    }

    public Element findById(String id) {
        return elementRepository.findById(id);
    }

    public void deleteById(String id) {
        elementRepository.deleteById(id);
    }

    public List<Element> findElementsByParams(HashMap<String, String> map) {
        return elementRepository.findElementsByParams(map);
    }
}
