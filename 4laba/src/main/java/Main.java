package main.java;

import main.java.beans.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "D:\\foreign_names.csv";
        List<Person> people = Parser.getPersonList(path);
        Parser.print(people);
    }

}
