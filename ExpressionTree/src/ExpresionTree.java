import java.util.Stack;

public class ExpresionTree extends TreeNode implements Expressions {

	public ExpresionTree(Object v) {
		super(v);
	
		
	}

	@Override
	public TreeNode buildTree(String[] exp) {
	TreeNode node = null;
	TreeNode a= null;
	TreeNode b = null;
	Stack<TreeNode> stack1 = new Stack<TreeNode>();	
	for(int i =0; i < exp.length-1;i++) {
		if((!(exp[i].equals("+") || exp[i].equals("*")))) {
			node = new TreeNode(exp[i]);
			stack1.push(node);
		}else {
			b = stack1.pop();
			a = stack1.pop();
		
			stack1.push( new TreeNode(exp[i], a,b));

		}
	return stack1.pop();
	}
	return null;
	
	}

	public int evalTree(TreeNode root) {
		int num1 =0;
		int num2 = 0;

		if (root != null) {
			if (!isOperator(root)) {
				return Integer.parseInt(root.getValue().toString());
			}
			num1 = evalTree(root.getLeft());
			num2 = evalTree(root.getRight());
		}

		switch (root.getValue().toString()) {
		case "+":
			return num1 + num2;
		case "*":
			return num1 * num2;

		}
		return 0;
	}

	public boolean isOperator(TreeNode root) {
		if (root.getValue().toString().equals("+") || root.getValue().toString().equals("*")) {
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

	@Override
	public int evalTree() {
		// TODO Auto-generated method stub
		return 0;
	}

}
