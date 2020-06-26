package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (!appManager.contact().isContactExists()) {
            create(new ContactData()
                    .withFirstName("Nata").withLastName("Nechaeva").withCompany("Company")
                    .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                    .withEmail("myemail@mailtest.com").withMobilePhone("89649943355").withGroup("test1"));

        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> contactsBefore = appManager.contact().all();
        ContactData modifiedContact = contactsBefore.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("RRModifiedNata").withLastName("Nechaeva").withCompany("Company")
                .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                .withEmail("myemail@mailtest.com").withMobilePhone("89649943355").withGroup("test1");
        appManager.contact().modifyById(contact);
        appManager.goTo().homePage();
        Set<ContactData> contactsAfter = appManager.contact().all();
        Assert.assertEquals(contactsBefore.size(), contactsAfter.size());
        contactsBefore.remove(modifiedContact);
        contactsBefore.add(contact);
        Assert.assertEquals(contactsBefore, contactsAfter);
    }
}
