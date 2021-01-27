package de.ajutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AJFileSaver {

    public static final String ASK_FILENAME = "In welcher Datei möchtest du speichern?";

    private BufferedWriter fileWriter;
    private int lines = 0;

    public AJFileSaver(boolean askForFilename) {
        // New instance of Scanner to read console
        Scanner sc = new Scanner(System.in);
        String filename = null;

        // Ask for Filename
        while (askForFilename) {
            System.out.println(ASK_FILENAME);
            filename = sc.nextLine();

            // Add ".txt" if necessary
            if (!filename.endsWith(".txt")) {
                filename += ".txt";
            }

            // Test if file exists
            File file = new File(filename);
            if (file.exists()) {
                System.out.println("Die Datei gibt es bereits!");
            } else {
                askForFilename = false;
            }
        }

        try {
            // Opens fileWriter
            fileWriter = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AJFileSaver(String filename) {
        try {
            // Opens fileWriter
            fileWriter = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addLine(String line) {
        try {
            fileWriter.write(line);
            fileWriter.newLine();
            lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(boolean printSucces) {
        try {
            fileWriter.close();
            System.out.println("Datei erfolgreich gespeichtert");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Getters 'n Setters */

}
