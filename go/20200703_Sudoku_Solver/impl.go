package _0200703_Sudoku_Solver

func SolveSudoku(board [][]byte) {
	filled := 0
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board); j++ {
			if board[i][j] != '.' {
				filled++
			}
		}
	}
	if solved := solve(board, 0, 0, filled); !solved {
		panic("No solution for this sudoku")
	}
}

func solve(board [][]byte, i, j int, filled int) bool {
	switch {
	case filled == len(board)*len(board):
		return true
	case i >= len(board):
		return false
	case j >= len(board):
		return solve(board, i+1, 0, filled)
	case board[i][j] != '.':
		return solve(board, i, j+1, filled)
	default:
		for n := 0; n < 9; n++ {
			if isValid(board, i, j, byte(n+'1')) {
				place(board, i, j, byte(n+'1'))
				if solved := solve(board, i, j+1, filled+1); solved {
					return true
				}
				remove(board, i, j)
			}
		}
	}
	return false
}

func isValid(board [][]byte, i, j int, n byte) bool {
	bx, by := i/3, j/3
	for k := 0; k < len(board); k++ {
		// row validation
		if board[i][k] == n {
			return false
		}
		// col validation
		if board[k][j] == n {
			return false
		}
		// block validation
		if board[bx*3+(k/3)][by*3+(k%3)] == n {
			return false
		}
	}
	return true
}

func place(board [][]byte, i, j int, n byte) {
	board[i][j] = n
}

func remove(board [][]byte, i, j int) {
	board[i][j] = '.'
}
