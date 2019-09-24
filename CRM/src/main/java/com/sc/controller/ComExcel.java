package com.sc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysDuty;
import com.sc.service.SysComPanyService;
@Controller
@RequestMapping("sycompanyctlr")
public class ComExcel {
	
	@Autowired
	 SysComPanyService sysComPanyService;
	
	@RequestMapping("/comexcle.do")
	    public void UserExcelDownloads(HttpServletResponse response,SysDuty u)throws IOException {
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("公司信息表");
	       List<SysCOMPANY> selectComoany = sysComPanyService.selectComoany();
	        String str = "yyy-MM-dd HH:mm";
	        SimpleDateFormat sdf = new SimpleDateFormat(str);
	        String fileName = "sysComPany" + ".xls";
	        int rowNum = 1;
	        String [] headers = {"公司编号","公司名称","公司代码","公司邮箱","联系人","公司地址","固定电话","移动电话","传真","开户银行","银行账户","是否有效","备注信息","修改时间"};
	        HSSFRow row = sheet.createRow(0);
	      //创建Cell样式并设置样式
	        HSSFCellStyle hstyle = workbook.createCellStyle();
	        //水平居中
	        hstyle.setAlignment(HorizontalAlignment.CENTER);
	        //垂直居中
	        hstyle.setVerticalAlignment(VerticalAlignment.CENTER);
	        //这是样式
	        hstyle.setBorderTop(BorderStyle.THIN);
	        for (int i = 0;i<headers.length;i++){
	            HSSFCell cell = row.createCell((short) i);
	            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
	            cell.setCellValue(text);
	        }
	        for (SysCOMPANY s : selectComoany){
	            HSSFRow row1 = sheet.createRow(rowNum);
	            row1.createCell((short) 0).setCellValue(s.getComId());
	            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(s.getComName()));
	            row1.createCell((short) 2).setCellValue(s.getComCode());
	            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(s.getComEmail()));
	            row1.createCell((short) 4).setCellValue(new HSSFRichTextString(s.getComLinkman()));
	            row1.createCell((short) 5).setCellValue(new HSSFRichTextString(s.getComAddress()));
	            row1.createCell((short) 6).setCellValue(s.getComPhone());
	            row1.createCell((short) 7).setCellValue(s.getComYphone());
	            row1.createCell((short) 8).setCellValue(s.getComFax());
	            row1.createCell((short) 9).setCellValue(new HSSFRichTextString(s.getComBank()));
	            row1.createCell((short) 10).setCellValue(new HSSFRichTextString(s.getComBankuser()));
	            row1.createCell((short) 11).setCellValue(new HSSFRichTextString(s.getComYesandno()));
	            row1.createCell((short) 12).setCellValue(new HSSFRichTextString(s.getComRemark()));
	            row1.createCell((short) 13).setCellValue(sdf.format(s.getLastTime()));
	            rowNum++;
	        }
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName); 
	        response.flushBuffer();
	        workbook.write(response.getOutputStream());
	    }
}
