package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    appManager.goTo().groupPage();
    if (appManager.group().list().size() == 0) {
      appManager.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletionTests() throws Exception {
    List<GroupData> groupsBefore = appManager.group().list();
    int index = groupsBefore.size()-1;
    appManager.group().delete(index);
    List<GroupData> groupsAfter = appManager.group().list();
    Assert.assertEquals(groupsBefore.size()-1, groupsAfter.size());
    groupsBefore.remove(index);
    Assert.assertEquals(groupsBefore, groupsAfter);
  }
}
