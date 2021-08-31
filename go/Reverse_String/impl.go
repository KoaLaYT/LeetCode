package Reverse_String

func ReverseString(s []byte) {
	if len(s) <= 1 {
		return
	}
	swap(s, 0, len(s)-1)
	ReverseString(s[1 : len(s)-1])
}

func swap(s []byte, i, j int) {
	tmp := s[i]
	s[i] = s[j]
	s[j] = tmp
}
