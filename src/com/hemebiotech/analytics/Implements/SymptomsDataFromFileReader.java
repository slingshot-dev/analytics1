package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.ISymptomsReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class SymptomsDataFromFileReader implements ISymptomsReader {


    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */

    @Override
    public List<String> getSymptoms(String filepath) throws IOException {
        ArrayList<String> result = new ArrayList<String>();

        if (filepath != null) {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));

            try {

                String line = reader.readLine();

                if (line == null) {
                    throw new MesExceptions("Fichier " + filepath + " vide");
                }

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException | MesExceptions e) {
                System.err.println("Fichier " + filepath + " introuvable");
                System.exit(1);
            } finally {
                reader.close();
            }
        }
        System.out.println("Fichier Symptoms.txt lu avec succès");
        return result;
    }

}