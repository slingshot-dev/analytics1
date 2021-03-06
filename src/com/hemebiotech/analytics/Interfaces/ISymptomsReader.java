package com.hemebiotech.analytics.Interfaces;

import com.hemebiotech.analytics.Implements.MesExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * <p>
 * The implementation does not need to order the list
 */
public interface ISymptomsReader {
    /**
     * If no data is available, return an empty List
     */
    List<String> getSymptoms(String filepath) throws MesExceptions, IOException;
}

