package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Implements.MesExceptions;
import java.util.List;
import java.util.Map;


/**
 * The Main Class to launch program AnalyticsCounter
 *
 * @author C. Guillet
 * @version 0.9
 */


public class Launcher {

    public static List<String> resultReadSymptoms;
    public static Map<String, Long> resultTriSymptoms;
    public static String detectExt;


    public static void main(String[] args) throws MesExceptions {

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();

        detectExt = analyticsCounter.extAnalyser(args[0]).detect();
            System.out.println(detectExt);
            if (!"Extension .txt detectée. Ok pour traitement.".equals(detectExt)){System.exit(1);}

        resultReadSymptoms = analyticsCounter.reader(args[0]);
        resultTriSymptoms = analyticsCounter.analyser(resultReadSymptoms);
        analyticsCounter.writer(resultTriSymptoms, args[1]);
    }
}
