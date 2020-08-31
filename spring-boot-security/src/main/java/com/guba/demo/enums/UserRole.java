package com.guba.demo.enums;

import com.google.common.collect.Sets;

import static  com.guba.demo.enums.UserPermission.*;

import java.util.Set;

public enum UserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ, COURSE_READ, COURSE_WRITE, STUDENT_WRITE)),
    ADMINTRAINING(Sets.newHashSet(STUDENT_READ, COURSE_READ));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }
}
