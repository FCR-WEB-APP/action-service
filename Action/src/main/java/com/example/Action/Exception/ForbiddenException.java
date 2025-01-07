package com.example.Action.Exception;

public class ForbiddenException extends  RuntimeException{
    public ForbiddenException(String message){
        super(message);
    }

    public ForbiddenException(){
        super("Invalid token: 403 Forbidden");
    }
}
