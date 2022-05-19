package org.example.models;

import java.util.Objects;

public class News {
    public int id;
    private int departmentId;
    private String topic;
    private String description;

    public News(String topic, String description) {
        this.topic = topic;
        this.description = description;
    }

    public News(int departmentId, String topic, String description) {
        this.departmentId = departmentId;
        this.topic = topic;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return id == news.id && departmentId == news.departmentId && Objects.equals(topic, news.topic) && Objects.equals(description, news.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, topic, description);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
