package Swap_Nodes_In_Pairs

import (
	"fmt"
	"testing"
)

func (n *ListNode) print() {
	for n != nil {
		fmt.Print(n.Val, "->")
		n = n.Next
	}
	fmt.Println("nil")
}

func TestSwapPairs(t *testing.T) {
	got := SwapPairs(nil)
	if got != nil {
		t.Errorf("Swap a nil list should return nil, Got: %v", got)
	}

	n1 := &ListNode{Val: 1}
	got = SwapPairs(n1)
	if got != n1 {
		t.Errorf("Swap a single list should return itself, Got: %v", got)
	}

	n2 := &ListNode{Val: 2}
	n3 := &ListNode{Val: 3}
	n4 := &ListNode{Val: 4}
	n1.Next = n2
	n2.Next = n3
	n3.Next = n4

	got = SwapPairs(n1)
	if got != n2 || n2.Next != n1 || n1.Next != n4 || n4.Next != n3 || n3.Next != nil {
		t.Errorf("Wrong swap: ")
		got.print()
	}
}
