package application;

public class Input {

	private String input;
	private String rawInput;

	public Input(String inputIn) {
		input = inputIn;
		rawInput = inputIn;
		formatInput();

	}

	private String formatInput() {
//		if(input.startsWith("(") && input.endsWith(")"))
//		{
//			throw new SyntaxException();
//			
//		}

		for (int i = 0; i < input.length() - 1; i++) {

			if (input.charAt(i) == '-') {

				if (input.charAt(i + 1) == '(') {

					input = input.replace("-", "-1*");
				}

			}

		}
		
		for (int i = 0; i < input.length() - 1; i++) {

			if (input.charAt(i) == '×') {
				
				input = input.replace("×", "*");
			}
		}
		
		for (int i = 0; i < input.length() - 1; i++) {

			if (input.charAt(i) == '÷') {
				
				input = input.replace("÷", "/");
			}
		}

		return input;
	}

	public String getInput() {
		return rawInput;
	}

	public int findArrayLength() {
		int length = 0;
		// this loop finds the number of operators in the input string
		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) == '+' || input.charAt(j) == '*' || input.charAt(j) == '/'
					|| (input.charAt(j) == '-' && input.charAt(j + 1) == '(')) {
				length++;
			}

		}

		length = length * 2 + 1; // the space we'll need is 2 times the number of operators plus one

		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) == '-') {
				length++;
			}
		}

		return length;
	}

	public String[] copyArray() {

		String[] temp = new String[findArrayLength()];
		// replace any null values in string array with 0
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == null) {
				temp[i] = "0";
			}
		}

		int j = 1;
		int i = 0;
		try {
			temp[0] = input.charAt(0) + "";

			// if(input.charAt(0) == '(')
			// {
			// i++;
			// }
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Syntax error");
			System.out.println(e);
		}

		// Fill the string array with the values from the input string
		while (j < input.length()) {

			if (input.charAt(j) == '-' && input.charAt(j - 1) != '(') //
			{
				i++;

				temp[i] = "";
				// temp[i].concat(input.charAt(j) + "");
				// i++;
			}

			if (input.charAt(j) == '+' || input.charAt(j) == '*' || input.charAt(j) == '/')// || input.charAt(j) ==
																							// '('|| input.charAt(j) ==
																							// ')' )
			{
				i++;
				temp[i] = "";
				temp[i] = temp[i].concat(input.charAt(j) + "");
				j++;
				i++;
				temp[i] = ""; // This part is necessary because you can't concatenate if the value at the
								// specified index is null.

			}
			try {
				temp[i] = temp[i].concat(input.charAt(j) + "");
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("Something happened here... Something bad");
				System.out.println(e);
			}

			j++;

		}
		return temp;
	}

}
