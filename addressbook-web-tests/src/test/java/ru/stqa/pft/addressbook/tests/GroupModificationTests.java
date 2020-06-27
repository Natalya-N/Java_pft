package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        appManager.goTo().groupPage();
        if (appManager.group().all().size() == 0) {
            appManager.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups groupsBefore = appManager.group().all();
        GroupData modifiedGroup = groupsBefore.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("123TestGroupNull99")
                .withHeader("TestGroupHeader").withFooter("TestGroupFooter1");
        appManager.group().modify(group);
        Groups groupsAfter = appManager.group().all();
        assertEquals(groupsBefore.size(), groupsAfter.size());
        assertThat(groupsBefore.without(modifiedGroup).withAdded(group), equalTo(groupsAfter));
    }
}
