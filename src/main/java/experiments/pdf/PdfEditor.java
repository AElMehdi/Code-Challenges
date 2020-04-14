package experiments.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.FileOutputStream;
import java.io.IOException;

class PdfEditor {

    static String read(String path) throws IOException {
        PdfReader reader = new PdfReader(path);
        String pdfContent = PdfTextExtractor.getTextFromPage(reader, 1);


        reader.close();
        return pdfContent;
    }

    static void editPdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);

        PdfDictionary dict = reader.getPageN(1);
        PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
        if (object instanceof PRStream) {
            PRStream stream = (PRStream)object;
            byte[] data = PdfReader.getStreamBytes(stream);
            stream.setData(new String(data).replace("Hello World", "HELLOW HELLOW").getBytes());
        }
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
    }
}
