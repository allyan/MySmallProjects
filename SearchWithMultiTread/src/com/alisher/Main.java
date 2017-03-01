package com.alisher;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        search("myfile");

    }

    private static void search(final String searchName) {
        File f = new File("C:\\");
        File[] folders = f.listFiles();
        for (File folder: folders) {
            if(folder.isDirectory()){
                (new Thread(new Runner(folder,searchName))).start();
                System.out.println("Searching in : " + folder + "...");
            }
        }
    }
}

