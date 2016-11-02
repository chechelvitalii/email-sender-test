package com.chechel.service.impl;

import com.chechel.pojo.User;
import com.chechel.service.SendService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaliy on 01.11.16.
 */
public class EmailSendService implements SendService {

    private static final int DEFAULT_THREAD_POOL = 5;
    private ExecutorService executorService;

    public EmailSendService() {
        executorService = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL);
    }

    public EmailSendService(int threadPool) {
        executorService = Executors.newFixedThreadPool(threadPool);
    }

    @Override
    public void send(List<User> users) throws InterruptedException {
        users.stream()
                .forEach(user->executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Try send email to "+user.getName());
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println("Email has been sent to "+user.getName());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }));

        executorService.shutdown();
    }
}
