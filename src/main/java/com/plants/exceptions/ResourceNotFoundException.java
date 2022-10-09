package com.plants.exceptions;

import lombok.Getter;

import java.util.UUID;
@Getter
public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;
    private final String resourceId;

    public ResourceNotFoundException(String resourceName, UUID resourceId) {
        super();
        this.resourceName = resourceName;
        this.resourceId = resourceId.toString();
    }

    public ResourceNotFoundException(String resourceName, String resourceValue) {
        super();
        this.resourceName = resourceName;
        this.resourceId = resourceValue;
    }
}
