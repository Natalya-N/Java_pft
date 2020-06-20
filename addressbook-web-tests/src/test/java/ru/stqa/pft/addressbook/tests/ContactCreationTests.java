package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> contactsBefore = appManager.getContactHelper().getContactList();
        createContact(new ContactData("Nata", "N", "MyCompany",
                "addr111", "+79647777777", "test777@test.ru",
                "26", "May", "1992", "TestGroupNull1"));
        List<ContactData> contactsAfter = appManager.getContactHelper().getContactList();
        Assert.assertEquals(contactsBefore.size()+1, contactsAfter.size());
        appManager.getSessionHelper().logOut();
    }

}
