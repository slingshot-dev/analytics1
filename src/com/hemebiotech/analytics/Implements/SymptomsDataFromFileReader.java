package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.ISymptomsReader;

import java.io.BufferedReader;
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
    public List<String> getSymptoms(String filepath) {
        ArrayList<String> result = new ArrayList<String>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();

                if (line == null) {
                    try {
                        throw new MesExceptions("Fichier " + filepath + " vide");
                    } catch (MesExceptions e) {
                        System.exit(1);
                    }

                }

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                System.err.println("Fichier " + filepath + " introuvable");
                System.exit(1);
            }
        }
        System.out.println("Fichier Symptoms.txt lu avec succès");
        return result;
    }

}