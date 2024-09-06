package HW1Q3;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> personList;

    public PersonList() {
        this.personList = new LinkedList<>();
    }

    public void store(InputStream inputStream) {
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
                System.out.println("Error: Bad data on line " + lineNumber + ": " + line);
            }
        }
        scanner.close();
    }

    public void display(PrintStream outputStream) {
        for (Person person : personList) {
            outputStream.println(person.toString());
        }
    }

    public int find(String sid) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1; // Returns -1 if no person object with that ID exists
    }
}
