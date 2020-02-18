package com.hemebiotech.analytics;

import java.util.Hashtable;
import java.util.List;

/** Loggable interface. Allows you to catch logs of several types depending on the method called.
 * Disengageable via the Boolean Variable: LogLevel
 *
 */


public interface InterfaceLog1 {

    public boolean logLevel = false;

static void log(List log)
{
    if (logLevel)
    {
        System.out.println(log);
    }
    else
        {
        System.out.println("");
        }
}

static void logHashTable(Hashtable log)
{
    {
        if (logLevel)
        {
            System.out.println(log);
        }
        else
        {
            System.out.println("");
        }
    }


}

    static void logTexte(String log)
    {
        {
            if (logLevel)
            {
                System.out.println(log);
            }
            else
            {
                System.out.println("");
            }
        }


    }

    static void logMap(String log1, long log2)
    {
        {
            if (logLevel)
            {
                System.out.println("[" + log1 + "] --> " + log2);
            }
            else
            {
                System.out.println("");
            }
        }


    }

}
