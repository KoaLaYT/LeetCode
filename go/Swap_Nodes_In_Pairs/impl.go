package Swap_Nodes_In_Pairs

type ListNode struct {
	Val  int
	Next *ListNode
}

func SwapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	tail := SwapPairs(head.Next.Next)
	tmp := head
	head = head.Next
	head.Next = tmp
	head.Next.Next = tail

	return head
}
