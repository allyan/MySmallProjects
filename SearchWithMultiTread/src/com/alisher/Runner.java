package com.alisher;

import java.io.File;

public class Runner implements Runnable {

    private File path;
    private String searchName;

    public Runner(File path, String searchName) {

        this.path = path;
        this.searchName = searchName;
    }

    private void search(File path, String searchName) {
        
        File[] list = path.listFiles();
        if(list != null){
            for (File filename : list) {
                boolean contain = filename.getName().toLowerCase().contains(searchName.toLowerCase());
                if(contain) {
                    System.out.println("\"" + searchName + "\"" + " Found => " + filename);
                }
                if (filename.isDirectory() && !contain) {
                    search(filename,searchName);        //31 sec.
//                    (new Thread(new Runner(filename,searchName))).start();       // 39 sec.   25% slowly
                }
            }
        }
        else {
            return;
        }
    }

    @Override
    public void run() {
        search(path,searchName);
    }
}
