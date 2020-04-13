package experiments.pdf;


import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PdfEditorTest {

    @Test
    public void should_read_pdf_template() throws IOException {
        String pdfTemplate = PdfEditor.read("template_file.pdf");

        assertThat(pdfTemplate).contains("Instructions d'utilisation");
    }

    @Test
    public void should_replace_a_word_pdf_template() throws IOException, DocumentException {
        String dest = "transformed_template_file.pdf";

        PdfEditor.editPdf("template_file.pdf", dest);

        assertThat(PdfEditor.read(dest)).contains("User Manual");
    }
}