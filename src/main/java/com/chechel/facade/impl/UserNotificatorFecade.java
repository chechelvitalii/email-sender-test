package com.chechel.facade.impl;

import com.chechel.facade.UserNotificatorFacade;
import com.chechel.pojo.User;
import com.chechel.repository.UserRepository;
import com.chechel.service.SendService;

import java.util.List;

/**
 * Created by vitaliy on 01.11.16.
 */
public class UserNotificatorFecade implements UserNotificatorFacade {
    private final SendService sendService;
    private final UserRepository userRepository;

    public UserNotificatorFecade(SendService sendService, UserRepository userRepository) {
        this.sendService = sendService;
        this.userRepository = userRepository;
    }

    @Override
    public void notifyAllUsers() throws InterruptedException {
        List<User> users = userRepository.fineAllActive();
        sendService.send(users);
    }
}
