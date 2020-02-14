package com.hemebiotech.analytics;

import java.io.*;

public class AnalyticsCounter {

    private static int headCount = 0;	// initialize to 0
    private static int rashCount = 0;		// initialize to 0
    private static int pupilCount = 0;		// initialize to 0

    public static String line = "";
    public static File filename;


    public static void main(String[] args) throws Exception

    {
    analyseFile();
    AnalyticsCounter analyticsCounter = new AnalyticsCounter();
    analyticsCounter.
    writeFile();

    }

    @Override
    public static void analyseFile(File filename) throws IOException {
        // first get input
        BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
        String line = reader.readLine();

        int i = 0;	// set i to 0

        while (line != null) {
            i++;	// increment i
            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                headCount++;
                System.out.println("number of headaches: " + headCount);
            }
            else if (line.equals("rash")) {
                rashCount++;
            }
            else if (line.contains("pupils")) {
                pupilCount++;
            }

            line = reader.readLine();	// get another symptom
        }

    }

    public static void writeFile() throws IOException {
        // next generate output
        FileWriter writer = new FileWriter ("result.out");
        writer.write("headache: " + headCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();

    }

    public static void log()
    {
        System.out.println("symptom from file: " + line);
    }

}
