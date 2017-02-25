package com.alisher;



public class Main {

    public static Scanner command = new Scanner(System.in);

    public static void main(String[] args) {

//        copyDir("C:\\Users\\Allyan\\Desktop\\myFiles\\SplitFiles_pic","C:\\Users\\Allyan\\Desktop\\myFiles\\copiedFilLe");
//            delete("C:\\Users\\Allyan\\Desktop\\myFiles");

    }

    private static boolean copyDir(final String src, final String dst) {
        System.out.println("Copying folder: " + src);
        final File srcFile = new File(src);
        final File dstFile = new File(dst);
        if (srcFile.exists() && srcFile.isDirectory() && !dstFile.exists()) {
            dstFile.mkdir();
            File nextSrcFile;
            String nextSrcFilename, nextDstFilename;
            for (String filename : srcFile.list()) {
                nextSrcFilename = srcFile.getAbsolutePath()
                        + File.separator + filename;
                nextDstFilename = dstFile.getAbsolutePath()
                        + File.separator + filename;
                nextSrcFile = new File(nextSrcFilename);
                System.out.println("separator : "+srcFile.getAbsolutePath());
                if (nextSrcFile.isDirectory()) {
                    copyDir(nextSrcFilename, nextDstFilename);
                } else {
                    copyFile(nextSrcFilename, nextDstFilename);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean copyFile(final String src, final String dst) {
        System.out.println("Copying file: " + src);
        final File srcFile = new File(src);
        final File dstFile = new File(dst);
        if (srcFile.exists() && srcFile.isFile() && !dstFile.exists()) {
            try {
                try (InputStream in = new FileInputStream(srcFile);
                     OutputStream out = new FileOutputStream(dstFile)) {
                    byte[] buffer = new byte[1024];
                    int bytes;
                    while ((bytes = in.read(buffer)) > 0) {
                        out.write(buffer, 0, bytes);
                    }
                return true;
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return false;
    }

    private static boolean delete(String filePath){
        File file = new File(filePath);
        String[] myFiles = file.list();
        int counter = 0;
        if(file.exists() && file.isFile()){
            file.delete();
            return true;
        }
        if(file.exists() && file.isDirectory()){
            File newFilePath;
            assert myFiles != null;
            for (String myFile : myFiles) {
                newFilePath = new File(file + File.separator + myFile);
                if (!(newFilePath.delete()) && newFilePath.isDirectory()) {
                    delete(newFilePath.getAbsolutePath());
                }
                if (newFilePath.isFile() && newFilePath.exists()) {
                    newFilePath.delete();
                    return true;
                }
            }
        }
        if(file.exists() && file.isDirectory() && file.delete()){
            file.delete();
            return true;
        }
        else System.out.println("FilePath is not exists !");
        return false;
    }
}
