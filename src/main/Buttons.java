package main;

import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.LinkedList;

import static main.Launcher.string1;
import static main.Launcher.gridPane;

public class Buttons {
    private static Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    static Button enter,multiply,divide,add,subtract,clear,clearRecent,backspace,sign,decimal;
    private static LinkedList<Button> buttonList = new LinkedList<>();

    static void buttonLogic(){
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

    static void createButtons(){
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
        // adds buttons to list to modify
        Button[] arr = {button1, button2, button3, button4,
        button5, button6, button7, button8, button9, button0,
        enter, divide, multiply, subtract, add, clear, 
        clearRecent, backspace, sign, decimal};
        buttonList.addAll(Arrays.asList(arr));
    }

    static void setButtonSize(){
    // sets the size of every button to 50x50
        for (Button button : buttonList){
            button.setMinSize(50,50);
        }
    }

    static void addButtons(){
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
}
