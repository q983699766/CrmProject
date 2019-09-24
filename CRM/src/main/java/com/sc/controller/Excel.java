package com.sc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.bean.SysDuty;
import com.sc.service.SysDutyService;

@Controller
@RequestMapping("sysdutyctlr")
public class Excel {
	@Autowired
	SysDutyService sysDutyService;
	
	@RequestMapping("/excle.do")
	public void UserExcelDownloads(HttpServletResponse response, SysDuty u) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();  
		HSSFSheet sheet = workbook.createSheet("职位信息表");
		sheet.setColumnWidth(5, 256*20);//设置列的宽度
		List<SysDuty> selectDuty = sysDutyService.selectDuty();
		String str = "yyy-MM-dd HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		String fileName = "sysduty"+".xls";
		int rowNum = 1;
		String[] headers = { "职位编号", "职位名称", "所属部门", "备注说明", "所属公司", "修改时间" };
		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(30);//设置行的高度y
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell((short) i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		for (SysDuty student : selectDuty) {
			HSSFRow row1 = sheet.createRow(rowNum);
			row1.createCell((short) 0).setCellValue(student.getDutId());
			row1.createCell((short) 1).setCellValue(new HSSFRichTextString(student.getDutName()));
			row1.createCell((short) 2).setCellValue(student.getSecId());
			row1.createCell((short) 3).setCellValue(new HSSFRichTextString(student.getDutRemark()));
			row1.createCell((short) 4).setCellValue(student.getComId());
			row1.createCell((short) 5).setCellValue(sdf.format(student.getLastTime()));
			rowNum++;
		}
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}
}
