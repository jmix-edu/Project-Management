package com.company.projectmanagement.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum TaskPriority implements EnumClass<String> {

    LOW("A"),
    MEDIUM("B"),
    HIGH("C");

    private final String id;

    TaskPriority(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TaskPriority fromId(String id) {
        for (TaskPriority at : TaskPriority.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}