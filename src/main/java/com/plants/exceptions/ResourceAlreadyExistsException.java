package com.plants.exceptions;

import lombok.Getter;
@Getter
public class ResourceAlreadyExistsException extends RuntimeException {
    private String name;
    private String attribute;
    private String attributeValue;

    public ResourceAlreadyExistsException(String name, String attribute, String attributeValue) {
        super();
        this.name = name;
        this.attribute = attribute;
        this.attributeValue = attributeValue;
    }
}
