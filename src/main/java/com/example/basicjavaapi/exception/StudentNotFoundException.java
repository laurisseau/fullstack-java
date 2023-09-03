package com.example.basicjavaapi.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(int id){
        super("Could not find user with the id " + id);
    }
}
