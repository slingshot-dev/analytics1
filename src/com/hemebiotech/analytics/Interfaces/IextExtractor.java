package com.hemebiotech.analytics.Interfaces;

public interface IextExtractor {

default void txtFile(){
    System.out.println("Defaut .txt");
}

default void csvFile(){
    System.out.println("Defaut .CSV");
}

default void otherFile(){
    System.out.println("Fichier non reconnu, seuls les fichier .txt sont acceptés");
}

}
