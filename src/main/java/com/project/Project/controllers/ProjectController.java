package com.project.Project.controllers;

import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin; // Importante para usar axios en React

import com.project.Project.models.Element;
import com.project.Project.service.ProjectService;

@RestController
@RequestMapping("/flight")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping()
    public List<Element> getFlights() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Element findbyId(@PathVariable String id) {
        return projectService.findById(id);
    }

    @GetMapping("/")
    public List<Element> findElementsByParams(@RequestParam(required = false) String name,
            @RequestParam(required = false) String moreElements) {

        HashMap<String, String> map = new HashMap<String, String>();
        if (name != null) {
            map.put("name", name);
        }
        if (moreElements != null) {
            map.put("moreElements", moreElements);
        }

        return projectService.findElementsByParams(map);
    }

    @PostMapping()
    public void save(@RequestBody Element flight) {
        try {
            findbyId(flight.getId());
            return;
        } catch (Exception e) {
            projectService.save(flight);
        }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Element flight) {
        projectService.save(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        projectService.deleteById(id);
    }
}
