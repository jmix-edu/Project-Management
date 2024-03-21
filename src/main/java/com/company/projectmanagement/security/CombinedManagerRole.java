package com.company.projectmanagement.security;

import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "CombinedManagerRole", code = CombinedManagerRole.CODE)
public interface CombinedManagerRole extends ProjectManagerRole, UiMinimalRole {
    String CODE = "combined-manager-role";
}