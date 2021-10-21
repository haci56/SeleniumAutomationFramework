package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public Properties initialize_properties(){

        properties = new Properties();

        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/Config/config.properties");
            properties.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
