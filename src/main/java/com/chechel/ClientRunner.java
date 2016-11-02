package com.chechel;

import com.chechel.facade.UserNotificatorFacade;
import com.chechel.facade.impl.UserNotificatorFecade;
import com.chechel.pojo.User;
import com.chechel.repository.UserRepository;
import com.chechel.repository.impl.FileUserRepository;
import com.chechel.service.SendService;
import com.chechel.service.impl.EmailSendService;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by vitaliy on 01.11.16.
 */
public class ClientRunner {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        System.out.println("###START###");
                String storageLocation = "/userStorage";
        SendService sendService = new EmailSendService();
        UserRepository userRepository = new FileUserRepository(storageLocation);

        UserNotificatorFacade notificatorFacade = new UserNotificatorFecade(sendService, userRepository);
        notificatorFacade.notifyAllUsers();

        System.out.println("###FINISH###");
    }
}
