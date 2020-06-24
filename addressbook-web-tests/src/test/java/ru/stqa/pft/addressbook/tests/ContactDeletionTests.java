package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

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
        List<ContactData> contactsBefore = appManager.contact().getContactList();
        appManager.contact().delete(contactsBefore);
        appManager.goTo().homePage();
        List<ContactData> contactsAfter = appManager.contact().getContactList();
        Assert.assertEquals(contactsBefore.size()-1, contactsAfter.size());
        contactsBefore.remove(contactsBefore.size()-1);
        Assert.assertEquals(contactsBefore, contactsAfter);
    }
}
