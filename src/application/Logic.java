package application;

public class Logic {

	public final double division;
	public final double multiplication;
	public final double addition;
	public final double empty;
	private String[] stringArray;
	private double[] calculate;
	private int[] parenPositions;

	public Logic(Input inputIn) {

		division = 0.3333333333333339;
		multiplication = 0.3333333333333338;
		addition = 0.3333333333333337;
		empty = -0.0000000000000000000001;

		stringArray = inputIn.copyArray();
		parenChecker();
		calculate = new double[stringArray.length];
		copyArray(stringArray);

	}

	public String[] getStringArray() {
		return stringArray;
	}

	public double[] getDoubleArray() {
		return calculate;
	}

	public void parenChecker() {
		int parenNumSize = 0;

		// find the number of parenthesis in the input string
		for (int k = 0; k < stringArray.length; k++) {
			if (stringArray[k].contains("(")) {

				parenNumSize++;
			}

			if (stringArray[k].contains(")")) {

				parenNumSize++;

			}
		}

		parenPositions = new int[parenNumSize];
		int index = 0;

		/// This here records the positions of the parenthesis in the input string and
		/// removes them
		for (int k = 0; k < stringArray.length; k++) {
			if (stringArray[k].contains("(")) {

				parenPositions[index] = k;
				index++;
				stringArray[k] = stringArray[k].replace('(', '\0');

			}

			if (stringArray[k].contains(")")) {
				parenPositions[index] = k;
				index++;
				stringArray[k] = stringArray[k].replace(')', '\0');

			}
		}

	}

	public void copyArray(String... temp) {
		for (int l = 0; l < calculate.length; l++) {
			try {
				if (temp[l].equals("+"))

				{
					calculate[l] = addition;

				} else if (temp[l].equals("*")) {
					calculate[l] = multiplication;

				}

				else if (temp[l].equals("/")) {
					calculate[l] = division;

				}else if (temp[l].contains("!")) {
					String s = "";
					for (int i1 = 0; i1 < temp[l].length() - 1; i1++) {

						s = s.concat(temp[l].charAt(i1) + "");

					}
					double num = Double.parseDouble(s);
					calculate[l] = Functions.factorial(num);
					

				}else if (temp[l].contains("%")) {
					String s = "";
					for (int i1 = 0; i1 < temp[l].length() - 1; i1++) {

						s = s.concat(temp[l].charAt(i1) + "");

					}

					double num = Double.parseDouble(s);
					calculate[l] = num / 100;

				} else
					try {

						calculate[l] = Double.parseDouble(temp[l]);
					} catch (NumberFormatException e) {
						System.out.println("Syntax error");
					}
			} catch (NullPointerException e) {
				System.out.println("Error");
			}

		}

	}

	public void parenCalculate() {
		for (int k = 0; k < parenPositions.length; k += 2) {

			try {
				int start = parenPositions[k];
				int end = parenPositions[k + 1];

				for (int l = start; l < end; l++) {

					if (calculate[l] == division) {
						calculate[l + 1] = calculate[l - 1] / calculate[l + 1];
						calculate[l - 1] = empty;
						calculate[l] = empty;
					}
				}

				for (int l = start; l < end; l++) {

					if (calculate[l] == multiplication) {
						calculate[l + 1] = calculate[l - 1] * calculate[l + 1];
						calculate[l - 1] = empty;
						calculate[l] = empty;

					}
				}
				for (int l = start; l < end; l++) {
					if (calculate[l] == addition) {
						calculate[l + 1] = calculate[l - 1] + calculate[l + 1];
						calculate[l - 1] = empty;
						calculate[l] = empty;

					}
				}
				for (int l = start; l < end; l++) {
					if (calculate[l] != empty) {
						calculate[l + 1] += calculate[l];
						calculate[l] = empty;

					}

				}

			} catch (ArrayIndexOutOfBoundsException e) {
				throw new SyntaxException();
			}

		}

	}

	public void normalCalculate() {

		sortArray(calculate);
		// division
		for (int l = 1; l < calculate.length - 1; l++) {

			if (calculate[l] == division) {
				calculate[l + 1] = calculate[l - 1] / calculate[l + 1];
				calculate[l - 1] = empty;
				calculate[l] = empty;
			}

		}

		sortArray(calculate);

		// multiplication
		for (int l = 1; l < calculate.length - 1; l++) {

			if (calculate[l] == multiplication) {
				calculate[l + 1] = calculate[l - 1] * calculate[l + 1];
				calculate[l - 1] = empty;
				calculate[l] = empty;
			}

		}

		// addition
		for (int l = 1; l < calculate.length - 1; l++) {

			if (calculate[l] == addition) {
				calculate[l + 1] = calculate[l - 1] + calculate[l + 1];
				calculate[l - 1] = empty;
				calculate[l] = empty;
			}

		}
		sortArray(calculate);

		// final operation

		for (int l = 1; l < calculate.length; l++) {
			if (calculate[l] != empty) {
				calculate[0] += calculate[l];
				calculate[l] = empty;
			}

		}

	}

	public double[] sortArray(double[] arrayIn) {

		double swap = 0;
		boolean sorted = false;
		int unsorted_until_index = arrayIn.length - 1;

		while (!sorted) {

			sorted = true;
			for (int i = 0; i < unsorted_until_index; i++) {
				if (arrayIn[i] == empty) {
					for (int j = i + 1; j < arrayIn.length; j++) {
						if (arrayIn[j] != empty) {
							swap = arrayIn[i];
							arrayIn[i] = arrayIn[j];
							arrayIn[j] = swap;
							break;

						}
					}

				}

			}
		}
		return arrayIn;
	}

	public double getAnswer() {
		return calculate[0];
	}

}
