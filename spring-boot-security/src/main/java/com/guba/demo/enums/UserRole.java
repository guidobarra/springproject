package com.guba.demo.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static  com.guba.demo.enums.UserPermission.*;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ, COURSE_READ, COURSE_WRITE, STUDENT_WRITE)),
    ADMINTRAINING(Sets.newHashSet(STUDENT_READ, COURSE_READ));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {

        // add all permission
        Set<SimpleGrantedAuthority> rolePermissions = permissions
                                                .stream()
                                                .map(p -> new SimpleGrantedAuthority(p.getPermission()))
                                                .collect(Collectors.toSet());

        // add role
        rolePermissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return rolePermissions;
    }
}
