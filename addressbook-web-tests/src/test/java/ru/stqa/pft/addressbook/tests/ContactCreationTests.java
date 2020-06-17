package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        appManager.getNavigationHelper().goToAddNewPage();
        appManager.getContactHelper().feelContactCreation(new ContactData("Natalya", "Nechaeva", "MyCompany",
                "MyAddress", "+79643326754", "testjft@test.ru",
                "26", "May", "1992", "TestGroupNull1"), true);
        appManager.getContactHelper().createContact();
        appManager.getContactHelper().returnToHomePage();
        appManager.getSessionHelper().logOut();
    }

}
