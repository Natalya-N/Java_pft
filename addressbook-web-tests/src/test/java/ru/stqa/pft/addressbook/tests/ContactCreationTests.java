package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> contactsBefore = appManager.getContactHelper().getContactList();
        ContactData contact = new ContactData("Nata", "N", "MyCompany",
                "addr111", "+79647777777", "test777@test.ru",
                "26", "May", "1992", "TestGroupNull1");
        createContact(contact);
        List<ContactData> contactsAfter = appManager.getContactHelper().getContactList();
        Assert.assertEquals(contactsBefore.size() + 1, contactsAfter.size());
        contactsBefore.add(contact);

        Comparator<? super ContactData> byName = new Comparator<ContactData>() {
            @Override
            public int compare(ContactData o1, ContactData o2) {
                int result = o1.getFirstName().compareTo(o2.getFirstName());
                if (result == 0) {
                    result = o1.getLastName().compareTo(o2.getLastName());
                }
                return result;
            }
        };

        contactsAfter.sort(byName);
        contactsBefore.sort(byName);
        Assert.assertEquals(contactsBefore, contactsAfter);
        appManager.getSessionHelper().logOut();
    }
}
