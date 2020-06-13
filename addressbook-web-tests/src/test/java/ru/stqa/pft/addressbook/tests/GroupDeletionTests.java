package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletionTests() throws Exception {
    appManager.getNavigationHelper().goToGroupPage();
    appManager.getGroupHelper().selectGroup();
    appManager.getGroupHelper().deleteGroup();
    appManager.getGroupHelper().returnToGroupPage();
    appManager.logOut();
  }
}
