package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        appManager.getContactHelper().selectContact();
        appManager.getContactHelper().deleteContact();
        appManager.getNavigationHelper().returnToHomePage();
    }

}
