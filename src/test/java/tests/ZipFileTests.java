package tests;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.ZipArchive.unzip;

public class ZipFileTests {

    @Test
    void zipFileTest() throws ZipException, IOException {
        String zipFilePath = "./src/test/resources/files/Notepad.zip";
        String unzipFolderPath = "./src/test/resources/files/unzipFolder";
        String unzipTxtFilePath = "./src/test/resources/files/unzipFolder/Notepad.txt";
        String expectedData = "Одинаковое безумие – бояться того, что не принесет страданий";

        unzip(zipFilePath, unzipFolderPath);

        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));

    }

    @Test
    void zipFileWithPasswordTest() throws ZipException, IOException {
        String zipFilePath = "./src/test/resources/files/NotepadWithPassword.zip";
        String unzipFolderPath = "./src/test/resources/files/unzipFolder";
        String password = "qwerty";
        String unzipTxtFilePath = "./src/test/resources/files/unzipFolder/NotepadWithPassword.txt";
        String expectedData = "Одинаковое безумие – бояться того, что не принесет страданий";

        unzip(zipFilePath, unzipFolderPath, password);

        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
