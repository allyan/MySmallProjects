package com.alisher;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        search("C:\\","150");

    }

    private static void search(String path, final String searchName) {
        File f = new File(path);
        File[] folders = f.listFiles();
        for (File folder: folders) {
            if(folder.isDirectory()){
                (new Thread(new Runner(folder.getAbsolutePath(),searchName))).start();
                System.out.println("Searching in : " + folder.getPath() + "...");
            }
        }
    }
}

