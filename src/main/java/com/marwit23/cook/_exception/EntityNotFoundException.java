package com.marwit23.cook._exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityType, String entityId) {
        super("Could not find "+ entityType + " with id=" + entityId);
    }
}
