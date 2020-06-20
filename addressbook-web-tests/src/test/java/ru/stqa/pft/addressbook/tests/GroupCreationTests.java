package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManager.getNavigationHelper().goToGroupPage();
    List<GroupData> groupsBefore = appManager.getGroupHelper().getGroupList();
    appManager.getGroupHelper().createGroup(
            new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter"));
    List<GroupData> groupsAfter = appManager.getGroupHelper().getGroupList();
    Assert.assertEquals(groupsBefore.size()+1, groupsAfter.size());
    appManager.getSessionHelper().logOut();
  }
}
