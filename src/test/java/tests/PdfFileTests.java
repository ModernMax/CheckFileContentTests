package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPDF;

public class PdfFileTests {

    @Test
    void pdfFileTest() throws IOException {
        String pdfFilePath = "./src/test/resources/files/pdfFile.pdf";
        String expectedData = "Вот что дает философия: веселость,";

        PDF pdfFile = getPDF(pdfFilePath);
        assertThat(pdfFile, PDF.containsText(expectedData));
    }

}
