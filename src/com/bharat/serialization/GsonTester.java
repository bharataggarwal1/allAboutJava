package com.bharat.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

//check documentation of Serializable
public class GsonTester {
    public static void main(String args[]) {

        //Gson doesn't need class to implement Serializable but its fields should be serializable, and
        // it should have constructors/getters/setters
        GsonTester tester = new GsonTester();
        try {
            Student student = new Student();
            student.setAge(10);
            student.setName("Mahesh");
            tester.writeJSON(student);
            Student student1 = tester.readJSON();
            System.out.println(student1);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJSON(Student student) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("student.json");
        writer.write(gson.toJson(student));
        writer.close();
    }

    private Student readJSON() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("student.json"));

        return gson.fromJson(bufferedReader, Student.class);
    }
}

class Student {
    private String name;
    private int age;
    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student [ name: "+name+", age: "+ age+ " ]";
    }
}
