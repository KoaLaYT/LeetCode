struct Solution;

impl Solution {
    pub fn sort_array(nums: Vec<i32>) -> Vec<i32> {
        let mut nums = nums;
        let size = nums.len() - 1;
        Solution::quick_sort(&mut nums, 0, size);
        nums
    }

    fn quick_sort(nums: &mut [i32], lo: usize, hi: usize) {
        if lo >= hi {
            return;
        }

        let pivot = nums[lo];
        let p = Solution::partition(nums, pivot, lo, hi);
        if p > 1 {
            Solution::quick_sort(nums, lo, p - 1);
        }
        Solution::quick_sort(nums, p + 1, hi);
    }

    fn partition(nums: &mut [i32], p: i32, lo: usize, hi: usize) -> usize {
        let mut i = lo + 1;
        let mut j = hi;
        while i <= j {
            if nums[i] > p {
                Solution::swap(nums, i, j);
                j -= 1;
            } else {
                i += 1;
            }
        }
        Solution::swap(nums, j, lo);
        j
    }

    fn swap(nums: &mut [i32], i: usize, j: usize) {
        if i == j {
            return;
        }

        let tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

#[cfg(test)]
mod test {
    use crate::_20200811_sort_array::Solution;

    #[test]
    fn sort_array_test() {
        let nums = vec![5, 2, 3, 1];
        let sorted = Solution::sort_array(nums);
        let expected = vec![1, 2, 3, 5];
        assert_eq!(expected, sorted);
    }
}
