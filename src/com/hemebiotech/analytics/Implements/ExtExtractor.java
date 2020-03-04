package com.hemebiotech.analytics.Implements;

import com.hemebiotech.analytics.Interfaces.IextExtractor;

public class ExtExtractor implements IextExtractor {

    @Override
    public void txtFile(){
        System.out.println("Fichier TXT identifé, traitement en cours");
    }

    @Override
    public void csvFile(){
        System.out.println("Traitement des Fichier CSV en cours de developpement mais ne peuvent pas encore etre traités");
    }

}
