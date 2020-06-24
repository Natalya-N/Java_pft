package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> contactsBefore = appManager.contact().getContactList();
        int index = contactsBefore.size() - 2;
        ContactData contact = new ContactData()
                .withFirstName("ModifiedNata").withLastName("Nechaeva").withCompany("Company")
                .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                .withEmail("myemail@mailtest.com").withMobilePhone("89649943355").withGroup("test1");
        appManager.contact().modify(index, contact);
        appManager.goTo().homePage();
        List<ContactData> contactsAfter = appManager.contact().getContactList();
        Assert.assertEquals(contactsBefore.size(), contactsAfter.size());
        contactsBefore.remove(index);
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
    }
}
