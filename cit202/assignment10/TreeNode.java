// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

public  class TreeNode<E> {

        public E data;              // data stored in this node
        public TreeNode<E> left;   // left subtree
        public TreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public TreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public TreeNode(E data, TreeNode<E> left,
                                      TreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        // Returns: String representation of the tree as an inorder traversal
        public String toString () {
	    return toString (this);
	}

        // Returns: String representation of the tree as an inorder traversal
	private String toString(TreeNode tn) {
	    if (tn == null)
		return "";
	    return toString(tn.left) + " " + tn.data + " " + 
		toString (tn.right);
	}        
}

