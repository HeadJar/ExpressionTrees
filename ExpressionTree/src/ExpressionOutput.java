import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExpressionOutput {

	/**
	 * Opens file for reading
	 * @param fName name of file
	 * @return returns the scanner ready for testing
	 */
	
	public Scanner openFile(String fName) {

		File file = new File(fName);
		Scanner kb = null;
		try {
			kb = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file: " + fName);
			return null;
		}
		return kb;
	}
/**
 * This reads input to the output File
 * @param fName name of the file
 * @return the output
 */
	public PrintWriter readToFile(String fName) {
		File file = new File(fName);
		PrintWriter input = null;
		try {
			input = new PrintWriter(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Cant open file: " + fName);
			return null;
		}
		return input;
	}
	
	
/**
 * This formats the file to be sent out
 * @param outFile What everything is sent out to
 * @param fName name of the file
 * @param e is the expression Tree
 */
	

	public static void formatFile(PrintWriter outFile, Scanner fName, ExpresionTree e) {
		
		String[] exp = e.toPostfixNotation().split(" ");
		
		
		for(String i: exp) {
			System.out.print(i);
		}
		outFile.println(e.evalTree());
		outFile.println(e.toPrefixNotation());
		outFile.println(e.toInfixNotation());
		outFile.println(e.toPostfixNotation());
		outFile.println(e.postfixEval(exp));
		outFile.println();
		outFile.println();

	}

	public static void main(String[] args) throws FileNotFoundException {
		// Scanner for user input
		Scanner user = new Scanner(System.in);
		String inputFileName, outputFileName;
		File input = null;
		Scanner scan = null;
		if (args.length < 1) {
			System.out.print("Input File Name: ");
			inputFileName = user.nextLine().trim();
			input = new File(inputFileName);
			
		} else {

			input = new File(args[0]);
			try {
				scan = new Scanner (input);
			}catch(FileNotFoundException ex) {
				System.out.println("Please enter file");
			
			}
			
			
		
		}

		// prepare the input file

		scan = new Scanner(input);

		// prepare the output file
		System.out.print("Output File Name: ");
		outputFileName = user.nextLine().trim();
		PrintWriter output = new PrintWriter(outputFileName);

		// processing loop
		while (scan.hasNextLine()) {

			ExpresionTree e = new ExpresionTree(scan.nextLine());

			formatFile(output, scan, e);
		}

		// close the output file

		output.close();
		user.close();
		scan.close();

	}
}
