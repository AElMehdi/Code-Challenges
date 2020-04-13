package experiments.pdf;


import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PdfEditorTest {

    @Test
    public void should_read_pdf_template() throws IOException {
        String pdfTemplate = PdfEditor.read("template_file.pdf");

        assertThat(pdfTemplate).contains("Instructions d'utilisation");
    }
}