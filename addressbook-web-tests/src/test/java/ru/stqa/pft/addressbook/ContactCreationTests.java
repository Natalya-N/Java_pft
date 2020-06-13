package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        goToAddNewPage();
        feelContactCreation(new ContactData("Natalya", "Nechaeva", "MyCompany",
                "MyAddress", "+79643326754", "testjft@test.ru",
                "26", "May", "1992"));
        returnToHomePage();
        logOut();
    }

}
