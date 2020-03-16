package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Implements.MesExceptions;

import java.io.IOException;
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


    public static void main(String[] args) throws MesExceptions, IOException {

        String verifExt = "Ok pour traitement";

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();

        detectExt = analyticsCounter.extAnalyse(args[0]).detect();
            System.out.println(detectExt);
            if (!(detectExt).contains(verifExt)){System.exit(1);}

        resultReadSymptoms = analyticsCounter.read(args[0]);
        resultTriSymptoms = analyticsCounter.analyse(resultReadSymptoms);
        analyticsCounter.write(resultTriSymptoms, args[1]);
    }
}

