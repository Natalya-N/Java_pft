package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void feelContactCreation(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        click(By.name("theform"));
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
        getFromSelectMenu(By.name("bday"), contactData.getDayOfBirth());
        getFromSelectMenu(By.name("bmonth"), contactData.getMonthOfBirth());
        type(By.name("byear"), contactData.getYearOfBirth());
        click(By.xpath("(//input[@name='submit'])[2]"));
    }
}



