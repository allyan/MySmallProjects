package com.alisher;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        split("C:\\Users\\Allyan\\Desktop\\myFiles\\MV TEAM QUEST Bunker Survey.JPG", 6);
    }

    public static void split(String FilePath, long splitParts) {
        File filename = new File(FilePath);
        filename.length();
        long splitlength = filename.length() / splitParts;
        long lengthInFile = 0, length = 0;
        int counter = 1, data;
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filename));
            File splitFiles = new File(filename.getParentFile() + "\\" + "SplitFiles_" + filename.getName().substring(0,filename.getName().indexOf('.')));
            splitFiles.mkdir();
            data = in.read();
            while (data != -1) {
                File splitNames = new File(splitFiles + "\\" + filename.getName().substring(0,filename.getName().indexOf('.')) + "(" + counter++ + ")" + filename.getName().substring(filename.getName().indexOf('.')));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(splitNames));
                while (data != -1 && length < splitlength) {
                    out.write(data);
                    length++;
                    data = in.read();
                }
                lengthInFile += length;
                length = 0;
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
