package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();
    static{
        try {
            loadProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadProperties() throws IOException {
        InputStream inputStream = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream("application.properties");

        if (inputStream == null) {
            throw new IOException("Файл application.properties не найден в classpath!");
        }

        PROPERTIES.load(inputStream);
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private PropertiesUtil(){}
}
