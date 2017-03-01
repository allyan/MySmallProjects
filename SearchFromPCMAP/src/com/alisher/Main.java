package com.alisher;

import java.io.*;

public class Main {

    private static int counter = 0;

    public static void main(String[] args) {

//        synchronize();          // run before using search ! after only for synchronize !
        search(".exe");

    }

    private static void  synchronize(){
        File pcMap = new File("pcMap.txt");
        if(pcMap.exists()){
            pcMap.delete();
        }
        createPCMAP("C:\\");
    }

    private static void createPCMAP(String pc){
        File srcFile = new File(pc);
        File pcMap = new File("pcMap.txt");
        try {
            FileOutputStream toTXT = new FileOutputStream(pcMap, true);
            File[] list = srcFile.listFiles();
            if(list != null){
                for (File filename : list ) {
                    if(filename.isFile()) {
                       toTXT.write(filename.getPath().getBytes());
                       toTXT.write("\n".getBytes());
                    }
                    if (filename.isDirectory()) {
                        createPCMAP(filename.getPath());
                    }
                }
            }
            else {
                return;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean search(final String searchName) {
        try{
            FileInputStream in = new FileInputStream("pcMap.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null){
                if(line.toLowerCase().contains(searchName.toLowerCase())){
                    System.out.println("\"" + searchName +"\" Founed => " + line);
                    counter++;
                }
            } System.out.println("<-----  \"" + searchName + "\"" + " founed : " + counter + " times  ----->");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}

