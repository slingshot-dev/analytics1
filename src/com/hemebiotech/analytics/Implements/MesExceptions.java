package com.hemebiotech.analytics.Implements;

public class MesExceptions extends Exception {

    public MesExceptions(String e) {
        System.err.println(e);
        System.exit(0);
    }

}
