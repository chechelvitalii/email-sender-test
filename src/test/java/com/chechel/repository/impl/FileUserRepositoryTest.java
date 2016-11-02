package com.chechel.repository.impl;

import com.chechel.exception.RepositoryNotFound;
import com.chechel.pojo.User;
import com.chechel.repository.UserRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * Created by vitaliy on 01.11.16.
 */

public class FileUserRepositoryTest {

    private static final String TEST_REPOSITORY_LOCATION = "/testStorage";
    private static final String NOT_EXISTING_REPOSITORY_LOCATION = "/notExistiogStorage";

    private UserRepository userRepository;

    @Before
    public void setUp() throws URISyntaxException {
        userRepository = new FileUserRepository(TEST_REPOSITORY_LOCATION);
    }

    @Test(expected = RepositoryNotFound.class)
    public void shouldThrowExceptionIfRepositoryLocationWrong() throws Exception {
        userRepository = new FileUserRepository(NOT_EXISTING_REPOSITORY_LOCATION);
    }


    @Test
    public void shouldFineAllActive() throws Exception {
        List<User> users = userRepository.fineAllActive();
        assertThat(users, Matchers.hasSize(6));
    }

}