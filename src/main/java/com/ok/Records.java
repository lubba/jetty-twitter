package com.ok;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Records {
    private final static int numInFile = 1000;
    private static File directory;
	private static ArrayList<File> files;
    public static void add(String line){
        if (files == null){
            files = new ArrayList<File>();
        }
        if (files.isEmpty()){
            addNewFile();
        }
        File file = files.get(files.size() - 1);

        if (file.length() > numInFile){
            file = addNewFile();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.append(line);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private static File addNewFile() {
        String filename = getNewFileName();
        File file = null;
            try {
                file = new File(directory.getCanonicalPath()+"/"+filename);
                files.add(file);
                if (file.exists()){
                    throw new IndexOutOfBoundsException("This cannot be");
                    //TODO change on cycle
                }
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return file;
    }

    private static String getNewFileName() {
        return null;
    }

    public static ArrayList<Tweet> get() {
		return null;
	}

    public static void init(){
        String dir = "alltweets/";
        directory = new File(dir);
        if (!directory.exists())
            directory.mkdir();
        System.out.println(directory.getAbsoluteFile());
        files = (ArrayList<File>) Arrays.asList(directory.listFiles());
        for (File file : files)
            System.out.println(file.getName());
    }

    static {
        init();
    }

}
