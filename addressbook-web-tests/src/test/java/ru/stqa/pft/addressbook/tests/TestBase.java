package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appManager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager appManager = new ApplicationManager();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        appManager.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        appManager.stop();
    }

}
