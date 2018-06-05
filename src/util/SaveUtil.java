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

/**
 * All rights reserved 
 * The source code is protected to its owner
 *
 * @author Abed
 */
public class SaveUtil {
    public static void saveFile(String content, String fileName){
        try {
            File file = new File(fileName);
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
            out.write(content);
            out.close();
        } catch (IOException e) {
        }
    }

    
   
}

