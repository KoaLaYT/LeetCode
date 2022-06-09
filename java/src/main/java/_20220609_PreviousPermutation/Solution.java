package _20220609_PreviousPermutation;

public class Solution {

    public int[] previous_permutation(int[] permutation) {
        if (permutation == null) {
            return null;
        }

        int n = permutation.length;
        int[] result = new int[n];
        System.arraycopy(permutation, 0, result, 0, n);

        if (result.length <= 1) {
            return result;
        }

        int i = n - 2;
        while (i >= 0) {
            if (result[i] > result[i + 1]) break;
            else i--;
        }

        if (i != -1) {
            int j = i + 1;
            for (int k = i+2; k < n; k++) {
                if (result[k] < result[i] && result[k] >= result[j]) {
                    j = k;
                }
            }
            swap(result, i, j);
        }

        i++;
        int j = n - 1;
        while (i < j) {
            swap(result, i ,j);
            i++;
            j--;
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
