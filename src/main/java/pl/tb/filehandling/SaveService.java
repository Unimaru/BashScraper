package pl.tb.filehandling;

import pl.tb.configuration.ConfigProvider;
import pl.tb.extraction.WebData;

import java.util.List;

public class SaveService {

    private final ConfigProvider configProvider;

    public SaveService(ConfigProvider configProvider) {
        this.configProvider = configProvider;
    }

    public void saveToFile(List<WebData> webData) {
        DataWriter dataWriter = new JSONDataWriter(configProvider);
        dataWriter.save(webData);
    }

}
