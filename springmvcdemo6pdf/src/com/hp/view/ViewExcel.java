package com.hp.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ViewExcel extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
			HSSFSheet sheet;
	        HSSFRow sheetRow;
	        HSSFCell cell;
	        sheet=workbook.createSheet("test1");
	        
	        //header 部分
	        sheetRow=sheet.createRow(0);
	        cell =sheetRow.createCell(0);
	        cell.setCellValue("序号");
	        HSSFCell cell1=sheetRow.createCell(1);
	        cell1.setCellValue(new HSSFRichTextString("用户名"));
	        HSSFCell cell2=sheetRow.createCell(2);
	        cell2.setCellValue(new HSSFRichTextString("密码"));
	        
	        for (int i = 0; i < 50; i++) {
	        	//创建行
	        	 sheetRow=sheet.createRow(i+1);
	        	 //单元格
	        	 HSSFCell  cel4 =sheetRow.createCell(0);
	        	 cel4.setCellValue(new HSSFRichTextString(i+1+""));
	        	 HSSFCell  cel2 =sheetRow.createCell(1);
	        	 cel2.setCellValue(new HSSFRichTextString("用户"+(i+1)));
	        	 HSSFCell  cel3 =sheetRow.createCell(2);
	        	 cel3.setCellValue(new HSSFRichTextString("密码"+(i+1)));
			}
	}

}
