/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahvel;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Jegor Bakunin
 */

//Графический интерфейс в котором можно выбирать файлы
public class FileChooser {

    public static String main(File selectedFile ) {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog (null);

        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
            selectedFile = jfc.getSelectedFile();

        } 
        return selectedFile.getAbsolutePath();
    } 
}