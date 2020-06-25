package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.*;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        appManager.goTo().groupPage();
        if (appManager.group().all().size() == 0) {
            appManager.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> groupsBefore = appManager.group().all();
        GroupData modifiedGroup = groupsBefore.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("TestGroupNull12").withHeader("TestGroupHeader").withFooter("TestGroupFooter1");
        appManager.group().modify(group);
        Set<GroupData> groupsAfter = appManager.group().all();
        Assert.assertEquals(groupsBefore.size(), groupsAfter.size());
        groupsBefore.remove(modifiedGroup);
        groupsBefore.add(group);

        Assert.assertEquals(groupsBefore, groupsAfter);
    }
}
