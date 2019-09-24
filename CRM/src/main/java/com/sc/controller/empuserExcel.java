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
import com.sc.bean.SysEmpuser;
import com.sc.service.SysComPanyService;
import com.sc.service.SysEmpuserService;
@Controller
@RequestMapping("sysEmpuser")
public class empuserExcel {
	
	@Autowired
	SysEmpuserService SysEmpuserService;
	
	@RequestMapping("/sysEmpuserexcle.do")
	    public void UserExcelDownloads(HttpServletResponse response,SysDuty u)throws IOException {
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("员工信息表");
	       List<SysEmpuser> sysEmpuser = SysEmpuserService.selectSysEmpuser();
	        String str = "yyy-MM-dd HH:mm";
	        SimpleDateFormat sdf = new SimpleDateFormat(str);
	        String fileName = "sysempuser" + ".xls";
	        int rowNum = 1;
	        String [] headers = {"员工编号","员工姓名","员工性别","员工照片","身份证号","家庭住址","现在地址","员工学历","政治面貌","毕业学校","联系电话","网上联系方式","网上联系详情","审核状态"
	        		,"职务编号","员工状态","备注信息","公司编号","修改时间"};
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
	        for (SysEmpuser s : sysEmpuser){
	            HSSFRow row1 = sheet.createRow(rowNum);
	            row1.createCell((short) 0).setCellValue(s.getEmpId());
	            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(s.getEmpName()));
	            row1.createCell((short) 2).setCellValue(s.getEmpSix());
	            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(s.getEmpPrice()));
	            row1.createCell((short) 4).setCellValue(new HSSFRichTextString(s.getEmpNumber()));
	            row1.createCell((short) 5).setCellValue(new HSSFRichTextString(s.getEmpAddress()));
	            row1.createCell((short) 6).setCellValue(new HSSFRichTextString(s.getEmpTadayadd()));
	            row1.createCell((short) 7).setCellValue(new HSSFRichTextString(s.getEmpEduca()));
	            row1.createCell((short) 8).setCellValue(new HSSFRichTextString(s.getEmpFace()));
	            row1.createCell((short) 9).setCellValue(new HSSFRichTextString(s.getEmpSchool()));
	            row1.createCell((short) 10).setCellValue(new HSSFRichTextString(s.getEmpPhone()));
	            row1.createCell((short) 11).setCellValue(new HSSFRichTextString(s.getEmpMeshphone()));
	            row1.createCell((short) 12).setCellValue(new HSSFRichTextString(s.getEmpContact()));
	            row1.createCell((short) 13).setCellValue(new HSSFRichTextString(s.getEmpState()));
	            row1.createCell((short) 14).setCellValue(new HSSFRichTextString(s.getEmpSysstate()));
	            row1.createCell((short) 15).setCellValue(s.getDutId());
	            row1.createCell((short) 16).setCellValue(new HSSFRichTextString(s.getEmpRemark()));
	            row1.createCell((short) 17).setCellValue(s.getComId());
	            row1.createCell((short) 18).setCellValue(sdf.format(s.getLastTime()));
	            rowNum++;
	        }
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName); 
	        response.flushBuffer();
	        workbook.write(response.getOutputStream());
	    }
}
