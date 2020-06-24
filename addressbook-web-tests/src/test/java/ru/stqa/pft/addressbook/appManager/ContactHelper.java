package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void feelContactCreation(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
        getFromSelectMenu(By.name("bday"), contactData.getDayOfBirth());
        getFromSelectMenu(By.name("bmonth"), contactData.getMonthOfBirth());
        type(By.name("byear"), contactData.getYearOfBirth());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void clickCreateContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void modifyContact(int index) {
        if (index == 0) {
            click(By.xpath("//img[@alt='Edit']"));
        } else {
            click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
        }
    }

    public void updateContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }


    public void createContact(ContactData contactData, boolean creation) {
        feelContactCreation(contactData, creation);
        clickCreateContact();
    }

    public void modifyGroup(int modifiedContact, ContactData contact) {
        modifyContact(modifiedContact);
        feelContactCreation(contact, false);
        updateContact();
    }

    public boolean isContactExists() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name = \"entry\"]"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            ContactData contactData = new ContactData(cells.get(2).getText(), cells.get(1).getText());
            contacts.add(contactData);
        }
        return contacts;
    }
}



