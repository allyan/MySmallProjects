package com.alisher;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        join("C:\\...");
    }

    public static void join(String FilePath) {
        int i = 0;
        File filename = new File(FilePath);
        String[] splitFiles = filename.list();
        try {
            while (i < splitFiles.length-1) {
                File infileName = new File(FilePath + "\\" + splitFiles[i++]);
                File joinFolder = new File(FilePath + "\\" + "JoinFolder");
                joinFolder.mkdir();
                File outfileName = new File(joinFolder + "\\" + "JoinFiles" + splitFiles[0].substring(splitFiles[0].indexOf('.')));
                if (infileName.exists()) {
                    FileOutputStream outfile = new FileOutputStream(outfileName, true);
                    FileInputStream infile = new FileInputStream(infileName);
                    byte[] buffer = new byte[1024];
                    int actuallyRead;
                    while ((actuallyRead = infile.read(buffer)) > 0){
                        outfile.write(buffer,0,actuallyRead);
                    }
                    infile.close();
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}