package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManager.goTo().groupPage();
    List<GroupData> groupsBefore = appManager.group().list();
    GroupData group = new GroupData().withName("test2");
    appManager.group().create(group);
    List<GroupData> groupsAfter = appManager.group().list();
    Assert.assertEquals(groupsBefore.size()+1, groupsAfter.size());
    //group.setId(groupsAfter.stream().max((Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    groupsBefore.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    groupsBefore.sort(byId);
    groupsAfter.sort(byId);
    Assert.assertEquals(groupsBefore, groupsAfter);
  }
}
