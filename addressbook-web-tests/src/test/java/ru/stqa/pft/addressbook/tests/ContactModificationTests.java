package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {

        if (!appManager.getContactHelper().isContactExists()) {
            createContact(new ContactData("Natalya", "Nechaeva", "MyCompany",
                    "MyAddress", "+79643326754", "testjft@test.ru",
                    "26", "May", "1992", "TestGroupNull1"));
        }
        List<ContactData> contactsBefore = appManager.getContactHelper().getContactList();
        int modifiedContact = contactsBefore.size() - 2;
        appManager.getContactHelper().modifyContact(modifiedContact);
        ContactData contact = new ContactData("AewModifiedName", "Nechaeva", "ModifiedCompany",
                "MyAddress", "+79643326754", "testjft@test.ru",
                "26", "May", "1992", null);
        appManager.getContactHelper().feelContactCreation(contact, false);
        appManager.getContactHelper().updateContact();
        appManager.getNavigationHelper().returnToHomePage();
        List<ContactData> contactsAfter = appManager.getContactHelper().getContactList();
        Assert.assertEquals(contactsBefore.size(), contactsAfter.size());
        contactsBefore.remove(modifiedContact);
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
