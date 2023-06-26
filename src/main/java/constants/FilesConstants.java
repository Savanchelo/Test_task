package constants;

public enum FilesConstants {
    USER_DIRECTORY("user.dir"), TEST_DATA_FILE_NAME("test_data.json"), RESOURCES_PACKAGE_PATH("/src/main/resources/");
    private final String constants;

    FilesConstants(String constants) {
        this.constants = constants;
    }

    public String getConstantValue() {
        return constants;
    }
}
