package com.kanban.demo.model;

public enum TaskCategory {
    WORK("Trabalho"),
    STUDY("Estudo"),
    PERSONAL("Pessoal"),
    MEETING("Reunião"),
    PROJECT("Projeto");

    private final String description;

    TaskCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


