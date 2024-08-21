package Gherkin_Cucumber;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            String filePath = "src/test/java/Gherkin_Cucumber/configuration.properties";
            FileInputStream inputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

