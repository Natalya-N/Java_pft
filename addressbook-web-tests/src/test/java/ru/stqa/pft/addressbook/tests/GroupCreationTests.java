package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManager.goToGroupPage();
    appManager.initGroupCreation();
    appManager.fillGroupForm(new GroupData("TestGroup", "TestGroupHeader", "TestGroupFooter"));
    appManager.submitGroupCreation();
    appManager.returnToGroupPage();
    appManager.logOut();
  }
}
