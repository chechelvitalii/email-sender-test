package com.chechel;

import com.chechel.facade.NotificatorFacade;
import com.chechel.facade.impl.UserNotificatorFacade;
import com.chechel.repository.UserRepository;
import com.chechel.repository.impl.FileUserRepository;
import com.chechel.service.SendService;
import com.chechel.service.impl.EmailSendService;

import java.net.URISyntaxException;

/**
 * Created by vitaliy on 01.11.16.
 */
public class ClientRunner {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        String storageLocation = "/userStorage";
        SendService sendService = new EmailSendService();
        UserRepository userRepository = new FileUserRepository(storageLocation);

        NotificatorFacade notificatorFacade = new UserNotificatorFacade(sendService, userRepository);
        notificatorFacade.notifyAllUsers();
    }
}
