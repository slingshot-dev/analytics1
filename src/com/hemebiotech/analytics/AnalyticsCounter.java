package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Implements.*;
import com.hemebiotech.analytics.Interfaces.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    public static List<String> listSymptoms;
    public static Map<String, Long> mapSymptoms;

    /**
     * Lecture du fichier pour extraire l'ensemble des symptoms avec gestion d'une exception en cas de fichier inexistant
     */
    public List<String> read(String arg) throws MesExceptions, IOException {
        ISymptomsReader iSymptomsReader = new SymptomsDataFromFileReader();
        listSymptoms = iSymptomsReader.getSymptoms(arg);
        return listSymptoms;
    }

    /**
     * Analyse des symptoms + tri + comptage des symptoms
     */
    public Map<String, Long> analyse(List<String> resultReadSymptoms) {
        IDataSymptomsAnalyser iDataSymptomsAnalyser = new DataSymptomsAnalyser();
        mapSymptoms = iDataSymptomsAnalyser.analyseSymptoms(resultReadSymptoms);
        return mapSymptoms;
    }

    /**
     * Creation du fichier result.out avec l'analyse precedente.
     */
    public void write(Map<String, Long> h, String arg) {
        IFileWriter iFileWriter = new DataToFileWriter();
        boolean result = iFileWriter.writeFile(h, arg);

        if (!result) {
            System.out.println("Probleme de création du Fichier de resultats");
        }

    }

    /**
     * Analyse de l'extension du fichier pour identifier si le fichier est traitable
     * @param arg Arguments passé au lancement du programme
     */

    public IextExtractor extAnalyse(String arg){
        String ext = arg.substring(arg.lastIndexOf(".")); //récupère l'extention


        switch (ext){
            case ".txt":
                return new TxtDetector();

            case ".csv":
                return new CsvDetecter();

            default:
                return new OtherDetector();
        }
    }

}



