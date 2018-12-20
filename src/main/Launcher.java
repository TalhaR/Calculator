package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Launcher extends Application {
    static GridPane gridPane;
    static StringBuilder string1 = new StringBuilder(); // holds the numbers
    static StringBuilder string2 = new StringBuilder(); // holds the operation
    static Text output = new Text(12.5, 65, "0");

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

        Buttons.createButtons();
        Buttons.setButtonSize();
        Buttons.addButtons();
        Buttons.buttonLogic();

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
    public static void main(String[] args) {
        launch(args);
    }
}
