package org.example.models;

import java.util.Objects;

public class Worker {
    public int id;
    private int departmentId;
    private String workerName;
    private String workerPosition;

    public Worker(int departmentId, String name, String departmentPosition) {
        this.departmentId = departmentId;
        this.workerName = name;
        this.workerPosition = departmentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return id == worker.id && departmentId == worker.departmentId && Objects.equals(workerName, worker.workerName) && Objects.equals(workerPosition, worker.workerPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, workerName, workerPosition);
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

    public String getName() {
        return workerName;
    }

    public void setName(String name) {
        this.workerName = name;
    }

    public String getDepartmentPosition() {
        return workerPosition;
    }

    public void setDepartmentPosition(String departmentPosition) {
        this.workerPosition = departmentPosition;
    }
}
