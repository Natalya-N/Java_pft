package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManager.goTo().groupPage();
    Set<GroupData> groupsBefore = appManager.group().all();
    GroupData group = new GroupData().withName("test1");
    appManager.group().create(group);
    Set<GroupData> groupsAfter = appManager.group().all();
    Assert.assertEquals(groupsBefore.size()+1, groupsAfter.size());
    group.withId(groupsAfter.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    groupsBefore.add(group);
    Assert.assertEquals(groupsBefore, groupsAfter);
  }
}
