package com.project.Project.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("flights")
public class Element {
    @Id
    private String _id;
    @Field
    private String name;

    public Element() {

    }

    public Element(String _id, String name) {
        setId(_id);
        setName(name);
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Element [id=" + _id + ", name=" + name + "]";
    }
}
