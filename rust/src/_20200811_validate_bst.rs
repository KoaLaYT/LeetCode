use std::rc::Rc;
use std::cell::RefCell;

// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
struct TreeNode {
    val: i32,
    left: Option<Rc<RefCell<TreeNode>>>,
    right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

struct Solution;

impl Solution {
    pub fn is_valid_bst(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        Solution::is_valid_bst_bounded(&root, None, None)
    }

    fn is_valid_bst_bounded(root: &Option<Rc<RefCell<TreeNode>>>, min: Option<i32>, max: Option<i32>) -> bool {
        if let Some(node) = root {
            let cur = RefCell::borrow(node).val;

            if !Solution::is_in_bound(cur, min, max) {
                return false;
            }

            Solution::is_valid_bst_bounded(&RefCell::borrow(node).left, min, Some(cur)) &&
                Solution::is_valid_bst_bounded(&RefCell::borrow(node).right, Some(cur), max)
        } else {
            true
        }
    }

    fn is_in_bound(cur: i32, min: Option<i32>, max: Option<i32>) -> bool {
        if let Some(min) = min {
            if cur <= min {
                return false;
            }
        }

        if let Some(max) = max {
            if cur >= max {
                return false;
            }
        }

        true
    }
}

#[cfg(test)]
mod test {
    use crate::_20200811_validate_bst::{TreeNode, Solution};
    use std::rc::Rc;
    use std::cell::RefCell;

    fn wrap_node(node: TreeNode) -> Option<Rc<RefCell<TreeNode>>> {
        Some(Rc::new(RefCell::new(node)))
    }

    #[test]
    fn test0() {
        assert!(Solution::is_valid_bst(None));
    }

    #[test]
    fn test1() {
        let n1 = TreeNode::new(1);
        let n3 = TreeNode::new(3);

        let n2 = TreeNode {
            val: 2,
            left: wrap_node(n1),
            right: wrap_node(n3),
        };

        assert!(Solution::is_valid_bst(wrap_node(n2)));
    }

    #[test]
    fn test2() {
        let n1 = TreeNode::new(5);
        let n2 = TreeNode::new(6);
        let n3 = TreeNode::new(20);

        let n4 = TreeNode {
            val: 15,
            left: wrap_node(n2),
            right: wrap_node(n3),
        };

        let n5 = TreeNode {
            val: 10,
            left: wrap_node(n1),
            right: wrap_node(n4),
        };

        assert!(!Solution::is_valid_bst(wrap_node(n5)));
    }

    #[test]
    fn test3() {
        let n1 = TreeNode::new(0);
        let n2 = TreeNode::new(3);
        let n3 = TreeNode::new(4);
        let n4 = TreeNode::new(6);

        let n5 = TreeNode {
            val: 2,
            left: None,
            right: wrap_node(n2),
        };

        let n6 = TreeNode {
            val: 1,
            left: wrap_node(n1),
            right: wrap_node(n5),
        };

        let n7 = TreeNode {
            val: 5,
            left: wrap_node(n3),
            right: wrap_node(n4),
        };

        let n8 = TreeNode {
            val: 3,
            left: wrap_node(n6),
            right: wrap_node(n7),
        };

        assert!(!Solution::is_valid_bst(wrap_node(n8)));
    }
}