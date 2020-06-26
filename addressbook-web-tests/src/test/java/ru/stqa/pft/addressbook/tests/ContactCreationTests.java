package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Set<ContactData> contactsBefore = appManager.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Nata").withLastName("Nechaeva").withCompany("Company")
                .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                .withEmail("myemail@mailtest.com").withMobilePhone("89649943355").withGroup("test1");
        create(contact);
        Set<ContactData> contactsAfter = appManager.contact().all();
        Assert.assertEquals(contactsBefore.size() + 1, contactsAfter.size());
        contact.withId(contactsAfter.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        contactsBefore.add(contact);
        Assert.assertEquals(contactsBefore, contactsAfter);
    }
}
