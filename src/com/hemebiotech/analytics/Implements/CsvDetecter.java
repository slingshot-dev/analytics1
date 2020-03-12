package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.IextExtractor;

public class CsvDetecter implements IextExtractor {

    @Override
    public String detect() {
        return "Fichier CSV en cours de developpement mais non traité a l'heure actuelle";
    }
}
