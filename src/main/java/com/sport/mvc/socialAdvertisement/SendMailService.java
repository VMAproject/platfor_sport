package com.sport.mvc.socialAdvertisement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * Created by bjj on 19.10.2016.ct, S
 */
public interface SendMailService {
    void sendMailTo(String mail, String subject, String body, String emailFrom, String passwordFrom) throws AddressException, MessagingException;
}
