package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;

public class TxtFileTests {
    @Test
    void txtFileTest() throws IOException {
        String txtFilePath = "./src/test/resources/files/Notepad.txt";
        String expectedData = "что последний вздох излетает без боли,";
        String actualData = readTextFromPath(txtFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
