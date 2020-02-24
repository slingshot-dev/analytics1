package com.hemebiotech.analytics.Interfaces;

import com.hemebiotech.analytics.Implements.Exception5;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * <p>
 * The implementation does not need to order the list
 */
public interface ISymptomReader {
    /**
     * If no data is available, return an empty List
     */
    List<String> GetSymptoms() throws Exception5;
}

