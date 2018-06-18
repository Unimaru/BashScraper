package pl.tb.filehandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.tb.configuration.ConfigProvider;
import pl.tb.extraction.WebData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaveToFile {


    ConfigProvider configProvider = new ConfigProvider();


    public void save(List<WebData> webData) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(configProvider.getPathFromConfig()), webData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
