package main.java;

import au.com.bytecode.opencsv.CSVReader;
import main.java.beans.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    /**
     * @param path - путь к файлу, содержащему данные
     * @return - список людей
     * @throws IOException
     */
    public static List<Person> getPersonList(String path) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path), ';');
        if (reader == null) {
            throw new FileNotFoundException(path);
        }
        List<Person> people = new ArrayList<>();
        String[] nextLine = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            people.add(new Person(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[2], Integer.parseInt(nextLine[5]), nextLine[3], getDepartmentID(nextLine[4], people), nextLine[4]));
        }
        return people;
    }

    /**
     * @param list - список людей
     */
    public static void print(List<Person> list) {
        for (Person i : list) {
            System.out.print(i.toString());
            System.out.print("\n");
        }
    }

    private static int getDepartmentID(String name, List<Person> list) {
        int id=0;
        if(!list.isEmpty()){
            id=list.get(list.size()-1).getDepartment().getID()+1;
        }
        return id;
    }
}
