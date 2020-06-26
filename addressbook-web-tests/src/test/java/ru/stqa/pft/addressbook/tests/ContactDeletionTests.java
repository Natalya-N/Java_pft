package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (!appManager.contact().isContactExists()){
            create(new ContactData().withFirstName("Nata").withLastName("Nechaeva").withCompany("Company")
                    .withAddress("My address").withDayOfBirth("26").withMonthOfBirth("May").withYearOfBirth("1992")
                    .withEmail("myemail@mailtest.com").withMobilePhone("89649943355").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() {
        Set<ContactData> contactsBefore = appManager.contact().all();
        ContactData deletedContact = contactsBefore.iterator().next();
        appManager.contact().deleteById(deletedContact);
        appManager.goTo().homePage();
        Set<ContactData> contactsAfter = appManager.contact().all();
        Assert.assertEquals(contactsBefore.size()-1, contactsAfter.size());
        contactsBefore.remove(deletedContact);
        Assert.assertEquals(contactsBefore, contactsAfter);
    }
}
