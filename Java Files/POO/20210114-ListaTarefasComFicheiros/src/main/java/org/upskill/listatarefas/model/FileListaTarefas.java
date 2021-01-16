/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import org.upskill.listatarefas.ui.AlertUI;

/**
 *
 * @author user
 */
public class FileListaTarefas {

    private static final String TASKS_FILE_DEFAULT = "tasks.tsk";

    private String fileName;

    public FileListaTarefas() {
        this.fileName = TASKS_FILE_DEFAULT;
    }

    public ListaTarefas readFromFile(File file) {
        ListaTarefas list = null;
        try (FileInputStream fileIn = new FileInputStream(file)) {
            ObjectInputStream inStream = new ObjectInputStream(fileIn);
            list = (ListaTarefas) inStream.readObject();
        } catch (ClassNotFoundException ex) {
            AlertUI.createUI(Alert.AlertType.ERROR, "Failed to convert Tasks from File.", "Failed to convert Tasks from File", ex.getMessage());
        } catch (IOException ex) {
            AlertUI.createUI(Alert.AlertType.ERROR, "Failed to read the file.", "Failed to read the file.", ex.getMessage());
//            ex.printStackTrace();
        } finally {
            return list;
        }
    }

    public ListaTarefas readFromFile() {
        File myFile = new File(TASKS_FILE_DEFAULT);
        return readFromFile(myFile);
    }

    public boolean saveAsTextFile(File myFile, ListaTarefas lista) {
        boolean result = false;
        try (PrintWriter pw = new PrintWriter(myFile);) {
            pw.append(lista.toString());
            result = true;
        } catch (FileNotFoundException ex) {
            AlertUI.createUI(Alert.AlertType.ERROR, "File Not Found.", "Couldn't open default file.", ex.getMessage());
            result = false;
        }
        return result;
    }
    
    public boolean saveToFile(ListaTarefas listaTarefas, File file) {
        File myFile = (file == null) ? myFile = new File(TASKS_FILE_DEFAULT) : file;
        
        boolean result = false;
        try (FileOutputStream fileOut = new FileOutputStream(myFile)) {
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(listaTarefas);
            result = true;
        } catch (FileNotFoundException ex) {
            AlertUI.createUI(Alert.AlertType.ERROR, "File Not Found.", "Couldn't open default file.", ex.getMessage());
        } catch (IOException ex) {
            AlertUI.createUI(Alert.AlertType.ERROR, "Error Reading/Writing file.", "Failed to Read/Write file.", ex.getMessage());
        }
        return result;
    }
    public void saveToFileSilently(ListaTarefas listaTarefas, File file) throws IOException {
        File myFile = new File(TASKS_FILE_DEFAULT);
        boolean result = false;
        try (FileOutputStream fileOut = new FileOutputStream(myFile)) {
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(listaTarefas);
            result = true;
        } 
    }
}
