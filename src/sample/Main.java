package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.math.BigInteger;
import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX ch1018");
        primaryStage.show();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        Scene scene = new Scene(grid, 700, 375);
        primaryStage.setScene(scene);


        Text scenetitle = new Text("Five prime numbers that larger than Long.MAX_VALUE are:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button btn = new Button("show");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 7);

        final Text result = new Text();
        grid.add(result, 1, 8);


        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {


                result.setText(bigprimes(5));

            }
        });
    }


    public static String bigprimes(int count) {

        BigInteger temp = BigInteger.valueOf(Long.MAX_VALUE);
        String ans = "";
        int i = 0;
        while (i < count) {
            temp = temp.nextProbablePrime();
            ans += temp.toString() + ", ";
            i++;

        }

        return ans;


    }


}