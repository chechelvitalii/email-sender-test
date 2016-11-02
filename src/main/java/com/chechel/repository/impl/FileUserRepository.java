package com.chechel.repository.impl;

import com.chechel.exception.RepositoryNotFound;
import com.chechel.pojo.STATE;
import com.chechel.pojo.User;
import com.chechel.repository.UserRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vitaliy on 01.11.16.
 */
public class FileUserRepository implements UserRepository {

    private static final String NAME_AND_STATE_SEPARATOR = " ";

    private List<User> storedUsers = new ArrayList<>();

    public FileUserRepository(String repositoryLocation) throws URISyntaxException {
        load(repositoryLocation);
    }

    public List<User> fineAllActive() {
        return storedUsers.stream()
                .filter(user -> STATE.ACTIVE == user.getState())
                .collect(Collectors.toList());
    }

    private void load(String repositoryLocation) {
        URL resource = Optional.ofNullable(getClass().getResource(repositoryLocation))
                .orElseThrow(() -> new RepositoryNotFound(repositoryLocation));

        try (Stream<String> lines = Files.lines(Paths.get(resource.toURI()))) {
            lines.forEach(data -> storedUsers.add(parseUser(data)));
        } catch (IOException | URISyntaxException e) {
            System.err.println("Problem with reading storage file");
            e.printStackTrace();
        }
    }

    private User parseUser(String data) {
        String[] split = data.split(NAME_AND_STATE_SEPARATOR);
        return new User(split[0].trim(), STATE.valueOf(split[1].trim()));
    }
}
