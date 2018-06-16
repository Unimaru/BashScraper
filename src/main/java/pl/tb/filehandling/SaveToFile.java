package pl.tb.filehandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.tb.extraction.WebData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaveToFile {

    public void save(List<WebData> webData){

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("file.txt"), webData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
