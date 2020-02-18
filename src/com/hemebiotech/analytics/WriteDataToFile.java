package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Hashtable;

/** Instantiating a fileWriter to create the result.out file
 * Recovery of the Table (HashTable) h and insertion of a Key pair, Value per line
 * closing of the result.out file
 */


public class WriteDataToFile implements InterfaceWriteFile {

    @Override
    public void writeFile(Hashtable<String, Long> resultAnalyse) {

        String line = "";
        String filename = "result.out";

        try {
                FileWriter writer = new FileWriter(filename);

                for (String key : resultAnalyse.keySet())
                {
                    Long nombre = resultAnalyse.get(key);
                        InterfaceLog1.logMap(key, nombre);
                    line = ("[" + key + "] --> " + nombre);
                    writer.write(line + "\n");
                }

                writer.close();
                InterfaceLog1.logTexte("Fichier créé");
            }
        catch(java.io.IOException e)
            {
                e.printStackTrace();
            }
    }
}
