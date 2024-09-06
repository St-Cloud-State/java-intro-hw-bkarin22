package HW1Q2;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();
        String inputFileName = "HW1Q2/data.txt";

        try {
            System.out.println("Reading from data file: " + inputFileName);
            System.out.println();
            FileInputStream inputFileStream = new FileInputStream(inputFileName);
            store(inputFileStream, personList);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file: " + inputFileName);
            return;
        }

        System.out.println("Displaying objects from persons list: ");
        display(System.out, personList);
        System.out.println();

        System.out.println("Searching persons list based on ID: ");
        System.out.println("Find result for ID 1: " + find("1", personList));
        System.out.println("Find result for ID 10: " + find("10", personList));
        System.out.println();
    }

    public static void store(InputStream inputStream, LinkedList<Person> personList) {
        Scanner scanner = new Scanner(inputStream);
        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNumber++;
            String[] parts = line.split(",");
            
            if (parts.length == 3) {
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                String id = parts[2].trim();
                Person person = new Person(firstName, lastName, id);
                personList.add(person);
            } else {
                // Print an error message if the data is not formatted correctly
                System.out.println("Error: Bad data on line " + lineNumber + ": " + line);
            }
        }
        scanner.close();
    }    

    public static void display(PrintStream outputStream, LinkedList<Person> personList) {
        for (Person person : personList) {
            outputStream.println(person.toString());
        }
    }

    public static int find(String sid, LinkedList<Person> personList) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1; // Returns -1 if no person object with that id exists
    }
}
