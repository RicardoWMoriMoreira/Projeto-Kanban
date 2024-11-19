package com.kanban.demo.model;

public enum TaskPriority {
    LOW("Baixa"),
    MEDIUM("Média"),
    HIGH("Alta");

    private final String description;

    TaskPriority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
