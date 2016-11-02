package com.chechel.facade.impl;

import com.chechel.pojo.User;
import com.chechel.repository.UserRepository;
import com.chechel.service.SendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vitaliy on 01.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserNotificatorFacadeTest {

    @Mock
    private SendService sendService;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserNotificatorFacade notificatorFacade;

    @Test
    public void shouldNotifyAllUsers() throws Exception {
        //GIVEN
        when(userRepository.fineAllActive()).thenReturn(Collections.emptyList());
        //WHEN
        notificatorFacade.notifyAllUsers();
        //THEN
        verify(userRepository).fineAllActive();
        verify(sendService).send(anyListOf(User.class));
    }

}