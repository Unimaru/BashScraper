package pl.tb.filehandling;

import pl.tb.extraction.WebData;

import java.util.List;

public interface DataWriter {

    void save(List<WebData> webData);
}
