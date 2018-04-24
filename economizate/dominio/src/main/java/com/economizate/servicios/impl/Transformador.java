package com.economizate.servicios.impl;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

public class Transformador {

	public void process() throws IOException, DocumentException {
        try {

            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource xls = new StreamSource(Thread.currentThread().getContextClassLoader().getResourceAsStream("Movimientos.xsl"));//new File("Alumnos.xsl"));
            Transformer newTransformer = factory.newTransformer(xls);
            ;
            StreamSource xml = new StreamSource(Thread.currentThread().getContextClassLoader().getResourceAsStream("Movimientos.xml"));//new File("Alumnos.xml"));
            String salida = "";
            StringWriter writer = new StringWriter();
            //StreamResult result = new StreamResult(writer);
            newTransformer.transform(xml, new StreamResult( writer));

           
            FileUtils.writeByteArrayToFile(new File("So4712641.pdf"), toPdf(writer.toString()));

        } catch (TransformerException ex) {
            //Logger.getLogger(AlumnosCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	private byte[] toPdf(String html) throws DocumentException, IOException {
	    final ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocumentFromString(html);
	    renderer.layout();
	    try (ByteArrayOutputStream fos = new ByteArrayOutputStream(html.length())) {
	      renderer.createPDF(fos);
	      return fos.toByteArray();
	    }
	  }
}
