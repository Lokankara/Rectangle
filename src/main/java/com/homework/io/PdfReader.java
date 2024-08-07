package com.homework.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

/**
 * @author PPoliak
 */
public class PdfReader {

    public static void main(String[] args) throws IOException, SAXException, TikaException {
        File fl = new File("c:\\Java\\OCP.pdf");
        BodyContentHandler ch = new BodyContentHandler();
        FileInputStream fs = new FileInputStream(fl);
        Metadata md = new Metadata();
        ParseContext pc = new ParseContext();
        PDFParser pp = new PDFParser();
        pp.parse(fs, ch, md, pc);
        System.out.println("Extracting the contents from the file: \n" + ch);
    }
}
