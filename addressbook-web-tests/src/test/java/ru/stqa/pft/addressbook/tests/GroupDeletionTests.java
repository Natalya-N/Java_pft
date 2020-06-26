package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        appManager.goTo().groupPage();
        if (appManager.group().all().size() == 0) {
            appManager.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletionTests() throws Exception {
        Set<GroupData> groupsBefore = appManager.group().all();
        GroupData deletedGroup = groupsBefore.iterator().next();
        appManager.group().delete(deletedGroup);
        Set<GroupData> groupsAfter = appManager.group().all();
        Assert.assertEquals(groupsBefore.size() - 1, groupsAfter.size());
        groupsBefore.remove(deletedGroup);
        Assert.assertEquals(groupsBefore, groupsAfter);
    }
}
