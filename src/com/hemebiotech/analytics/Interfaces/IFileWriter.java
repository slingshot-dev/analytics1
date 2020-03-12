package com.hemebiotech.analytics.Interfaces;

import java.util.Map;

/**
 * Interface to write the output file
 * Expects a Hastable of 2 types String and Long
 * Returns nothing but creates the file locally
 */

public interface IFileWriter {
    boolean writeFile(Map<String, Long> result3, String arg);
}