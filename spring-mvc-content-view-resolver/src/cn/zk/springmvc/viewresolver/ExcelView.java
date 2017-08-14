package cn.zk.springmvc.viewresolver;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import cn.zk.springmvc.model.User;

public class ExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 创建sheet
		Sheet sheet = workbook.createSheet("用户信息");
		//设置单元格格式
		CellStyle style = workbook.createCellStyle();
		//设置颜色
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		
		Row row = null;
		Cell cell = null;
		int colCount = 0;
		
		//设置header部分
		row = sheet.createRow(0);
		//设置第一行A列
		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("用户名");
		//设置第一行B列
		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("电话");
		//设置第一行C列
		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("地址");
		
		//从Model域中取出users
		List<User> users=(List<User>) model.get("users");
		for(int i=1;i<=users.size();i++){
			colCount = 0;
			row =sheet.createRow(i);
			row.createCell(colCount++).setCellValue(users.get(i-1).getName());
			row.createCell(colCount++).setCellValue(users.get(i-1).getTel());
			row.createCell(colCount++).setCellValue(users.get(i-1).getAddress());
			
			
		}
	}

}
