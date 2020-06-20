package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        appManager.getNavigationHelper().goToGroupPage();
        if (!appManager.getGroupHelper().isGroupExists()) {
            appManager.getGroupHelper().createGroup
                    (new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter"));
        }
        List<GroupData> groupsBefore = appManager.getGroupHelper().getGroupList();
        System.out.println(groupsBefore.size());
        appManager.getGroupHelper().selectGroup(groupsBefore.size()-1);
        appManager.getGroupHelper().modifyGroup();
        appManager.getGroupHelper().fillGroupForm(new GroupData("TestGroupNull12", "TestGroupHeader", "TestGroupFooter1"));
        appManager.getGroupHelper().updateGroup();
        appManager.getGroupHelper().returnToGroupPage();
        appManager.getGroupHelper().selectGroup(groupsBefore.size()-1);
        List<GroupData> groupsAfter = appManager.getGroupHelper().getGroupList();
        System.out.println(groupsAfter.size());
        Assert.assertEquals(groupsBefore.size(), groupsAfter.size());
        Assert.assertEquals(groupsBefore, groupsAfter);
        appManager.getSessionHelper().logOut();
    }
}
