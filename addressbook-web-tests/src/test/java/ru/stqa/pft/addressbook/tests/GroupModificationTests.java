package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
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
        int modifiedGroup = groupsBefore.size()-1;
        appManager.getGroupHelper().selectGroup(modifiedGroup);
        appManager.getGroupHelper().modifyGroup();
        GroupData group = new GroupData(groupsBefore.get(modifiedGroup).getId(), "TestGroupNull12", "TestGroupHeader", "TestGroupFooter1");
        appManager.getGroupHelper().fillGroupForm(group);
        appManager.getGroupHelper().updateGroup();
        appManager.getGroupHelper().returnToGroupPage();
        List<GroupData> groupsAfter = appManager.getGroupHelper().getGroupList();
        Assert.assertEquals(groupsBefore.size(), groupsAfter.size());
        groupsBefore.remove(modifiedGroup);
        groupsBefore.add(group);
        Assert.assertEquals(new HashSet<Object>(groupsBefore), new HashSet<Object>(groupsAfter));
        appManager.getSessionHelper().logOut();
    }
}
