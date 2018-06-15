package pl.tb;

import pl.tb.extraction.ExtractService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ExtractService extractService = new ExtractService();
        extractService.extractData();
    }
}
