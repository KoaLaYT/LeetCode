package _0200703_N_Queens

func TotalNQueens(n int) int {
	if n == 0 {
		return 0
	}
	invalid := make([][]bool, n)
	for i := 0; i < n; i++ {
		invalid[i] = make([]bool, n)
	}
	return place(invalid, 0, n, n, 0)
}

func place(invalid [][]bool, n, row, col int, count int) int {
	if n >= row {
		return count + 1
	}
	for i := 0; i < col; i++ {
		if !invalid[n][i] {
			count = place(update(invalid, n, i), n+1, row, col, count)
		}
	}
	return count
}

func update(invalid [][]bool, row, col int) [][]bool {
	size := len(invalid)
	newInvalid := make([][]bool, size)
	for i := 0; i < size; i++ {
		newInvalid[i] = make([]bool, size)
		for j := 0; j < size; j++ {
			if i == row || j == col {
				newInvalid[i][j] = true
			} else {
				newInvalid[i][j] = invalid[i][j]
			}
		}
	}
	for i, j := row, col; i < size && j < size; i, j = i+1, j+1 {
		newInvalid[i][j] = true
	}
	for i, j := row, col; i >= 0 && j >= 0; i, j = i-1, j-1 {
		newInvalid[i][j] = true
	}
	for i, j := row, col; i < size && j >= 0; i, j = i+1, j-1 {
		newInvalid[i][j] = true
	}
	for i, j := row, col; i >= 0 && j < size; i, j = i-1, j+1 {
		newInvalid[i][j] = true
	}
	return newInvalid
}