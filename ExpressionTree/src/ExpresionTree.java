import java.util.Stack;

public class ExpresionTree extends TreeNode implements Expressions {

	

	public ExpresionTree(String s) {
		super("");

		String[] exp = s.split(" ");

		TreeNode root = buildTree(exp);
		// TODO
		System.out.println("hello");
	}

	@Override
	public TreeNode buildTree(String[] exp) {
		TreeNode node = null;
		TreeNode a = null;
		TreeNode b = null;

		Stack<TreeNode> stack1 = new Stack<TreeNode>();

		for (int i = 0; i < exp.length; i++) {

			if ((!(exp[i].equals("+") || exp[i].equals("*")))) {

				node = new TreeNode(exp[i]);

				stack1.push(node);

				System.out.println(exp.length);
			} else {
				b = stack1.pop();
				a = stack1.pop();

				stack1.push(new TreeNode(exp[i], a, b));

			}

		}

		return stack1.pop();

	}


	public int evalTree(TreeNode root) {
		int num1 = 0;
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
	@Override
	public int evalTree() {
		int num1 = 0;
		int num2 = 0;

		if (this != null) {
			if (!isOperator(this)) {
				return Integer.parseInt(this.getValue().toString());
			}
			num1 = evalTree(this.getLeft());
			num2 = evalTree(this.getRight());
		}

		switch (this.getValue().toString()) {
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


	public String toPrefixNotation(TreeNode t) {


		if (t.getValue() == null) {
			return "";
		}
		if (isOperator(t)) {
			return t.getValue().toString() + toPrefixNotation(t.getLeft()) + toPrefixNotation(t.getRight());
		}else
			return t.getValue().toString();
	}

	
	@Override
	public String toPrefixNotation() {
		if(this.getValue() ==null) { 
			return ""; 
			}
		if(isOperator(this)) {
			return this.getValue().toString() + toPrefixNotation(this.getLeft()) + toPrefixNotation(this.getRight());
		}else
		return this.getValue().toString();
		}
		
	
	

	public String toInfixNotation(TreeNode t) {

	
		
		
		return "";
	}


	public String toPostfixNotation(TreeNode t) {
		if (t.getValue() == null) {
			return "";
		}
		if (isOperator(t)) {
			return  toPrefixNotation(t.getLeft()) + toPrefixNotation(t.getRight()) + t.getValue().toString();
		}else
			return t.getValue().toString();
	}
	
	@Override
	public String toPostfixNotation() {
		if(this.getValue() ==null) { 
			return ""; 
			}
		if(isOperator(this)) {
			return toPrefixNotation(this.getLeft()) + toPrefixNotation(this.getRight()) +  this.getValue().toString();
		}else
		return this.getValue().toString();
	}
	
	
		

	@Override
	public int postfixEval(String[] exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {

		ExpresionTree e = new ExpresionTree("4 6 + 7 * 8 +");

		// String[] str = ["4","6","+","7","*","8","+"];

	}

	@Override
	public String toInfixNotation() {
		// TODO Auto-generated method stub
		return null;
	}





}
