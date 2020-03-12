package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.IDataSymptomsAnalyser;
import java.util.*;
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
    public Map<String, Long> analyseSymptoms(List<String> resultReadSymptoms) {

        // instanciation d'une Map pour grouper et comptabiliser les symptoms
        Map<String, Long> counts = resultReadSymptoms.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())); // utilisation de Lambda


        Map<String, Long> map = new TreeMap<String, Long>(counts);
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            //System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Fichier analysé avec succès, " + resultReadSymptoms.size() + " symptoms identifiés et analysés");
        return map;
    }
}