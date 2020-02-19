package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Implements.AnalyseDataSymptoms;
import com.hemebiotech.analytics.Implements.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.Implements.WriteDataToFile;
import com.hemebiotech.analytics.Interfaces.ISymptomReader;
import com.hemebiotech.analytics.Interfaces.InterfaceAnalyseDataSymptoms;
import com.hemebiotech.analytics.Interfaces.InterfaceLog1;
import com.hemebiotech.analytics.Interfaces.InterfaceWriteFile;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

/**
 * The Main Class to Analyse Clients Symptoms from a file called symptoms.txt
 * This Class calls the 3 Methods from associated Interfaces
 *
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


    public static void main(String[] args) throws IOException {
        // Lecture du fichier pour extraire l'ensemble des symptoms
        ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(filepath);
        resultReadSymptoms = iSymptomReader.GetSymptoms();
        InterfaceLog1.log(resultReadSymptoms);

        // Analyse des symptoms + tri + comptage des symptoms
        InterfaceAnalyseDataSymptoms interfaceAnalyseDataSymptoms = new AnalyseDataSymptoms();
        resultAnalyse = interfaceAnalyseDataSymptoms.AnalyseSymptoms(resultReadSymptoms);
        InterfaceLog1.logHashTable(resultAnalyse);

        // Creation du fichier result.out avec l'analyse precedente.
        InterfaceWriteFile interfaceWriteFile = new WriteDataToFile();
        interfaceWriteFile.writeFile(resultAnalyse);
        InterfaceLog1.logTexte("Fichier result.out créé dans le repertoire Projet");

        // Creation du fichier result.out avec l'analyse precedente.
        /*WriteDataToFile writeDataToFile = new WriteDataToFile(); // Instanciation via la Class. Quelle Methode est la meilleur ?
        writeDataToFile.writeFile(resultAnalyse);*/

    }
}

