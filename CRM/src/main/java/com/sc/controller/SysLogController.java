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
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysLog;
import com.sc.service.SysLogService;

@Controller
@RequestMapping("syslogctrl")
public class SysLogController {
	@Autowired
	SysLogService sls;
	
	@RequestMapping("showLOg")
	public ModelAndView showSysLog(ModelAndView mav
			,@RequestParam(defaultValue="1") Integer pageNum
			,@RequestParam(defaultValue="50") Integer pageSize){
		mav.addObject("SysLog", sls.showSysLog(pageNum, pageSize));
		mav.setViewName("sys/syslog");
		return mav;
	}
	
	@RequestMapping("/excle.do")
	public void UserExcelDownloads(HttpServletResponse response) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("系统日志表");
		sheet.setColumnWidth(5, 256*20); //设置列的宽度
		List<SysLog> sysLog = sls.sysLog();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String fileName = "SysLog.xls";
		int rowNum = 1;
		String[] headers = { "日志编号", "用户", "访问ip", "权限", "访问时间", "公司" };
		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(30);//设置行的高度y
		//生成表头
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell((short) i);
			cell.setCellValue(new HSSFRichTextString(headers[i]));
		}
		for (SysLog log : sysLog) {
			HSSFRow row1 = sheet.createRow(rowNum);
			Long logId = log.getLogId();
			String userName = log.getUser().getUserName();
			String accessIp = log.getAccessIp();
			String permission = log.getPermission();
			String accessTime = sdf.format(log.getAccessTime());
			String comName = "暂无公司";
			if(log.getCompany() != null){
				comName = log.getCompany().getComName();
			}
			row1.createCell((short) 0).setCellValue(logId);
			row1.createCell((short) 1).setCellValue(new HSSFRichTextString(userName));
			row1.createCell((short) 2).setCellValue(new HSSFRichTextString(accessIp));
			row1.createCell((short) 3).setCellValue(new HSSFRichTextString(permission));
			row1.createCell((short) 4).setCellValue(new HSSFRichTextString(accessTime));
			row1.createCell((short) 5).setCellValue(new HSSFRichTextString(comName));
			rowNum++;
		}
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}
}
