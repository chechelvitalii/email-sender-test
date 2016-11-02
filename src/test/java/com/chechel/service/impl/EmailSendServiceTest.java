package com.chechel.service.impl;

import com.chechel.repository.UserRepository;
import com.chechel.service.SendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by vitaliy on 01.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailSendServiceTest {
    @Mock
    private SendService sendService;
    @Mock
    private UserRepository userRepository;


    public void setUp(){
        sendService = new EmailSendService();
    }
    @Test
    public void send() throws Exception {
    }

}