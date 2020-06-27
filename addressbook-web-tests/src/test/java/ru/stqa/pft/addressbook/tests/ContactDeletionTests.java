package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!appManager.contact().isContactExists()) {
            create(new ContactData().withFirstName("Nata").withLastName("Nechaeva").withCompany("Company")
                    .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                    .withEmail("myemail@mailtest.com").withMobilePhone("89649943355").withGroup("test134"));
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts contactsBefore = appManager.contact().all();
        ContactData deletedContact = contactsBefore.iterator().next();
        appManager.contact().deleteById(deletedContact);
        appManager.goTo().homePage();
        Contacts contactsAfter = appManager.contact().all();
        assertEquals(contactsBefore.size() - 1, contactsAfter.size());
        assertThat(contactsBefore.without(deletedContact), equalTo(contactsAfter));
    }
}
