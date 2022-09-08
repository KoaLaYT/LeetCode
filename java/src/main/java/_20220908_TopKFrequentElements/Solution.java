package _20220908_TopKFrequentElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.compute(num, (key, oldValue) -> {
                if (oldValue == null) {
                    return 1;
                }
                return oldValue + 1;
            });
        }

        PriorityQueue<FreqEle> pq = new PriorityQueue<>(k);
        freq.forEach((n, f) -> pq.add(new FreqEle(n, f)));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().element;
        }
        return result;
    }

    private static class FreqEle implements Comparable<FreqEle> {
        int element;
        int freq;

        FreqEle(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }

        @Override
        public int compareTo(FreqEle o) {
            return Integer.compare(o.freq, freq);
        }
    }

}
