

public class ExpresionTree extends TreeNode implements Expressions {

	@Override
	public TreeNode buildTree(String[] exp) {
		// TODO Auto-generated method stub
		return null;
	}

	public int evalTree(TreeNode root) {
	if (root != null) {
		if(!isOperator(root)) {

			return Integer.parseInt(root.toString());
		}
		evalTree(root.getLeft);
		evalTree(root.getRight);
	}
		return 0;
	}
	
	public boolean isOperator(TreeNode root) {
		if(root.toString().equals("+") || root.toString().equals("*")) {
			return true;
		}
		return false;
	}

	@Override
	public String toPrefixNotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toInfixNotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toPostfixNotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int postfixEval(String[] exp) {
		// TODO Auto-generated method stub
		return 0;
	}

}
