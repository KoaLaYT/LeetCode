package Search_In_Binary_Tree

import "testing"

func TestSearchBST(t *testing.T) {
	n1 := &TreeNode{Val: 1}
	n2 := &TreeNode{Val: 2}
	n3 := &TreeNode{Val: 3}
	n4 := &TreeNode{Val: 4}
	n7 := &TreeNode{Val: 7}

	n4.Left = n2
	n4.Right = n7
	n2.Left = n1
	n2.Right = n3

	var got *TreeNode
	got = SearchBST(nil, 5)
	if got != nil {
		t.Errorf("Expect: nil, Got: %v", got.Val)
	}

	got = SearchBST(n4, 5)
	if got != nil {
		t.Errorf("Expect: nil, Got: %v", got.Val)
	}

	got = SearchBST(n4, 2)
	if got != n2 {
		t.Errorf("Expect: %v, Got: %v", n2, got.Val)
	}

	got = SearchBST(n4, 3)
	if got != n3 {
		t.Errorf("Expect: %v, Got: %v", n3, got.Val)
	}
}
