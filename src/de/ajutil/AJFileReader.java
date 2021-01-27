package de.ajutil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AJFileReader {

    public static final String ASK_FILENAME = "Welche Datei soll ausgelesen werden?";

    /**
     *  Always asks for filename and reads next Line from console
     */
    public AJFileReader(boolean askForFilename) {
        // New instance of Scanner to read console
        Scanner sc = new Scanner(System.in);
        String filename;

        // Ask for Filename
        while (askForFilename) {
            System.out.println(ASK_FILENAME);
            filename = sc.nextLine();

            // Add ".txt" if necessary
            if (!filename.endsWith(".txt")) {
                filename += ".txt";
            }

            // Starts reading
            // askForFilename = false if reading successful -> stops loops
            askForFilename = !startReading(filename);
        }
    }



    /**
     *  Starts reading with filename instantly
     */
    public AJFileReader(String filename) {
        startReading(filename);
    }


    /**
     *  Reads the file line by line an call the abstract method readLine
     */
    private boolean startReading(String filename) {
        // Catch FileNotFound Exception
        try {
            // Gets file
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            // Read file line by line
            while (fileScanner.hasNextLine()) {

                // Read the File Line by Line
                String line = fileScanner.nextLine();
                readLine(line);
            }

            // Close File reader
            fileScanner.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }



    // PLS OVERRIDE
    // method in which
    public abstract void readLine(String line);

}
