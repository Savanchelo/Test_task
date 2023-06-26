package utils;

import com.google.gson.Gson;
import constants.FilesConstants;
import data.TestData;

import java.io.FileReader;
import java.io.Reader;

public class PropertiesParser {
    private PropertiesParser() {
    }

    private static final String TEST_DATA_PATH = FilesConstants.RESOURCES_PACKAGE_PATH.getConstantValue()
            + FilesConstants.TEST_DATA_FILE_NAME.getConstantValue();

    public static TestData getTestData() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(System.getProperty(FilesConstants.USER_DIRECTORY.getConstantValue())
                + TEST_DATA_PATH)) {
            return gson.fromJson(reader, TestData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
