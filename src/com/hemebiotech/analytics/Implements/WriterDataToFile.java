package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.IWriterFile;
import com.hemebiotech.analytics.Launcher;

import java.io.FileWriter;
import java.util.Hashtable;

import static com.hemebiotech.analytics.Launcher.fileout;

/**
 * Instantiating a fileWriter to create the result.out file
 * Recovery of the Table (HashTable) h and insertion of a Key pair, Value per line
 * closing of the result.out file
 */


public class WriterDataToFile implements IWriterFile {


    @Override
    public boolean writeFile(Hashtable<String, Long> resultAnalyse) {

        String line = "";

        try {
            FileWriter writer = new FileWriter(fileout);

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
        System.out.println("Fichier "+fileout+" créé avec succès");
        return true;
    }
}
