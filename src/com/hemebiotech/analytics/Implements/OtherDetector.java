package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.IextExtractor;

public class OtherDetector implements IextExtractor {

        @Override
        public String detect() {
            return "Format de Fichier non pris en charge. Seuls les fichiers .txt sont pris en charge";
        }
    }

