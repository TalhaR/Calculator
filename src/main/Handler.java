package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static main.Launcher.string1;
import static main.Launcher.string2;
import static main.Launcher.output;

public class Handler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == Buttons.enter) {
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
        if (event.getSource() == Buttons.multiply) {
            string2.append("*");
            string1.append(" ");
        }
        if (event.getSource() == Buttons.divide) {
            string2.append("/");
            string1.append(" ");
        }
        if (event.getSource() == Buttons.add) {
            string1.append(" ");
            string2.append("+");
        }
        if (event.getSource() == Buttons.subtract) {
            string2.append("-");
            string1.append(" ");
        }
        if (event.getSource() == Buttons.clear) {
            string1.delete(0, string1.length());
            string2.delete(0, string2.length());
            output.setText("0");
        }
        if (event.getSource() == Buttons.decimal) {
            if (!string1.toString().contains(".")) {
                string1.append(".");
            }
        }
        // Can't use backspace if there's no value
        if (event.getSource() == Buttons.backspace) {
            if (!string1.toString().isEmpty()) {
                string1.deleteCharAt(string1.length() - 1);
            }
        }
    }
}
