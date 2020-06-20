package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        if (!appManager.getContactHelper().isContactExists()){
            createContact(new ContactData("Natalya", "Nechaeva", "MyCompany",
                    "MyAddress", "+79643326754", "testjft@test.ru",
                    "26", "May", "1992", "TestGroupNull1"));
        }
        appManager.getContactHelper().selectContact();
        appManager.getContactHelper().deleteContact();
        appManager.getNavigationHelper().returnToHomePage();
        appManager.getSessionHelper().logOut();
    }
}
