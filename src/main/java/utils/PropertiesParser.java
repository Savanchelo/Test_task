package utils;

import com.google.gson.Gson;
import data.TestData;
import enums.FilesPaths;

import java.io.FileReader;
import java.io.Reader;

public class PropertiesParser {
    private static final String TEST_DATA_PATH = FilesPaths.RESOURCES_PACKAGE_PATH.getConstants()
            + FilesPaths.TEST_DATA_FILE_NAME.getConstants();

    private PropertiesParser() {
    }

    public static TestData getTestData() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(System.getProperty(FilesPaths.USER_DIRECTORY.getConstants())
                + TEST_DATA_PATH)) {
            return gson.fromJson(reader, TestData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}