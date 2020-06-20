package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletionTests() throws Exception {
    appManager.getNavigationHelper().goToGroupPage();
    if (!appManager.getGroupHelper().isGroupExists()) {
      appManager.getGroupHelper().createGroup
              (new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter"));
    }
    List<GroupData> groupsBefore = appManager.getGroupHelper().getGroupList();
    appManager.getGroupHelper().deleteGroup(groupsBefore.size()-1);
    appManager.getGroupHelper().returnToGroupPage();
    List<GroupData> groupsAfter = appManager.getGroupHelper().getGroupList();
    Assert.assertEquals(groupsBefore.size()-1, groupsAfter.size());
    groupsBefore.remove(groupsBefore.size()-1);
    Assert.assertEquals(groupsBefore, groupsAfter);
    appManager.getSessionHelper().logOut();
  }
}
