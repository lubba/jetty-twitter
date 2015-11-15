package com.ok;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Records {
    private final static int numInFile = 1000;
    private static File directory;
	private static List<File> files;
	private static Logger logger = Logger.getLogger("Records");
	private static ArrayList<Tweet> tweets;
    public static void add(String line){
		logger.info("in add");
		if (files == null){
            files = new ArrayList<File>();
        }
        if (files.isEmpty()){
			try {
				addNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("Files size = "+ files.size());
        File file = files.get(files.size() - 1);

        if (file.length() > numInFile){
			try {
				file = addNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Tweet tweet = new Tweet("name",line);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(tweet.toString());
			writer.newLine();

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

    private static File addNewFile() throws IOException {
		logger.info("addNewFile");
		Random random = new Random();
		int i = random.nextInt();
		File file = new File(directory.getCanonicalPath() + "/" + i);
		while (file.exists()) {
			i = random.nextInt();
			file = new File(directory.getCanonicalPath() + "/" + i);
		}
		file.createNewFile();
		files.add(file);
		return file;
	}


    public static ArrayList<Tweet> get() {
		logger.info("get");
		String line;
		try {
			for (File file : files){
				BufferedReader reader = new BufferedReader(new FileReader(file));
				while ((line = reader.readLine()) != null) {
					String[] tweetinfo = line.split("&&");
					String name = "", text = "";
					if (tweetinfo != null && tweetinfo.length > 0) {
						name = tweetinfo[0];
						if (tweetinfo.length > 1)
							text = tweetinfo[1];
					}
					tweets.add(new Tweet(name, text));
				}
				reader.close();

			}
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tweets;
	}

    public static void init(){
		logger.info("init");
        String dir = "alltweets/";
        directory = new File(dir);
        if (!directory.exists())
            directory.mkdir();
		files = new ArrayList<File>();
        files.addAll(Arrays.asList(directory.listFiles()));

		tweets = new ArrayList<Tweet>();
    }

    static {
        init();
    }

}
