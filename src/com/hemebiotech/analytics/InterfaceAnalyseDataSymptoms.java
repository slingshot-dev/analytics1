package com.hemebiotech.analytics;

import java.util.Hashtable;
import java.util.List;

/**Interface for the AnalysisSymptoms Method. Setting up the service contract: Waits for a List of type String
 * ..and returns a HashTable of 2 types, String and Long.
 */

public interface InterfaceAnalyseDataSymptoms {

    Hashtable<String, Long> AnalyseSymptoms(List<String> resultReadSymptoms);

}
