package HW1Q3;

import java.io.*;

public class MyMain {

    public static void main(String[] args) {
        PersonList personList = new PersonList();
        String inputFileName = "HW1Q3/data.txt";

        try {
            System.out.println("Reading from data file: " + inputFileName);
            System.out.println();
            FileInputStream inputFileStream = new FileInputStream(inputFileName);
            personList.store(inputFileStream);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file: " + inputFileName);
            return;
        }

        System.out.println("Displaying objects from persons list: ");
        personList.display(System.out);
        System.out.println();

        System.out.println("Searching persons list based on ID: ");
        System.out.println("Find result for ID 1: " + personList.find("1"));
        System.out.println("Find result for ID 10: " + personList.find("10"));
        System.out.println();
    }
}
