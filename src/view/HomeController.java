/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.SaveUtil;

/**
 * FXML Controller class
 *
 * @author Abed
 */
public class HomeController implements Initializable {
    
    @FXML
    private TextArea finalText;
    @FXML
    private Button textField;
    @FXML
    private Button textArea;
    @FXML
    private Button button;
    @FXML
    private Button checkBox;
    @FXML
    private Button comboBox;
    @FXML
    private MenuItem cancel;
    @FXML
    private MenuItem save = new MenuItem();
    @FXML
    private AnchorPane designArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<fenetre>\n");
        textArea.setOnAction(a -> {
            finalText.appendText("<texta></texta>");
            finalText.appendText("\n");
        });
        button.setOnAction(a -> {
            finalText.appendText("<botona></botona>");
            finalText.appendText("\n");
        });
        checkBox.setOnAction(a -> {
            finalText.appendText("<checkboxa></checkboxa>");
            finalText.appendText("\n");
        });
        comboBox.setOnAction(a -> {
            finalText.appendText("<comboxa></comboxa>");
            finalText.appendText("\n");
        });
        textField.setOnAction(a -> {
            finalText.appendText("<textfilda></textfilda>");
            finalText.appendText("\n");
        });
        textField.setOnMouseEntered(mouseEvent -> {
            if (!mouseEvent.isPrimaryButtonDown()) {
                textField.getScene().setCursor(Cursor.HAND);
            }
        });
        
        textField.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
//                dragDelta.x = textField.getCenterX() - mouseEvent.getX();
//                dragDelta.y = textField.getCenterY() - mouseEvent.getY();
                System.out.println("on mouse pressed");
                textField.getScene().setCursor(Cursor.MOVE);
            }
        });
        textField.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                textField.getScene().setCursor(Cursor.HAND);
            }
        });
        textField.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//    textField.setCenterX(mouseEvent.getX() + dragDelta.x);
//    textField.setCenterY(mouseEvent.getY() + dragDelta.y);
                System.out.println("on mouse dragged");
            }
        });
        textField.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    textField.getScene().setCursor(Cursor.HAND);
                }
            }
        });
        textField.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    textField.getScene().setCursor(Cursor.DEFAULT);
                }
            }
        });
        
    }
    
    public void save(ActionEvent ae) {
        if (!finalText.getText().endsWith("</fenetre>")) {
            finalText.appendText("\n</fenetre>");
        }
        SaveUtil.saveFile(finalText.getText(), "xmlfile.xml");
    }

    public void close(ActionEvent ae) {
        System.exit(0);
    }
    
}
