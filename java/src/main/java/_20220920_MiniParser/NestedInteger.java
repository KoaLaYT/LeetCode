package _20220920_MiniParser;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private final List<NestedInteger> list;
    private int integer;
    private final boolean isInteger;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        this.list = new ArrayList<>();
        this.integer = 0;
        this.isInteger = false;
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.list = new ArrayList<>();
        this.integer = value;
        this.isInteger = true;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return isInteger;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return integer;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        if (isInteger) {
            integer = value;
        }
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (!isInteger) {
            list.add(ni);
        }
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }
}
