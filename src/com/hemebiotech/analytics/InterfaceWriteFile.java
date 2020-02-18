package com.hemebiotech.analytics;

import java.util.Hashtable;

/** Interface to write the output file
 * Expects a Hastable of 2 types String and Long
 * Returns nothing but creates the file locally
 */

public interface InterfaceWriteFile
{
  void writeFile(Hashtable<String, Long> result3);
}