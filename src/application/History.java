package application;

public class History {

	private String[] inputHistory;
	private double[] answerHistory;
	private int count = 0;

	public History(int size) {
		inputHistory = new String[size];
		answerHistory = new double[size];

	}

	public void addHistory(Input inputIn, Logic logicIn) {

		if (count < inputHistory.length) {
			inputHistory[count] = inputIn.getInput();
			answerHistory[count] = logicIn.getAnswer();
			count++;
		} 
		else // makes space for new entry by moving new entries to the left, overwriting the
				// oldest entry in effect
		{
//			count = 0;
//			inputHistory[count] = inputIn.getInput();
//			answerHistory[count] = logicIn.getAnswer();
//			count++;

			for (int i = 0; i < count - 1; i++) {
				inputHistory[i] = inputHistory[i + 1];
				answerHistory[i] = answerHistory[i + 1];

			}
			inputHistory[count - 1] = inputIn.getInput();
			answerHistory[count - 1] = logicIn.getAnswer();

		}

	}

	public void addHistory(String input, double output) {

		if (count < inputHistory.length) {
			inputHistory[count] = input;
			answerHistory[count] = output;
			count++;
		} else // makes space for new entry by moving new entries to the left, overwriting the
				// oldest entry in effect
		{
//			count = 0;
//			inputHistory[count] = inputIn.getInput();
//			answerHistory[count] = logicIn.getAnswer();
//			count++;

			for (int i = 0; i < count - 1; i++) {
				inputHistory[i] = inputHistory[i + 1];
				answerHistory[i] = answerHistory[i + 1];

			}
			inputHistory[count - 1] = input;
			answerHistory[count - 1] = output;

		}

	}

	public void showHistory() {
		for (int i = 0; i < inputHistory.length; i++) {
			if (inputHistory[i] != null) {
				System.out.println(i + " " + inputHistory[i]);
				System.out.println("Ans (" + i + ") " + answerHistory[i]);
				System.out.println();

			}
		}
	}

	public int getCount() {
		return count;
	}

}
