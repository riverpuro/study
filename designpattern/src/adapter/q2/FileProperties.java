package adapter.q2;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class FileProperties implements FileIO {
    public static final String HEADER = "written by FileProperties";

    private Properties properties;

    public FileProperties() {
        properties = new Properties();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        try {
            properties.load(new FileInputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        try {
            if (properties != null) {
                properties.store(new FileOutputStream(filename), HEADER);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setValue(String key, String value) {
        properties.put(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
