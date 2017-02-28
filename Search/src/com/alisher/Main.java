package com.alisher;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        search("C:\\","oliv");

    }

    private static void search(String path, final String searchName) {

        File srcFile = new File(path);
        String[] list = srcFile.list();
        if(list != null){
            for (String filename : list ) {
                File temp = new File(path + File.separator + filename);
                boolean contain = temp.getAbsolutePath().toLowerCase().contains(searchName.toLowerCase());
                if(contain) {
                    System.out.println("\"" + searchName + "\"" + " Found => " + temp);
                }
                if (temp.isDirectory() && !contain) {
                    search(temp.getPath(), searchName);
                }
            }
        }
        else {
            return;
        }
    }


}

