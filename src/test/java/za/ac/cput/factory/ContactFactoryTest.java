package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    @Test
    void buildContact() {
        Contact contact = ContactFactory.buildContact("Brian@gmail.com","0813798635","0112345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void BuildContactThatFailsEmail() {
        Contact contact = ContactFactory.buildContact("221013962","0813798635","0112345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void buildContactThatFailsMobile() {
        Contact con = ContactFactory.buildContact("221013962@mycput.ac.za", "0813786", "0112345678");
        assertNotNull(con);
        System.out.println(con);
    }

    @Test
    void buildContactThatF() {
        Contact con = ContactFactory.buildContact("221013962@mycput.ac.za", "0813786");
        assertNotNull(con);
        System.out.println(con);
    }

    @Test
    void buildContactThatP() {
        Contact con = ContactFactory.buildContact("221013962@mycput.ac.za", "0813786356");
        assertNotNull(con);
        System.out.println(con);
    }
}