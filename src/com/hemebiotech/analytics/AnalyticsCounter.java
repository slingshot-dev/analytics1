package com.hemebiotech.analytics;

import java.util.Hashtable;
import java.util.List;

/** The Main Class to Analyse Clients Symptoms from a file called symptoms.txt
 * This Class calls the 3 Methods from associated Interfaces
 * @author C. Guillet
 * @version 0.9
 */


public class AnalyticsCounter implements InterfaceLog1

/**@param filepath Path of the File symptoms.txt
 * @param resultReadSymptoms Stock result of the Method ReadSymptoms
 * @param resultAnalyse Stock result of the Method AnalyseDataSymptoms
  */


{
    public static String filepath = "symptoms.txt"; //declaration de la variable avec le chemin du fichier en dur :(
    public static List<String> resultReadSymptoms;
    public static Hashtable<String, Long> resultAnalyse;


    public static void main(String[] args)
    {
        // Lecture du fichier pour extraire l'ensemble des symptoms
        ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filepath);
        resultReadSymptoms = readSymptomDataFromFile.GetSymptoms();
            InterfaceLog1.log(resultReadSymptoms);

        // Analyse des symptoms + tri + comptage des symptoms
        AnalyseDataSymptoms analyseDataSymptoms = new AnalyseDataSymptoms();
        resultAnalyse = analyseDataSymptoms.AnalyseSymptoms(resultReadSymptoms);
            InterfaceLog1.logHashTable(resultAnalyse);

        // Creation du fichier result.out avec l'analyse precedente.
        WriteDataToFile writeDataToFile = new WriteDataToFile();
        writeDataToFile.writeFile(resultAnalyse);
    }
}

