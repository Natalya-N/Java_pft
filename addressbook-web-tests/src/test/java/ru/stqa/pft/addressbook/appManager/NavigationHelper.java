package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {
    private ChromeDriver wd;

    public NavigationHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void goToAddNewPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void goToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }
}
