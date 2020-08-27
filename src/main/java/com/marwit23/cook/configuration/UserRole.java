package com.marwit23.cook.configuration;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.marwit23.cook.configuration.UserPermission.*;

public enum UserRole {

    ADMIN(new HashSet<>(Arrays.asList(USER_READ, USER_WRITE))),
    USER(new HashSet<>(Arrays.asList(USER_READ)));

    private Set<UserPermission> userPermissions;

    UserRole(Set<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public Set<UserPermission> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(Set<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }
}
