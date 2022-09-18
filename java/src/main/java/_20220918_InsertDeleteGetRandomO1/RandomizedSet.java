package _20220918_InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {

    private int size;
    private final Map<Integer, Integer> map;
    private final List<Integer> arr;

    public RandomizedSet() {
        this.size = 0;
        this.map = new HashMap<>();
        this.arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        if (size < arr.size()) {
            arr.set(size, val);
            map.put(val, size);
            size += 1;
        } else {
            arr.add(val);
            size = arr.size();
            map.put(val, size - 1);
        }

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.remove(val);
        if (swap(index)) {
            map.put(arr.get(index), index);
        }
        size -= 1;

        return true;
    }

    public int getRandom() {
        int randomIndex = ThreadLocalRandom.current().nextInt(size);
        return arr.get(randomIndex);
    }

    private boolean swap(int i) {
        if (i == size - 1) {
            return false;
        }
        int tmp = arr.get(size - 1);
        arr.set(size - 1, arr.get(i));
        arr.set(i, tmp);
        return true;
    }

}
