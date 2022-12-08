package main.test;

import main.java.Parser;
import main.java.beans.Person;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {

    @org.junit.jupiter.api.Test
    void getPersonList() {
        Parser temp = new Parser();
        String path = null;
        Throwable thrown = assertThrows(NullPointerException.class, () -> {
            temp.getPersonList(path);
        });
    }

    @org.junit.jupiter.api.Test
    void print() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Parser temp = new Parser();
        String path = "D:\\foreign_names.csv";
        List<Person> list = temp.getPersonList(path);
        temp.print(list);

        String expectedOutput = new String();
        for (Person i : list) {
            expectedOutput += i.toString();
            expectedOutput += "\n";
        }

        assertEquals(expectedOutput, outContent.toString());
    }
}