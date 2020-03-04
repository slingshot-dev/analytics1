package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Implements.ExtExtractor;
import com.hemebiotech.analytics.Implements.MesExceptions;

import java.util.Hashtable;
import java.util.List;


/**
 * The Main Class to launch program AnalyticsCounter
 *
 * @author C. Guillet
 * @version 0.9
 */


public class Launcher {

    public static List<String> resultReadSymptoms;
    public static Hashtable<String, Long> resultTriSymptoms;


    public static void main(String[] args) throws MesExceptions {

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();

        analyticsCounter.extAnalyser(args[0]);
        resultReadSymptoms = analyticsCounter.reader(args[0]);
        resultTriSymptoms = analyticsCounter.analyser(resultReadSymptoms);
        analyticsCounter.writer(resultTriSymptoms, args[1]);
    }
}

