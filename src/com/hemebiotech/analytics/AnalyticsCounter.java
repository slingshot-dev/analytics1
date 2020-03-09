package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Implements.*;
import com.hemebiotech.analytics.Interfaces.*;
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
    public static List<String> listSymptoms;
    public static Hashtable<String, Long> mapSymptoms;

    /**
     * Lecture du fichier pour extraire l'ensemble des symptoms avec gestion d'une exception en cas de fichier inexistant
     */
    public List<String> reader(String arg) throws MesExceptions {
        ISymptomsReader iSymptomsReader = new SymptomsDataFromFileReader();
        listSymptoms = iSymptomsReader.getSymptoms(arg);
        return listSymptoms;
    }

    /**
     * Analyse des symptoms + tri + comptage des symptoms
     */
    public Hashtable<String, Long> analyser(List<String> resultReadSymptoms) {
        IDataSymptomsAnalyser iDataSymptomsAnalyser = new DataSymptomsAnalyser();
        mapSymptoms = iDataSymptomsAnalyser.analyseSymptoms(resultReadSymptoms);
        return mapSymptoms;
    }

    /**
     * Creation du fichier result.out avec l'analyse precedente.
     */
    public void writer(Hashtable<String, Long> h, String arg) {
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

    public IextExtractor extAnalyser(String arg){
        String ext = arg.substring(arg.lastIndexOf(".")); //récupère l'extention

        ExtExtractor extExtractor = new ExtExtractor();
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



