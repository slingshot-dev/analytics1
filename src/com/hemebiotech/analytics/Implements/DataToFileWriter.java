package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.IFileWriter;
import java.io.FileWriter;
import java.util.Map;


/**
 * Instantiating a fileWriter to create the result.out file
 * Recovery of the Table (HashTable) h and insertion of a Key pair, Value per line
 * closing of the result.out file
 */


public class DataToFileWriter implements IFileWriter {


    @Override
    public boolean writeFile(Map<String, Long> resultAnalyse, String arg) {

        String line = "";

        try {
            FileWriter writer = new FileWriter(arg);

            for (String key : resultAnalyse.keySet()) {
                Long nombre = resultAnalyse.get(key);
                line = ("[" + key + "] --> " + nombre);
                writer.write(line + "\n");
            }

            writer.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Fichier "+arg+" créé avec succès");
        return true;
    }
}
