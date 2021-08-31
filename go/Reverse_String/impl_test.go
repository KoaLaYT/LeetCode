package Reverse_String

import (
	"reflect"
	"testing"
)

func TestReverseString(t *testing.T) {
	table := []struct {
		in, out []byte
	}{
		{[]byte{}, []byte{}},
		{[]byte{'1'}, []byte{'1'}},
		{[]byte{'1', '2'}, []byte{'2', '1'}},
		{[]byte{'h', 'e', 'l', 'l', 'o'}, []byte{'o', 'l', 'l', 'e', 'h'}},
	}

	for _, test := range table {
		ReverseString(test.in)

		if !reflect.DeepEqual(test.out, test.in) {
			t.Errorf("Expect: %q, Got: %q", test.out, test.in)
		}
	}
}
