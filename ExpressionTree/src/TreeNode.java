
public class TreeNode {
private Object value;
private TreeNode left;
private TreeNode right;

public TreeNode(Object v) {
	value = v;
	left = null;
	right = null;
}
public TreeNode(Object v, TreeNode lt, TreeNode rt) {
	value = v;
	left = lt;
	right = rt;
}

public Object getValue() { return value; }
public TreeNode getLeft() { return left; }
public TreeNode getRight() { return right; }

public void setValue(Object v) { value = v;}
public void setLeft(TreeNode lt) { left = lt;}
public void setRight(TreeNode rt) { right = rt;}



}
