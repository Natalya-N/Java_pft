package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        int before = appManager.getContactHelper().getContactCount();
        if (!appManager.getContactHelper().isContactExists()){
            createContact(new ContactData("Natalya", "Nechaeva", "MyCompany",
                    "MyAddress", "+79643326754", "testjft@test.ru",
                    "26", "May", "1992", "TestGroupNull1"));
            before++;
        }
        appManager.getContactHelper().selectContact(before-1);
        appManager.getContactHelper().deleteContact();
        appManager.getNavigationHelper().returnToHomePage();
        int after = appManager.getContactHelper().getContactCount();
        Assert.assertEquals(--before, after);
        appManager.getSessionHelper().logOut();
    }
}
