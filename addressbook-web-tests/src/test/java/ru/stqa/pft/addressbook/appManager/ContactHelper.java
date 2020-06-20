package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void modifyContact() {
        click(By.xpath("//img[@alt='Edit']"));
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

    public boolean isContactExists() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}



