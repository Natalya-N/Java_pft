package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        if (!appManager.getContactHelper().isContactExists()){
            createContact(new ContactData("Natalya", "Nechaeva", "MyCompany",
                    "MyAddress", "+79643326754", "testjft@test.ru",
                    "26", "May", "1992", "TestGroupNull1"));
        }
        List<ContactData> contactsBefore = appManager.getContactHelper().getContactList();
        appManager.getContactHelper().selectContact(contactsBefore.size()-1);
        appManager.getContactHelper().deleteContact();
        appManager.getNavigationHelper().returnToHomePage();
        List<ContactData> contactsAfter = appManager.getContactHelper().getContactList();
        Assert.assertEquals(contactsBefore.size()-1, contactsAfter.size());
        contactsBefore.remove(contactsBefore.size()-1);
        Assert.assertEquals(contactsBefore, contactsAfter);
    }
}
