package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    appManager.getNavigationHelper().goToGroupPage();
    List<GroupData> groupsBefore = appManager.getGroupHelper().getGroupList();
    GroupData group = new GroupData("TestGroupNull1", "TestGroupHeader", "TestGroupFooter");
    appManager.getGroupHelper().createGroup(group);
    List<GroupData> groupsAfter = appManager.getGroupHelper().getGroupList();
    Assert.assertEquals(groupsBefore.size()+1, groupsAfter.size());
    group.setId(groupsAfter.stream().max((Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    groupsBefore.add(group);
    Assert.assertEquals(new HashSet<Object>(groupsBefore), new HashSet<Object>(groupsAfter));
    appManager.getSessionHelper().logOut();
  }
}
