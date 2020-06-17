package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManager.getNavigationHelper().goToGroupPage();
    appManager.getGroupHelper().initGroupCreation();
    appManager.getGroupHelper().fillGroupForm(new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter"));
    appManager.getGroupHelper().submitGroupCreation();
    appManager.getGroupHelper().returnToGroupPage();
    appManager.getSessionHelper().logOut();
  }
}
