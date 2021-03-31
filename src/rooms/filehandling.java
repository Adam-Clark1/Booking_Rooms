/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class filehandling {

    private static String folderDirectory = System.getProperty("user.dir") + "\\bookedrooms.txt";

    public static void writeFile(ArrayList<booking> books) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < books.size(); i++) {
                printToFile.println(books.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<booking> readFile() {
        ArrayList<booking> books = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] bookDetails = lineFromFile.split(", ");

                booking newbook = new booking(bookDetails[0], bookDetails[1], Integer.parseInt(bookDetails[2]), bookDetails[3]);
                books.add(newbook);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return books;
    }
}

    

