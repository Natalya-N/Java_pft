package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected ChromeDriver wd;

    public HelperBase(ChromeDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void getFromSelectMenu(By locator, String selectedValue) {
        click(By.name("bday"));
        getSelectedValue(locator, selectedValue);
        click(By.name("bday"));
    }

    protected void getSelectedValue(By locator, String value) {
        new Select(wd.findElement(locator)).selectByVisibleText(value);
    }
}
