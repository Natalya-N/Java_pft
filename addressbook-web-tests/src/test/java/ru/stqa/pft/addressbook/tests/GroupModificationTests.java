package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.*;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        appManager.goTo().groupPage();
        if (appManager.group().list().size() == 0) {
            appManager.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> groupsBefore = appManager.group().list();
        int modifiedGroup = groupsBefore.size()-1;
        GroupData group = new GroupData()
                .withId(groupsBefore.get(modifiedGroup).getId()).withName("TestGroupNull12").withHeader("TestGroupHeader").withFooter("TestGroupFooter1");
        appManager.group().modify(modifiedGroup, group);
        List<GroupData> groupsAfter = appManager.group().list();
        Assert.assertEquals(groupsBefore.size(), groupsAfter.size());
        groupsBefore.remove(modifiedGroup);
        groupsBefore.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        groupsBefore.sort(byId);
        groupsAfter.sort(byId);
        Assert.assertEquals(groupsBefore, groupsAfter);
    }
}
