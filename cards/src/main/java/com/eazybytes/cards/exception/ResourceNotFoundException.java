package com.eazybytes.cards.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName, String fieldNamme, String fieldValue){
        super(String.format("@s not found with the given inout data %s : '%s'", resourceName, fieldNamme, fieldValue));
    }
}
