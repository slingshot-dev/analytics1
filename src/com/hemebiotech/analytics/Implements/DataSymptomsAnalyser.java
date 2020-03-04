package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.IDataSymptomsAnalyser;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Recovery of all informations from ReadSymptoms
 * Create a Map Table to use Method Stream and GroupBy, in order to count the elements
 * Using a ''for'' loop to insert all the rows of the Map (K, V) in a HashTable
 * Return from Table h to the Main Method
 *
 * @return Map Table returned to Class Main with all Symptoms sorted.
 */

public class DataSymptomsAnalyser implements IDataSymptomsAnalyser {

    @Override
    public Hashtable<String, Long> analyseSymptoms(List<String> resultReadSymptoms) {

        // instanciation du Tableau h pour insertion des valeur K, V de la Map
        Hashtable<String, Long> h = new Hashtable<String, Long>();

        // instanciation d'une Map pour grouper et comptabiliser les symptoms
        Map<String, Long> counts = resultReadSymptoms.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())); // utilisation de Lambda

        // insertion des données dans le HashTable h
        for (String key : counts.keySet()) {
            Long nombre = counts.get(key);
            /*System.out.println("[" + key + "] --> " + nombre);*/

            h.put(key, nombre);
        }
        System.out.println("Fichier analysé avec succès, " + resultReadSymptoms.size() + " symptoms identifiés et analysés");
        return h;
    }
}