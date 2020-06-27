package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups groupsBefore = appManager.group().all();
        GroupData deletedGroup = groupsBefore.iterator().next();
        appManager.group().delete(deletedGroup);
        Groups groupsAfter = appManager.group().all();
        assertEquals(groupsBefore.size() - 1, groupsAfter.size());
        assertThat(groupsAfter, equalTo(groupsBefore.without(deletedGroup)));
    }
}
