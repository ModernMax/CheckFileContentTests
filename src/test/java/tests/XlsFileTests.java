package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getXls;
import static utils.Files.readXlsxFromPath;

public class XlsFileTests {
    @Test
    void xlsFileTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/xlsFile.xls";
        String expectedData = "c.stevens@randatmail.com";

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/xlsFile.xls";
        String expectedData = "c.stevens@randatmail.com";
        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(6).getCell(4).toString();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxFileTest() {
        String xlsxFilePath = "./src/test/resources/files/xlsxFile.xlsx";
        String expectedData = "c.stevens@randatmail.com";

        String actualData = readXlsxFromPath(xlsxFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
