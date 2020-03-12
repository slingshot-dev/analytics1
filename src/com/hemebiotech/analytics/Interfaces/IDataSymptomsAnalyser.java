package com.hemebiotech.analytics.Interfaces;

import java.util.List;
import java.util.Map;

/**
 * Interface for the AnalysisSymptoms Method. Setting up the service contract: Waits for a List of type String
 * ..and returns a HashTable of 2 types, String and Long.
 */

public interface IDataSymptomsAnalyser {

    Map<String, Long> analyseSymptoms(List<String> resultReadSymptoms);

}
