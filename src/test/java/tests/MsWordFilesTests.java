package tests;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readDocFromPath;
import static utils.Files.readDocxFromPath;

public class MsWordFilesTests {
    @Test
    void docFileTest() throws IOException {
        String docFilePath = "./src/test/resources/files/msword-doc.doc";
        String expectedData = "True happiness is to enjoy the present";
        String actualData = readDocFromPath(docFilePath).getText();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void docxFileTest() throws IOException {
        String docxFilePath = "./src/test/resources/files/msword-docx.docx";
        String expectedData = "True happiness is to enjoy the present";
        String actualData = readDocxFromPath(docxFilePath).getText();
        assertThat(actualData, containsString(expectedData));
    }
}
