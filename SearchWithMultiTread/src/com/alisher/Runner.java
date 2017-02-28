package com.alisher;

import java.io.File;

public class Runner implements Runnable {

    private String path;
    private String searchName;

    public Runner(String path, String searchName) {

        this.path = path;
        this.searchName = searchName;
    }

    private void search(String path, String searchName) {

        File srcFile = new File(path);
        String[] list = srcFile.list();
        if(list != null){
            for (String filename : list) {
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

    @Override
    public void run() {
        search(path,searchName);
    }
}
