package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManager.getNavigationHelper().goToGroupPage();
    appManager.getGroupHelper().createGroup(
            new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter"));
    appManager.getSessionHelper().logOut();
  }
}
