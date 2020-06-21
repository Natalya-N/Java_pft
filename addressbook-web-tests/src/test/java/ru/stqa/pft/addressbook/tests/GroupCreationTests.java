package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

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
    int max = 0;
    for (GroupData g : groupsAfter){
      if(g.getId() > max){
      max = g.getId();
      }
    }
    group.setId(max);
    groupsBefore.add(group);
    Assert.assertEquals(new HashSet<Object>(groupsBefore), new HashSet<Object>(groupsAfter));
    appManager.getSessionHelper().logOut();
  }
}
