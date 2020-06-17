package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {
        appManager.getContactHelper().selectContact();
        appManager.getContactHelper().modifyContact();
        appManager.getContactHelper().feelContactCreation(new ContactData("ModifiedName", "Nechaeva", "ModifiedCompany",
                "MyAddress", "+79643326754", "testjft@test.ru",
                "26", "May", "1992", null));
        appManager.getContactHelper().updateContact();
        appManager.getContactHelper().returnToHomePage();
        appManager.getSessionHelper().logOut();
    }
}
