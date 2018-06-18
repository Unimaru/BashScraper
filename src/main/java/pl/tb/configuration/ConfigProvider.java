package pl.tb.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigProvider {

    Config config = ConfigFactory.parseResources("defaults.conf");

    public String getPathFromConfig() {
        return config.getString("conf.outputFilePath");
    }
}
