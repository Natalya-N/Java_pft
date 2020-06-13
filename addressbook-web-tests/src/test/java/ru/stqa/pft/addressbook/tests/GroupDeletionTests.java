package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletionTests() throws Exception {
    appManager.goToGroupPage();
    appManager.selectGroup();
    appManager.deleteGroup();
    appManager.returnToGroupPage();
    appManager.logOut();
  }
}
