package com.chechel.service.impl;

import com.chechel.pojo.STATE;
import com.chechel.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static org.mockito.Mockito.*;

/**
 * Created by vitaliy on 01.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailSendServiceTest {

    @Mock
    private ExecutorService executorService;
    @InjectMocks
    private EmailSendService emailSendService;

    @Test
    public void shouldSendEmails() throws Exception {
        //GIVEN
        List<User> users = Arrays.asList(new User("Tom", STATE.ACTIVE), new User("Robert", STATE.ACTIVE));
        //WHEN
        emailSendService.send(users);
        //THEN
        verify(executorService, times(2)).execute(any(Runnable.class));
    }

}