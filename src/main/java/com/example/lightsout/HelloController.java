package com.example.lightsout;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private GridPane grid;
    private int SIZE = 3;
    private Button[][] cells = new Button[SIZE][SIZE];
    private boolean[][] states = new boolean[SIZE][SIZE];
    private int click;
    @FXML
    private RadioButton tri;
    @FXML
    private RadioButton pet;
    @FXML
    private Label pocetL;

    @FXML
    public void initialize() {
        generateButtons();
    }

    protected void generateButtons() {
        /*for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button button = new Button();
                button.setPrefSize(100, 100);

                states[i][j] = true;


                int x = i;
                int y = j;

                button.setOnAction(e -> handleClick(x, y));

                grid.add(button, i, j);

                cells[i][j] = button;
                updateColor(i, j);
            }
        }*/
        if (tri.isSelected()) {
            grid.getChildren().clear();
            SIZE=3;
            cells = new Button[SIZE][SIZE];
            states = new boolean[SIZE][SIZE];
            click = 0;
            pocetL.setText("Pocet kliknutí: "+click);
            Random rand = new Random();
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {

                    int c = rand.nextInt(1,3);
                    int x = i;
                    int y = j;
                    Button button = new Button();
                    if (c == 1) {

                        button.setPrefSize(100, 100);
                        states[i][j] = true;
                    }
                    else if (c == 2) {

                        button.setPrefSize(100, 100);
                        states[i][j] = false;
                    }
                    button.setOnAction(e -> handleClick(x, y));

                    grid.add(button, i, j);

                    cells[i][j] = button;
                    updateColor(i, j);
                }
            }
        }
        else if (pet.isSelected()) {
            SIZE=5;
            cells = new Button[SIZE][SIZE];
            states = new boolean[SIZE][SIZE];
            click = 0;
            pocetL.setText("Pocet kliknutí: "+click);

            Random rand = new Random();
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {

                    int c = rand.nextInt(1,3);
                    int x = i;
                    int y = j;
                    Button button = new Button();
                    if (c == 1) {

                        button.setPrefSize(100, 100);
                        states[i][j] = true;
                    }
                    else if (c == 2) {

                        button.setPrefSize(100, 100);
                        states[i][j] = false;
                    }
                    button.setOnAction(e -> handleClick(x, y));

                    grid.add(button, i, j);

                    cells[i][j] = button;
                    updateColor(i, j);
                }
            }
        }

    }

    @FXML
    protected boolean check() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (states[i][j] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    @FXML
    private void handleClick(int x, int y) {
        toggle(x, y);

        toggle(x - 1, y);
        toggle(x + 1, y);
        toggle(x, y - 1);
        toggle(x, y + 1);
        click++;
        pocetL.setText("Pocet kliknutí: " + click);




        if (check() == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("MAX WIN");
            alert.setHeaderText("MAX WIN");
            alert.setContentText("MAX WIN");
            alert.showAndWait();
        }
    }

    @FXML
    private void toggle(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            states[x][y] = !states[x][y];
            updateColor(x, y);
        }
    }

    @FXML
    private void updateColor(int x, int y) {
        if (states[x][y]) {
            cells[x][y].setStyle("-fx-background-color: yellow;");
        } else {
            cells[x][y].setStyle("-fx-background-color: gray;");
        }
    }




}
