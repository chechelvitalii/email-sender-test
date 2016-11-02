package com.chechel.exception;

public class RepositoryNotFound extends RuntimeException {
    public RepositoryNotFound(String repositoryLocation) {
        super("Repository not found : "+repositoryLocation);
    }
}
