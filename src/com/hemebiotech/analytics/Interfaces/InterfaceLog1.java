package com.hemebiotech.analytics.Interfaces;

import java.io.*;
import java.util.Hashtable;
import java.util.List;

/**
 * Loggable interface. Allows you to catch logs of several types depending on the method called.
 * Disengageable via the Boolean Variable: LogLevel
 */


public interface InterfaceLog1 {

    boolean logTrue = true;
    int logLevel = 1;

    static void log(List log) throws IOException {
        if (logTrue && logLevel == 1)
            System.out.println("Lecture des symptoms réalisée.");
        else if (logTrue && logLevel == 2) {
            System.out.println(log);
        }
    }

    static void logHashTable(Hashtable log) throws FileNotFoundException {
        if (logTrue && logLevel == 1)
            System.out.println("Analyse des Symptoms réalisée");
        else if (logTrue && logLevel == 2) {
            System.out.println(log);
        }
    }

    static void logTexte(String log) {
        if (logTrue && logLevel == 1)
            System.out.println(log);
        else if (logTrue && logLevel == 2) {
            System.out.println("");
        }
    }

    static void logMap(String log1, long log2) {
        {
            if (logTrue && logLevel == 1)
                System.out.println("Fichier result.out créé dans le repertoire projet");
            else if (logTrue && logLevel == 2) {
                System.out.println("[" + log1 + "] --> " + log2);
            }

        }

    }
}