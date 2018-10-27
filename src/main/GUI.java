package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
    private GridPane gridPane;
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    private Button enter,multiply,divide,add,subtract,clear,clearRecent,backspace,sign,decimal;
    private StringBuilder string1 = new StringBuilder(); // holds the numbers
    private StringBuilder string2 = new StringBuilder(); // holds the operation
    private Text output = new Text(12.5, 65, "0");

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Rectangle display = new Rectangle(250, 75, Color.WHITE); // numbers will be displayed over this
        pane.getChildren().add(display);
        // gridPane made the most sense for a calculator
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);
        addButtons();
        buttonLogic();

        output.setFont(new Font("Courier New",32));
        pane.getChildren().add(output);

        BorderPane borderPane = new BorderPane(); // holds both the regular Pane and the gridPane
        borderPane.setTop(pane);
        borderPane.setCenter(gridPane);
        BorderPane.setAlignment(gridPane, Pos.CENTER);

        Scene scene = new Scene(borderPane, 250,375);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    private void buttonLogic(){
        // using lambda expressions to perform actions based on input
        button0.setOnAction(event -> string1.append(0));
        button1.setOnAction(event -> string1.append(1));
        button2.setOnAction(event -> string1.append(2));
        button3.setOnAction(event -> string1.append(3));
        button4.setOnAction(event -> string1.append(4));
        button5.setOnAction(event -> string1.append(5));
        button6.setOnAction(event -> string1.append(6));
        button7.setOnAction(event -> string1.append(7));
        button8.setOnAction(event -> string1.append(8));
        button9.setOnAction(event -> string1.append(9));
        // these commands required more than 1 action or conditions, so can't use lambda expressions
        backspace.setOnAction(new Handler());
        decimal.setOnAction(new Handler());
        clear.setOnAction(new Handler());
        multiply.setOnAction(new Handler());
        divide.setOnAction(new Handler());
        subtract.setOnAction(new Handler());
        add.setOnAction(new Handler());
        enter.setOnAction(new Handler());
    }

    private void addButtons(){
        // Creates button objects with respective icon
        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        button5 = new Button("5");
        button6 = new Button("6");
        button7 = new Button("7");
        button8 = new Button("8");
        button9 = new Button("9");
        button0 = new Button("0");
        enter = new Button("=");
        divide = new Button("/");
        multiply = new Button("*");
        subtract = new Button("-");
        add = new Button("+");
        clear = new Button("C");
        clearRecent = new Button("CE");
        backspace = new Button("<-");
        sign = new Button("+/-");
        decimal = new Button(".");
        // sets the size of every button to 50x50
        button1.setMinSize(50,50);
        button2.setMinSize(50,50);
        button3.setMinSize(50,50);
        button4.setMinSize(50,50);
        button5.setMinSize(50,50);
        button6.setMinSize(50,50);
        button7.setMinSize(50,50);
        button8.setMinSize(50,50);
        button9.setMinSize(50,50);
        button0.setMinSize(50,50);
        enter.setMinSize(50,50);
        multiply.setMinSize(50,50);
        divide.setMinSize(50,50);
        add.setMinSize(50,50);
        subtract.setMinSize(50,50);
        clear.setMinSize(50,50);
        clearRecent.setMinSize(50,50);
        backspace.setMinSize(50,50);
        sign.setMinSize(50,50);
        decimal.setMinSize(50,50);
        // adds buttons to Pane
        gridPane.add(clear, 0,0);
        gridPane.add(clearRecent, 1,0);
        gridPane.add(backspace, 2,0);
        gridPane.add(divide, 3,0);
        gridPane.add(button7, 0,1);
        gridPane.add(button8, 1,1);
        gridPane.add(button9, 2,1);
        gridPane.add(multiply, 3,1);
        gridPane.add(button4, 0,2);
        gridPane.add(button5, 1,2);
        gridPane.add(button6, 2,2);
        gridPane.add(subtract, 3,2);
        gridPane.add(button1, 0,3);
        gridPane.add(button2, 1,3);
        gridPane.add(button3, 2,3);
        gridPane.add(add, 3,3);
        gridPane.add(sign, 0,4);
        gridPane.add(button0, 1,4);
        gridPane.add(decimal, 2,4);
        gridPane.add(enter, 3,4);
    }

    class Handler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == enter) {
                if (!(string1.toString().isEmpty() || string2.toString().isEmpty())) {
                    // 'x' will be the first part of the String before the space and 'y' is after
                    int n = string1.toString().lastIndexOf(" ");

                    try {
                        Double x = Double.parseDouble(string1.substring(0, n));
                        Double y = Double.parseDouble(string1.substring(n, string1.length()));

                        if (string2.toString().endsWith("+")) {
                            output.setText(Double.toString(x+y));
                        }
                        if (string2.toString().endsWith("-")) {
                            output.setText(Double.toString(x-y));
                        }
                        if (string2.toString().endsWith("*")) {
                            output.setText(Double.toString(x*y));
                        }
                        if (string2.toString().endsWith("/")){
                            output.setText(Double.toString(x/y));
                        }
                    } catch (NumberFormatException e) {
                        output.setText("Error");
                    }
                    string1.delete(0, string1.length());
                    string2.delete(0, string2.length());
                }
            }
            if (event.getSource() == multiply) {
                string2.append("*");
                string1.append(" ");
            }
            if (event.getSource() == divide) {
                string2.append("/");
                string1.append(" ");
            }
            if (event.getSource() == add) {
                string1.append(" ");
                string2.append("+");
            }
            if (event.getSource() == subtract) {
                string2.append("-");
                string1.append(" ");
            }
            if (event.getSource() == clear) {
                string1.delete(0, string1.length());
                string2.delete(0, string2.length());
                output.setText("0");
            }
            if (event.getSource() == decimal) {
                if (!string1.toString().contains(".")) {
                    string1.append(".");
                }
            }
            // Can't use backspace if there's no value
            if (event.getSource() == backspace) {
                if (!string1.toString().isEmpty()) {
                    string1.deleteCharAt(string1.length() - 1);
                }
            }
        }
    }
}
