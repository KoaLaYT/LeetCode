package _20220907_FlattenNestedListIterator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NestedIteratorTest {

  @Test
  public void test1() {
    List<NestedInteger> nestedInteger = Arrays.asList(
        new NestedIntegerArrayImpl(Arrays.asList(1, 1)),
        new NestedIntegerIntImpl(2),
        new NestedIntegerArrayImpl(Arrays.asList(1, 1))
    );
    NestedIterator nestedIterator = new NestedIterator(nestedInteger);

    List<Integer> flatten = new ArrayList<>();
    while (nestedIterator.hasNext()) {
      flatten.add(nestedIterator.next());
    }
    Assert.assertEquals(flatten, Arrays.asList(1, 1, 2, 1, 1));
  }

  @Test
  public void test2() {
    List<NestedInteger> nestedInteger = Arrays.asList(
        new NestedIntegerIntImpl(1),
        new NestIntegerImpl(Arrays.asList(
            new NestedIntegerIntImpl(4),
            new NestedIntegerArrayImpl(Arrays.asList(6))
        ))
    );
    NestedIterator nestedIterator = new NestedIterator(nestedInteger);

    List<Integer> flatten = new ArrayList<>();
    while (nestedIterator.hasNext()) {
      flatten.add(nestedIterator.next());
    }
    Assert.assertEquals(flatten, Arrays.asList(1, 4, 6));
  }


  private static class NestIntegerImpl implements NestedInteger {

    private List<Object> list;

    public NestIntegerImpl(List<Object> list) {
      this.list = list;
    }

    @Override
    public boolean isInteger() {
      return false;
    }

    @Override
    public Integer getInteger() {
      return null;
    }

    @Override
    public List<NestedInteger> getList() {
      List<NestedInteger> nl = new ArrayList<>();
      for (Object ele : list) {
        if (ele instanceof NestedIntegerIntImpl) {
          nl.add((NestedIntegerIntImpl) ele);
        }
        if (ele instanceof NestedIntegerArrayImpl) {
          nl.add((NestedIntegerArrayImpl) ele);
        }
        if (ele instanceof NestIntegerImpl) {
          nl.add((NestIntegerImpl) ele);
        }
      }
      return nl;
    }
  }

  private static class NestedIntegerIntImpl implements NestedInteger {

    private int val;

    public NestedIntegerIntImpl(int val) {
      this.val = val;
    }

    @Override
    public boolean isInteger() {
      return true;
    }

    @Override
    public Integer getInteger() {
      return val;
    }

    @Override
    public List<NestedInteger> getList() {
      return Collections.emptyList();
    }
  }

  private static class NestedIntegerArrayImpl implements NestedInteger {

    private List<Integer> list;

    public NestedIntegerArrayImpl(List<Integer> list) {
      this.list = list;
    }

    @Override
    public boolean isInteger() {
      return false;
    }

    @Override
    public Integer getInteger() {
      return null;
    }

    @Override
    public List<NestedInteger> getList() {
      List<NestedInteger> nl = new ArrayList<>();
      for (int val : list) {
        nl.add(new NestedIntegerIntImpl(val));
      }
      return nl;
    }
  }

}