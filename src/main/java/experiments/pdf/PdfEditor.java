package experiments.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

class PdfEditor {

    static String read(String path) throws IOException {
        PdfReader reader = new PdfReader(path);
        String pdfContent = PdfTextExtractor.getTextFromPage(reader, 1);

        return pdfContent;
    }
}
