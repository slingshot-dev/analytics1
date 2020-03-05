package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.IextExtractor;

public class TxtDetector implements IextExtractor {
    @Override
    public String detect() {
        return "Fichier .txt detecté. Ok pour traitement.";
    }
}
