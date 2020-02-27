package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Implements.AnalyserDataSymptoms;
import com.hemebiotech.analytics.Implements.MesExceptions;
import com.hemebiotech.analytics.Implements.ReaderSymptomDataFromFile;
import com.hemebiotech.analytics.Implements.WriterDataToFile;
import com.hemebiotech.analytics.Interfaces.ISymptomReader;
import com.hemebiotech.analytics.Interfaces.IAnalyserDataSymptoms;
import com.hemebiotech.analytics.Interfaces.IWriterFile;

import java.util.Hashtable;
import java.util.List;

/**
 * The program to Analyse Clients Symptoms from a file called symptoms.txt
 * This Class calls the 3 Methods from associated Interfaces
 */


public class AnalyticsCounter

/**@param filepath Path of the File symptoms.txt
 * @param resultReadSymptoms Stock result of the Method ReadSymptoms
 * @param resultAnalyse Stock result of the Method AnalyseDataSymptoms
 */


{
    public static List<String> resultReadSymptoms;
    public static Hashtable<String, Long> resultAnalyse;


    public void reader(String arg) throws MesExceptions {    // Lecture du fichier pour extraire l'ensemble des symptoms avec gestion d'une exception en cas de fichier inexistant
        ISymptomReader iSymptomReader = new ReaderSymptomDataFromFile(); //
        resultReadSymptoms = iSymptomReader.getSymptoms(arg);
    }

    public void analyser() {    // Analyse des symptoms + tri + comptage des symptoms
        IAnalyserDataSymptoms IAnalyserDataSymptoms = new AnalyserDataSymptoms();
        resultAnalyse = IAnalyserDataSymptoms.analyseSymptoms(resultReadSymptoms);
    }

    public void writer() {      // Creation du fichier result.out avec l'analyse precedente.
        IWriterFile IWriterFile = new WriterDataToFile();
        boolean result = IWriterFile.writeFile(resultAnalyse);

        if (!result) {
            System.out.println("Probleme");
        }

    }
}



