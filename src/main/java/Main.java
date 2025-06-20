import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage GUI) {
        Calc calc = new Calc();

         // creating a terminal that shows the current input string
        TextField Terminal = new TextField();
        Terminal.setEditable(false);
        Terminal.setPrefWidth(130);

        // grid for numbers & operators 
        GridPane userInput = new GridPane();
        userInput.setHgap(5);
        userInput.setVgap(5);

        //maingrid as grid for following grids
        GridPane mainGrid = new GridPane();
        mainGrid.setVgap(5);
        mainGrid.add(userInput, 0, 1);
        mainGrid.add(Terminal, 0, 0);

        mainGrid.setAlignment(Pos.CENTER);

        // creating buttons & adding to userInput grid
        // ( ) b +  
        // 1 2 3 -
        // 4 5 6 *
        // 7 8 9 / 
        // 0     =  
        Button bOpen  = new Button("(");
        Button bClose = new Button(")");
        Button bBack  = new Button("back");
        Button bPlus  = new Button("+");
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button bMinus = new Button("-");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button bMul = new Button("*");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button bDiv = new Button("/");
        Button b0 = new Button("0");
        Button bEqual = new Button("=");
        Button C = new Button("C");
        Button point = new Button(".");

        userInput.add(bOpen,  0, 0);
        userInput.add(bClose, 1, 0);
        userInput.add(bBack,  2, 0);
        userInput.add(bPlus,  3, 0);
        userInput.add(b1, 0, 1);
        userInput.add(b2, 1, 1);
        userInput.add(b3, 2, 1);
        userInput.add(bMinus, 3, 1);
        userInput.add(b4, 0, 2);
        userInput.add(b5, 1, 2);
        userInput.add(b6, 2, 2);
        userInput.add(bMul, 3, 2);
        userInput.add(b7, 0, 3);
        userInput.add(b8, 1, 3);
        userInput.add(b9, 2, 3);
        userInput.add(bDiv, 3, 3);
        userInput.add(b0, 0, 4);
        userInput.add(bEqual, 3, 4);
        userInput.add(point, 1, 4);
        userInput.add(C,2,4);

        // handler for pressing buttons
        EventHandler<ActionEvent> handler = e -> {
                Button clicked = (Button) e.getSource();
                String text = clicked.getText();
                if (text.equals("back") && !Terminal.getText().isEmpty()) {
                    Terminal.setText(Terminal.getText().substring(0, Terminal.getText().length() - 1));
                } else if (text.equals("back") && Terminal.getText().isEmpty()) {
                    // nothing as text is empty already
                } else if (text.equals("C")) {
                    Terminal.setText("");
                } else if (!text.equals("=")) {
                    Terminal.setText(Terminal.getText() + text);
                } else {
                    Terminal.setText(calc.evaluate(Terminal.getText()));
                }
                // =-Taste kann hier später mit Berechnung verbunden werden
        };

        bOpen.setOnAction(handler);
        bClose.setOnAction(handler);
        bBack.setOnAction(handler);
        bPlus.setOnAction(handler);
        b1.setOnAction(handler);
        b2.setOnAction(handler);
        b3.setOnAction(handler);
        bMinus.setOnAction(handler);
        b4.setOnAction(handler);
        b5.setOnAction(handler);
        b6.setOnAction(handler);
        bMul.setOnAction(handler);
        b7.setOnAction(handler);
        b8.setOnAction(handler);
        b9.setOnAction(handler);
        bDiv.setOnAction(handler);
        b0.setOnAction(handler);
        bEqual.setOnAction(handler);
        C.setOnAction(handler);
        point.setOnAction(handler);


        Scene scene = new Scene(mainGrid, 140, 180);
        GUI.setScene(scene);
        GUI.setTitle("calculator");
        GUI.show();

    }
}