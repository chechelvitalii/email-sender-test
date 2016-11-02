package com.chechel.service;

import com.chechel.pojo.User;

import java.util.List;

/**
 * Created by vitaliy on 01.11.16.
 */
public interface SendService {
     void send(List<User> users) throws InterruptedException;
}
