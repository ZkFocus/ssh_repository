package com.hp.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class ViewPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//model
		//request.
		//List words = (List) model.get("wordList");
        //for (int i=0; i<words.size(); i++) {
		List list=(List) model.get("list");
		for (int i=0; i<1000; i++) {
			if (i%40==0 && i!=0) {
				document.add(new Paragraph("----------------------------底部---第"+(i/40)+"页---------------------------"));
			}
			document.add(new Paragraph(i+1+""));
		}
		
        //}
	}

}
