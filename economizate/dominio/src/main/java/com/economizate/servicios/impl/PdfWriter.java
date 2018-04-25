package com.economizate.servicios.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.BaseTransformador;
import com.economizate.servicios.BaseWriter;
import com.lowagie.text.DocumentException;

public class PdfWriter extends BaseWriter {

	private String html;

	public PdfWriter(String nombreArchivo, TransformadorMovimientos tranformador) {
		super(nombreArchivo);
		this.html = html;
	}

	@Override
	public void write() throws IOException, FileNotFoundException {
		//FileUtils.writeByteArrayToFile(new File("So4712641.pdf"), toPdf(writer.toString()));

	}

	private byte[] toPdf(String html) throws DocumentException, IOException {
		final ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		try (ByteArrayOutputStream fos = new ByteArrayOutputStream(
				html.length())) {
			renderer.createPDF(fos);
			return fos.toByteArray();
		}
	}
}
