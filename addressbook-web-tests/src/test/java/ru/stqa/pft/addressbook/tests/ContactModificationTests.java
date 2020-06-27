package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!appManager.contact().isContactExists()) {
            create(new ContactData()
                    .withFirstName("Nata").withLastName("Nechaeva").withCompany("Company")
                    .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                    .withEmail("myemail@mailtest.com").withMobilePhone("89649943355").withGroup("test1"));

        }
    }

    @Test
    public void testContactModification() {
        Contacts contactsBefore = appManager.contact().all();
        ContactData modifiedContact = contactsBefore.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("newuuu").withLastName("Nechaeva").withCompany("Company")
                .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                .withEmail("myemail@mailtest.com").withMobilePhone("89649943355").withGroup("test1");
        appManager.contact().modifyById(contact);
        appManager.goTo().homePage();
        Contacts contactsAfter = appManager.contact().all();
        assertEquals(contactsBefore.size(), contactsAfter.size());
        assertThat(contactsAfter, equalTo(contactsBefore.without(modifiedContact).withAdded(contact)));
    }
}
