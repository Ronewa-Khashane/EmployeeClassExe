package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

import static za.ac.cput.util.Helper.isValidEmail;


public class ContactFactory {
public static Contact buildContact(String email, String mobile, String workTelephone){
    if(!Helper.isValidEmail(email))
        return null;
    if(!Helper.isTenDigits(mobile)||
        !Helper.isTenDigits(workTelephone))
        return null;

return new Contact.Builder().setEmail(email)
        .setMobile(mobile)
        .setWorkTelephone(workTelephone)
        .build();
}

public static Contact buildContact(String email, String mobile){
    if(!Helper.isValidEmail(email))
    return null;
    if(!Helper.isTenDigits(mobile))
        return null;

    return new Contact.Builder().setEmail(email)
            .setMobile(mobile)
            .build();
}
}

