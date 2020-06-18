package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        if (!appManager.getContactHelper().isContactExists()){
            appManager.getNavigationHelper().goToAddNewPage();
            appManager.getContactHelper().createContact(new ContactData("Natalya", "Nechaeva", "MyCompany",
                    "MyAddress", "+79643326754", "testjft@test.ru",
                    "26", "May", "1992", "TestGroupNull1"), true);
            appManager.getNavigationHelper().returnToHomePage();
        }
        appManager.getContactHelper().selectContact();
        appManager.getContactHelper().deleteContact();
        appManager.getNavigationHelper().returnToHomePage();
    }

}
