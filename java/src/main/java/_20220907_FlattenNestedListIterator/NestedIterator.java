package _20220907_FlattenNestedListIterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

  private final Deque<IteratorInfo> stack;
  private Integer next;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.stack = new ArrayDeque<>();
    if (!nestedList.isEmpty()) {
      this.stack.push(new IteratorInfo(nestedList, 0));
    }
  }

  @Override
  public boolean hasNext() {
    next = findNext();
    return next != null;
  }

  @Override
  public Integer next() {
    return next;
  }

  private Integer findNext() {
    if (!stack.isEmpty()) {
      IteratorInfo info = stack.pop();
      NestedInteger integer = info.ni.get(info.index);
      info.index += 1;
      if (info.index < info.ni.size()) {
        stack.push(info);
      }
      if (integer.isInteger()) {
        return integer.getInteger();
      }
      List<NestedInteger> list = integer.getList();
      if (!list.isEmpty()) {
        stack.push(new IteratorInfo(list, 0));
      }
      return findNext();
    }
    return null;
  }

  private static class IteratorInfo {

    List<NestedInteger> ni;
    int index;

    IteratorInfo(List<NestedInteger> ni, int index) {
      this.ni = ni;
      this.index = index;
    }

  }

}
