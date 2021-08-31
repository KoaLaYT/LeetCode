package _0200704_Combinations

func Combine(n int, k int) [][]int {
	if k == 0 {
		return nil
	}

	result := make([][]int, 0)

	var combine func(a []int, i int)
	combine = func(a []int, i int) {
		if i <= 0 {
			return
		}
		if i >= len(a) {
			b := make([]int, k)
			copy(b, a)
			result = append(result, b)
			return
		}
		for p := a[i-1] + 1; p <= n; p++ {
			a[i] = p
			combine(a, i+1)
		}
		i--
	}

	for i := 1; i <= n; i++ {
		a := make([]int, k)
		a[0] = i
		combine(a, 1)
	}

	return result
}
