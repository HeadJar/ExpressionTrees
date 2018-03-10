import java.util.Stack;
/**
 * 
 * @author Jarhead
 *
 *Takes in trees and converts them to selected methods
 *
 *
 */
public class ExpresionTree extends TreeNode implements Expressions {

	
/**
 * 
 * @param s
 * This is what is taken in for the tree to be built.
 */
	public ExpresionTree(String s) {
		super("");

		String[] exp = s.split(" ");

		TreeNode root = buildTree(exp);
		this.setValue(root.getValue());
		this.setLeft(root.getLeft());
		this.setRight(root.getRight());
		
	

	}

	@Override
/**
 * This method builds the tree 
 * 
 * @param exp
 * This is the array of string sent in for the equation
 * 
 * @return 
 * Returns a finished tree
 *
 */
	
	public TreeNode buildTree(String[] exp) {
		TreeNode node = null;
		TreeNode a = null;
		TreeNode b = null;

		Stack<TreeNode> stack1 = new Stack<TreeNode>();

		for (int i = 0; i < exp.length; i++) {

			if ((!(exp[i].equals("+") || exp[i].equals("*")))) {

				node = new TreeNode(exp[i]);

				stack1.push(node);

	
			} else {
				b = stack1.pop();
				a = stack1.pop();

				stack1.push(new TreeNode(exp[i], a, b));

			}

		}

		return stack1.pop();

	}

/**
 * This method evaluates the tree and returns an integer value
 */
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
				System.out.print(this.getValue());
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
	
	
	
	
	/**
	 * This method determines whether the root is a number or operator
	 * @param root
	 * This is what is taken in, it has a value of either a number or operator
	 * @return
	 * returns true if it is a operator, false if it is a number.
	 */

	public boolean isOperator(TreeNode root) {
		if (root.getValue().toString().equals("+") || root.getValue().toString().equals("*")) {
			return true;
		}
		return false;
	}
/**
 * This does the math for postFixEval
 * @param s This is the operator
 * @param num1 This is the first integer
 * @param num2 This is the second integer
 * @return
 * returns the sum or product of the input
 */
	public int doMath(String s, int num1, int num2) {
		if(s.equals("+")) {
			return num1 + num2;
		}
		return num1*num2;
	}
	
/**
 * These two functions convert the tree to pre order notation
 * @param t is the tree
 * @return returns a string in preFix Notation
 */
	public String toPrefixNotation(TreeNode t) {


		if (t.getValue() == null) {
			return "";
		}
		if (isOperator(t)) {
			return t.getValue().toString() + " " +toPrefixNotation(t.getLeft()) +" " + toPrefixNotation(t.getRight());
		}else
			return t.getValue().toString();
	}

	/**
	 * These two functions convert the tree to pre order notation
	 * @param t is the tree
	 * @return returns a string in preFix Notation
	 */
	@Override
	public String toPrefixNotation() {
		if(this.getValue() ==null) { 
			return ""; 
			}
		if(isOperator(this)) {
			return this.getValue().toString() + " " +toPrefixNotation(this.getLeft()) + " " +toPrefixNotation(this.getRight());
		}else
		return this.getValue().toString();
		}
		
	
	/**
	 * These two functions convert the tree to in order notation
	 * @param t is the tree
	 * @return returns a string in inFix Notation
	 */

	public String toInfixNotation(TreeNode t) {

	
		if(t.getValue()== null) {
			return "";
		}
		
		if(isOperator(t)) {
			return "(" + toInfixNotation(t.getLeft()) + " " +t.getValue().toString() + " " +toInfixNotation(t.getRight()) + ")";
		}else 
			return t.getValue().toString();
	}
	
	/**
	 * These two functions convert the tree to in order notation
	 * @param t is the tree
	 * @return returns a string in inFix Notation
	 */
	
	public String toInfixNotation() {
		if(this.getValue()== null) {
			return "";
		}
		
		if(isOperator(this)) {
			return toInfixNotation(this.getLeft()) + " " + this.getValue().toString() +" " + toInfixNotation(this.getRight());
		}else 
			return this.getValue().toString();
	}

	/**
	 * These two functions convert the tree to post order notation
	 * @param t is the tree
	 * @return returns a string in postOrder Notation
	 */
	public String toPostfixNotation(TreeNode t) {
		if (t.getValue() == null) {
			return "";
		}
		if (isOperator(t)) {
			return  toPrefixNotation(t.getLeft()) + " " +toPrefixNotation(t.getRight()) + " " +t.getValue().toString();
		}else
			return t.getValue().toString();
	}
	/**
	 * These two functions convert the tree to post order notation
	 * @param t is the tree
	 * @return returns a string in postOrder Notation
	 */
	@Override
	public String toPostfixNotation() {
		if(this.getValue() ==null) { 
			return ""; 
			}
		if(isOperator(this)) {
			return toPrefixNotation(this.getLeft()) + " " +toPrefixNotation(this.getRight()) +  " " +this.getValue().toString();
		}else
		return this.getValue().toString();
	}
	
	
	/**
	 * Takes in a string array and returns the sum or product of the post order 
	 */
	@Override
	
	public int postfixEval(String[] exp) {
		int num1 = 0;
		int num2 = 0;
		int num = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(String s : exp) {
			if((s.equals("+") || s.equals("*"))) {
				num2 = stack.pop();
				num1 = stack.pop();
				
				num = doMath(s, num1, num2);
			
			} else {
				num = Integer.parseInt(s);
			}
			stack.push(num);
		}
		return stack.pop();
	}
	







}
