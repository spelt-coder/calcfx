package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	private Label header = new Label("Calculator");
	
	private TextArea display = new TextArea();
	private Label answer = new Label();
	 
	
	
	private final int WIDTH = 800;
	private final int HEIGHT = 50;
	private final int buttonSize = 50;
	private int count = 0;
	
	private Button zero = new Button("0");
	private Button point = new Button(".");
	private Button parentheses = new Button("( )");
	private Button equals = new Button("=");
	private Button one = new Button("1");
	private Button two = new Button("2");
	private Button three = new Button("3");
	private Button four = new Button("4");
	private Button five = new Button("5");
	private Button six = new Button("6");
	private Button seven = new Button("7");
	private Button eight = new Button("8");
	private Button nine = new Button("9");
	private Button percent = new Button("%");
	private Button del = new Button("DEL");
	private Button ac = new Button("AC");
	private Button times = new Button("×");
	private Button plus = new Button("+");
	private Button minus = new Button("−");
	private Button divides = new Button("÷");
	
	
	private Button up = new Button();
	private Button down = new Button();
			
	
	@Override
	public void start(Stage stage) {
		
		HBox first = new HBox(5);
		HBox second = new HBox(5);
		HBox third = new HBox(5);
		HBox fourth = new HBox(5);
		HBox fifth = new HBox(5);
		
		first.getChildren().addAll(del, ac, percent, times);
		second.getChildren().addAll(seven, eight, nine, divides);
		third.getChildren().addAll(four, five, six, minus);
		fourth.getChildren().addAll(one, two, three, plus);
		fifth.getChildren().addAll(zero, point, parentheses, equals);

		
		
		VBox root = new VBox(5);
		//root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(header, display, first, second, third, fourth, fifth);
		
		Scene scene = new Scene(root);
		
//		display.setMinSize(90, 50);
		//display.setMaxSize(100, 100);
		display.setMinWidth(50);
		display.setMaxWidth(218);
		
		display.setMinHeight(70);
		display.setMaxHeight(70);

//		display.setMinHeight(80);
//		
		display.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
										new CornerRadii(0), new BorderWidths(2))));
		//display.getChildrenUnmodifiable().addAll(answer);
		
		
		
		ac.setMinWidth(HEIGHT);
		ac.setMaxWidth(HEIGHT);
		divides.setMinWidth(HEIGHT);
		divides.setMaxWidth(HEIGHT);
		del.setMinWidth(HEIGHT);
		del.setMaxWidth(HEIGHT);
		zero.setMinWidth(HEIGHT);
		zero.setMaxWidth(HEIGHT);
		one.setMinWidth(HEIGHT);
		one.setMaxWidth(HEIGHT);
		two.setMinWidth(HEIGHT);
		two.setMaxWidth(HEIGHT);
		three.setMinWidth(HEIGHT);
		three.setMaxWidth(HEIGHT);
		four.setMinWidth(HEIGHT);
		four.setMaxWidth(HEIGHT);
		five.setMinWidth(HEIGHT);
		five.setMaxWidth(HEIGHT);
		six.setMinWidth(HEIGHT);
		six.setMaxWidth(HEIGHT);
		seven.setMinWidth(HEIGHT);
		seven.setMaxWidth(HEIGHT);
		eight.setMinWidth(HEIGHT);
		eight.setMaxWidth(HEIGHT);
		nine.setMinWidth(HEIGHT);
		nine.setMaxWidth(HEIGHT);
		times.setMinWidth(HEIGHT);
		times.setMaxWidth(HEIGHT);
		minus.setMinWidth(HEIGHT);
		minus.setMaxWidth(HEIGHT);
		divides.setMinWidth(HEIGHT);
		divides.setMaxWidth(HEIGHT);
		plus.setMinWidth(HEIGHT);
		plus.setMaxWidth(HEIGHT);
		equals.setMinWidth(HEIGHT);
		equals.setMaxWidth(HEIGHT);
		percent.setMinWidth(HEIGHT);
		percent.setMaxWidth(HEIGHT);
		point.setMinWidth(HEIGHT);
		point.setMaxWidth(HEIGHT);
		parentheses.setMinWidth(HEIGHT);
		parentheses.setMaxWidth(HEIGHT);
		
		
		
		
		//display.setMaxSize(WIDTH - 80, HEIGHT/5);
		//display.setMaxSize(WIDTH - 80, HEIGHT/5);
		
		
		equals.setOnAction(e -> equalTo());
		
		display.setOnKeyTyped(e -> 
								{
									
									if(e.getCharacter().equals("\r"))
									{
										equalTo();
									}
									
								});
			
		
		zero.setOnAction(e -> zero());
		one.setOnAction(e -> one());
		two.setOnAction(e -> two());
		three.setOnAction(e -> three());
		four.setOnAction(e -> four());
		five.setOnAction(e -> five());
		six.setOnAction(e -> six());
		seven.setOnAction(e -> seven());
		eight.setOnAction(e -> eight());
		nine.setOnAction(e -> nine());
		plus.setOnAction(e -> plus());
		minus.setOnAction(e -> minus());
		times.setOnAction(e -> times());
		divides.setOnAction(e -> divides());
		percent.setOnAction(e -> percent());
		ac.setOnAction(e -> ac());
		del.setOnAction(e -> del());
		parentheses.setOnAction(e-> parentheses());
		
		
//		stage.setWidth();
//		stage.setHeight(HEIGHT);
		
		stage.setScene(scene);
		stage.setResizable(false);
		
		stage.show();
		
		
		
		
	}
	
	private void equalTo()
	{
		Input input = new Input(display.getText());
		Logic logic = new Logic(input);
		logic.parenCalculate();
		logic.normalCalculate();
		String answer = logic.getAnswer() + "";
		
		display.appendText("\n" + answer);
		
	}
	
	private void ac()
	{
		display.setText("");
	}
	
	private void del()
	{
		display.deleteText(display.getLength()-1, display.getLength());
		
	}
	
	
	private void zero()
	{
		display.appendText("0");
		
	}
	private void one()
	{
		display.appendText("1");
	}
	
	private void two()
	{
		display.appendText("2");
	}
	private void three()
	{
		display.appendText("3");
	}
	private void four()
	{
		display.appendText("4");
	}
	private void five()
	{
		display.appendText("5");
	}
	private void six()
	{
		display.appendText("6");
	}
	private void seven()
	{
		display.appendText("7");
	}
	private void eight()
	{
		display.appendText("8");
	}
	private void nine()
	{
		display.appendText("9");
	}
	private void plus()
	{
		display.appendText("+");
	}
	private void minus()
	{
		display.appendText("-");
	}
	private void times()
	{
		display.appendText("×");
	}
	private void divides()
	{
		display.appendText("÷");
	}
	private void percent()
	{
		display.appendText("%");
	}
	private void parentheses()
	{
		
		if(count % 2 == 0)
		{
			display.appendText("(");
			count++;
		}
		else
		{
			display.appendText(")");
			count++;
		}
	}

	
	
		
	
	public static void main(String[] args) {
		launch(args);
	}
}
