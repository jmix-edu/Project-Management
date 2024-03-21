package com.company.projectmanagement.security;

import com.company.projectmanagement.entity.TimeEntry;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "RestrictedTimeEntriesRole", code = RestrictedTimeEntriesRole.CODE)
public interface RestrictedTimeEntriesRole {
    String CODE = "restricted-time-entries-role";

    @JpqlRowLevelPolicy(entityClass = TimeEntry.class,
            where = "{E}.user.username=:current_user_username or {E}.task.project.manager.username=:current_user_username")
    void timeEntry();
}