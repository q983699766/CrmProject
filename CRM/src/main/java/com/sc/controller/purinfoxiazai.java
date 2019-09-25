package com.sc.controller;

import java.io.IOException;
import java.math.BigDecimal;
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

import com.sc.bean.PurSupInfo;
import com.sc.mapper.PurSupInfoMapper;
import com.sc.service.PurSupInfoService;
@Controller
@RequestMapping("/pur")
public class purinfoxiazai {
	
	@Autowired
	 PurSupInfoMapper purSupInfoMapper;
	@Autowired
	PurSupInfoService  purSupInfoService;
	
	@RequestMapping("/xiazai.do")
	    public void UserExcelDownloads(HttpServletResponse response,PurSupInfo u)throws IOException {
		System.out.println("进入下载");
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("供应商信息表");
	         List<PurSupInfo> list = purSupInfoService.select();
	         System.out.println("。。。。。。"+list);
	      // List<PurSupInfo> selectDuty  = purSupInfoMapper.selectByExample(null);
	        String str = "yyy-MM-dd HH:mm";
	        SimpleDateFormat sdf = new SimpleDateFormat(str);
	        String fileName = "sysduty" + ".xls";
	        int rowNum = 1;
	        String [] headers = {"供应商编号","供应商名称","供应商简称","联系人","固定电话","移动电话",
	        		"联系传真","邮箱","开户银行","银行性质","公司主页","是否生效","备注信息","公司编号","最后修改时间","银行账户"};
	        HSSFRow row = sheet.createRow(0);
	        
	        for (int i = 0;i<headers.length;i++){
	            HSSFCell cell = row.createCell((short) i);
	            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
	            cell.setCellValue(text);
	        }
	        for (PurSupInfo student : list){
	            HSSFRow row1 = sheet.createRow(rowNum);
	            row1.createCell((short) 0).setCellValue(student.getSupInfoNum());
	           row1.createCell((short) 1).setCellValue(new HSSFRichTextString(student.getSupName()));
	            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(student.getSupUname()));
	            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(student.getComIndex()));
	            row1.createCell((short) 4).setCellValue(new HSSFRichTextString(student.getFixedTel()));
	            row1.createCell((short) 5).setCellValue(new HSSFRichTextString(student.getTelphone()));
	            row1.createCell((short) 6).setCellValue(new HSSFRichTextString(student.getFax()));
	            row1.createCell((short) 7).setCellValue(new HSSFRichTextString(student.getEmail()));
	            row1.createCell((short) 8).setCellValue(new HSSFRichTextString(student.getOpenBank()));
	            row1.createCell((short) 9).setCellValue(new HSSFRichTextString(student.getBankNature()));
	            row1.createCell((short) 10).setCellValue(new HSSFRichTextString(student.getComIndex()));
	            row1.createCell((short) 11).setCellValue(new HSSFRichTextString(student.getEffectiveOrnot()));
//	            row1.createCell((short) 12).setCellValue(student.getOperatorId());
	            row1.createCell((short) 12).setCellValue(new HSSFRichTextString(student.getRemarksInfo()));
	            row1.createCell((short) 13).setCellValue(student.getComId());
	            row1.createCell((short) 14).setCellValue(sdf.format(student.getLastDate()));
	            row1.createCell((short) 15).setCellValue(String.valueOf(student.getBankNumber()));
	            rowNum++;
	        }
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName); 
	        response.flushBuffer();
	        workbook.write(response.getOutputStream());
	    }
}
