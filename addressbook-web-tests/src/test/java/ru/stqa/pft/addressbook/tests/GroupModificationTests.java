package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        appManager.getNavigationHelper().goToGroupPage();
        int before = appManager.getGroupHelper().getGroupCount();
        if (!appManager.getGroupHelper().isGroupExists()) {
            appManager.getGroupHelper().createGroup
                    (new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter"));
            before++;
        }
        appManager.getGroupHelper().selectGroup(before-1);
        appManager.getGroupHelper().modifyGroup();
        appManager.getGroupHelper().fillGroupForm(new GroupData("TestGroupNull12", "TestGroupHeader", "TestGroupFooter1"));
        appManager.getGroupHelper().updateGroup();
        appManager.getGroupHelper().returnToGroupPage();
        int after = appManager.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after);
        appManager.getSessionHelper().logOut();
    }
}
