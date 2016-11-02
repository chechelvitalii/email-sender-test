package com.chechel.repository;

import com.chechel.pojo.User;

import java.util.List;

/**
 * Created by vitaliy on 01.11.16.
 */
public interface UserRepository {
     List<User> fineAllActive();

}
