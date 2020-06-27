package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts contactsBefore = appManager.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Natalya").withLastName("LastName").withCompany("Company")
                .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                .withEmail("my123email@mailtest.com").withMobilePhone("87779943355").withGroup("test1");
        create(contact);
        Contacts contactsAfter = appManager.contact().all();
        assertEquals(contactsBefore.size() + 1, contactsAfter.size());
        assertThat(contactsAfter, equalTo(contactsBefore
                .withAdded(contact.withId(contactsAfter.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
