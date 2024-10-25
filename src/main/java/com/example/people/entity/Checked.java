package com.example.people.entity;

import java.io.FileReader;
import java.io.IOException;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Checked {
    public static void main(String[] args) {
        try {
            File file = new File("nonexistentfile.txt");
            Scanner scanner = new Scanner(file);  // This may throw FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
