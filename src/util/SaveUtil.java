/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * All rights reserved The source code is protected to its owner
 *
 * @author Abed
 */
public class SaveUtil {

    public static void saveFile(String content, String fileName) {

        try {
            File file = new File(fileName);
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
            out.write(content);
            out.close();
        } catch (IOException e) {
        }
    }

    public static void saveAs(String content, String fileName) throws IOException {
        Stage stage = (Stage) util.Session.getAttribut("stage");
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        Path dest = fileChooser.showSaveDialog(stage).toPath();
        if (dest != null) {
            try {
                Files.write(dest,content.getBytes());
            } catch (IOException ex) {
                // handle exception...
            }
        }
    }
    
    
        private static void configureFileChooser(final FileChooser fileChooser) {      
            fileChooser.setTitle("Save XML file...");
            fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
            );                 
            fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("All Images", "*.*"),
//                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("XML File", "*.xml")
            );
    }

}
