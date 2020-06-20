package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManager.getNavigationHelper().goToGroupPage();
    int before = appManager.getGroupHelper().getGroupCount();
    appManager.getGroupHelper().createGroup(
            new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter"));
    int after = appManager.getGroupHelper().getGroupCount();
    Assert.assertEquals(++before, after);
    appManager.getSessionHelper().logOut();
  }
}
