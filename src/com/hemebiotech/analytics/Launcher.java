package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Implements.MesExceptions;

import java.io.IOException;


/**
 * The Main Class to launch program AnalyticsCounter
 *
 * @author C. Guillet
 * @version 0.9
 */


public class Launcher {
    public static String fileout;


    public static void main(String[] args) throws MesExceptions {

        fileout = args[1];

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        analyticsCounter.reader(args[0]);
        analyticsCounter.analyser();
        analyticsCounter.writer();
    }
}

