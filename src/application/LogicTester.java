package application;

import java.util.Scanner;

//import java.util.Scanner;
public class LogicTester {

	public static void main(String[] args) {

//			Input input = new Input("(-2/3/3/4/6)");
//			Logic logic = new Logic(input);

		History hist = new History(7);
		char choice;
		String newInput;
		String oldInput = "";
		double answer = 0;

		System.out.println("***Welcome to the Casio FX991ES Plus" + " Calculator***");
		do {

			// System.out.println("i is " + i);

			System.out.println();
			System.out.println("a.TYPE");
			System.out.println("b.SQUARE INPUT");
			System.out.println("c.CUBE INPUT");
			System.out.println("d.FIND SQUARE ROOT OF INPUT");
			System.out.println("e.FIND CUBE ROOT OF INPUT");
			System.out.println("f.FIND FACTORIAL OF INPUT");

			System.out.println("x. EQUALS (=)");
			System.out.println("h. SHOW HISTORY");
			System.out.println("z. QUIT");

			System.out.println();

			Scanner keyboard = new Scanner(System.in);
			// Scanner keyboard2 = new Scanner(System.in);
			choice = keyboard.next().charAt(0);

			switch (choice) {

			case 'a':

				System.out.print("Type something: ");
				newInput = keyboard.next();
				Input input = new Input(newInput);
				Logic logic = new Logic(input);
				logic.parenCalculate();
				logic.normalCalculate();
				hist.addHistory(input, logic);
				oldInput = input.getInput();
				answer = logic.getAnswer();
				// keyboard.close();

				break;

			case 'b':

				System.out.println(Functions.square(answer));
				// hist.addHistory(input, logic);
				break;

			case 'c':
				System.out.println(Functions.cube(answer));
				hist.addHistory(oldInput + "^3", Functions.cube(answer));
				break;

			case 'd':
				System.out.println(Functions.squareRoot(answer));
				hist.addHistory("sqrt(" + oldInput + ")", Functions.cube(answer));
				break;

			case 'e':
				System.out.println(Functions.cubeRoot(answer));
				hist.addHistory("cubeRoot( " + oldInput + ")", Functions.cube(answer));
				break;

			case 'f':
				System.out.println(Functions.factorial(answer));
				hist.addHistory(oldInput + "!", Functions.cube(answer));
				break;

			case 'x':

				System.out.println(oldInput);
				System.out.println(answer);

				break;

			case 'h':
				hist.showHistory();
				break;

			}

		} while (choice != 'z');

	}
}
