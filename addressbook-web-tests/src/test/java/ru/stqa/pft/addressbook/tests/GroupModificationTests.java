package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        appManager.getNavigationHelper().goToGroupPage();
        appManager.getGroupHelper().selectGroup();
        appManager.getGroupHelper().modifyGroup();
        appManager.getGroupHelper().fillGroupForm(new GroupData("TestGroupModified", "TestGroupHeaderModified", "TestGroupFooterModified"));
        appManager.getGroupHelper().updateGroup();
        appManager.getGroupHelper().returnToGroupPage();
        appManager.getSessionHelper().logOut();
    }
}
