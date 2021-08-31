package _0200703_N_Queens

import "testing"

func TestTotalNQueens(t *testing.T) {
	table := []struct {
		in, out int
	}{
		{0, 0},
		{1, 1},
		{2, 0},
		{3, 0},
		{4, 2},
		{8, 92},
	}

	for _, test := range table {
		got := TotalNQueens(test.in)
		if got != test.out {
			t.Errorf("For n = %v, Expect: %v, Got: %v", test.in, test.out, got)
		}
	}
}
