package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FilesPaths {
    USER_DIRECTORY("user.dir"), TEST_DATA_FILE_NAME("test_data.json"), RESOURCES_PACKAGE_PATH("/src/main/resources/");
    private final String constants;
}