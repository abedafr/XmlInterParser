/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
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
    @FXML
    private Button container;
    @FXML
    private TreeView<String> tree;

    private TreeItem<String> root;
    @FXML
    private Button delete;
    @FXML
    private Button deleteAll;
    @FXML
    private MenuItem genHTML;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root = new TreeItem<>("Fenetre");
//        tree = new TreeView<>(root);
        tree.setRoot(root);
        root.setExpanded(true);
        System.out.println("tree " + tree.getRoot());
        textField.setOnAction(a -> {
            addTreeItem("TextField");
            finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + genXml());
        });
        textArea.setOnAction(a -> {
            addTreeItem("TextArea");
            finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + genXml());
        });
        button.setOnAction(a -> {
            addTreeItem("Button");
            finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + genXml());
        });
        checkBox.setOnAction(a -> {
            addTreeItem("CheckButton");
            finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + genXml());
        });
        comboBox.setOnAction(a -> {
            addTreeItem("ComboBox");
            finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + genXml());
        });

        container.setOnAction(a -> {
            addTreeItem("Container");
            finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + genXml());
        });

        delete.setOnAction(a -> {
            TreeItem<String> selected = tree.getSelectionModel().getSelectedItem();
            if (selected != null) {
                if (!selected.isLeaf()) {
                    Platform.runLater(() -> {
                        selected.getChildren().stream().forEach((object) -> {
                            selected.getChildren().remove(object);
                        });
                    });
                }
                selected.getParent().getChildren().remove(selected);
                tree.refresh();
                finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + genXml());
            }
        });
        deleteAll.setOnAction(a -> {
            tree.setRoot(new TreeItem<>("Fenetre"));
            finalText.setText("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + genXml());

        });
    }

    public void addTreeItem(String value) {
        if (tree.getSelectionModel().getSelectedItem() != null) {
            if ("Container".equals(tree.getSelectionModel().getSelectedItem().getValue())) {
                tree.getSelectionModel().getSelectedItem().getChildren().add(new TreeItem<>(value));
            } else {
                if (!"Fenetre".equals(tree.getSelectionModel().getSelectedItem().getValue())) {
                    tree.getSelectionModel().select(tree.getSelectionModel().getSelectedItem().getParent());
                }
                tree.getSelectionModel().getSelectedItem().getChildren().add(new TreeItem<>(value));
                tree.getSelectionModel().getSelectedItem().setExpanded(true);
            }
        } else {
            tree.getSelectionModel().select(root);
            tree.getSelectionModel().getSelectedItem().getChildren().add(new TreeItem<>(value));
            tree.getSelectionModel().getSelectedItem().setExpanded(true);
        }
        tree.setRoot(root);

    }

    public String genXml() {
        String xmlGen = "";
        xmlGen += iterXml(tree.getRoot(), xmlGen);
        int i = xmlGen.lastIndexOf("<fenetre>");
        xmlGen = xmlGen.substring(i, xmlGen.length());
        return xmlGen;
    }

    public String iterXml(TreeItem<String> racine, String xmlText) {
        xmlText += "<" + racine.getValue().toLowerCase() + ">\n";
        for (TreeItem<String> item : racine.getChildren()) {
            xmlText += "\t";
            if (item.getChildren().isEmpty()) {
                xmlText += "<" + item.getValue().toLowerCase() + ">";
                xmlText += "</" + item.getValue().toLowerCase() + ">\n";
            } else {
                xmlText += "\t" + iterXml(item, xmlText);
            }
        }
        xmlText += "</" + racine.getValue().toLowerCase() + ">\n";
        return xmlText;
    }

    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("Open Text File");
//            fileChooser.setInitialDirectory(
//                new File(System.getProperty("user.home"))
//            );                 
        fileChooser.getExtensionFilters().addAll(
                //                new FileChooser.ExtensionFilter("All Images", "*.*"),
                //                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
    }

    @FXML
    public void save(ActionEvent ae) throws IOException {
        SaveUtil.saveAs(finalText.getText(), "xmlfile.xml");
    }

    @FXML
    public void close(ActionEvent ae) {
        System.exit(0);
    }

    @FXML
    private void saveHTML(ActionEvent event) {
        // fetah
    }

}
