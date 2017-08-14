package cn.zk.springmvc.viewresolver;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import cn.zk.springmvc.model.User;

public class PdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		//ʹ�õ����Դ����� ����
		BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/simsun.ttc,1",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
		Font font=new Font(baseFont,12);
          
		//Pdf �ı��
		PdfPTable table = new PdfPTable(3);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.getDefaultCell().setBackgroundColor(Color.lightGray);
		
		table.addCell(new Paragraph("�û���",font));
		table.addCell(new Paragraph("�绰",font));
		table.addCell(new Paragraph("��ַ",font));
		
		//��Model����ȡ��users
		List<User> users=(List<User>) model.get("users");
		for(int i=0;i<users.size();i++){
			table.addCell(new Paragraph(users.get(i).getName(),font));
			table.addCell(users.get(i).getTel());
			table.addCell(new Paragraph(users.get(i).getAddress(),font));
		}
		document.add(table);
	}

}
