package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        appManager.goTo().groupPage();
        Groups groupsBefore = appManager.group().all();
        GroupData group = new GroupData().withName("test134");
        appManager.group().create(group);
        Groups groupsAfter = appManager.group().all();
        assertThat(groupsAfter.size(), equalTo(groupsBefore.size() + 1));
        assertThat(groupsAfter, equalTo(
                groupsBefore.withAdded(group.withId(groupsAfter.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
