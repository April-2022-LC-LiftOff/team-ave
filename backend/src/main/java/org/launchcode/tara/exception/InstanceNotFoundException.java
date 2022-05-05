package org.launchcode.tara.exception;

public class InstanceNotFoundException extends RuntimeException{
    public InstanceNotFoundException(String message){
        super(message);
    }
}
