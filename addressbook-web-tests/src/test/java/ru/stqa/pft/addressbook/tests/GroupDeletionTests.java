package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletionTests() throws Exception {
    appManager.getNavigationHelper().goToGroupPage();
    if (!appManager.getGroupHelper().isGroupExists()) {
      appManager.getGroupHelper().createGroup
              (new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter"));
    }
    appManager.getGroupHelper().selectGroup();
    appManager.getGroupHelper().deleteGroup();
    appManager.getGroupHelper().returnToGroupPage();
    appManager.getSessionHelper().logOut();
  }
}
