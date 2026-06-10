package com.banque.virements.shared.exception;

public class VirementNotFoundException extends RuntimeException{
    public VirementNotFoundException(String message) {
        super(message);
    }
}
