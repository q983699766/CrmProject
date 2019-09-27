package com.sc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.PurOrderInfo;
import com.sc.bean.SalDetails;
import com.sc.bean.SalOrder;
import com.sc.bean.SysDuty;
import com.sc.service.CcSpxxService;
import com.sc.service.SysDutyService;

@Controller // 注册成bean对象
@RequestMapping("/ccspxxctlr")
public class CcCkSpxxbController {
	@Autowired
	CcSpxxService ccSpxxService;
	@Autowired
	 SysDutyService sysDutyService;
	

	// 1.分页查看仓库商品列表（以测试）
	@RequestMapping("/list.do")
	public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize) {

		System.out.println("进入查询方法1111");
		// 添加模型数据
		mav.addObject("pi", ccSpxxService.selectCcspxxPage(pageNum, pageSize));
		// 设置视图名称 转发
		mav.setViewName("Ck/splb");// 响应的视图名称，路径是：/WEB-INF/users/list.jsp
		return mav;
	}

	// 通过id删除仓库商品列表
	@RequestMapping("/del.do")
	public ModelAndView del(ModelAndView mav, Long productId) {

		System.out.println("接收到的productId为" + productId);
		ccSpxxService.delCcspxx(productId);
		// 重定向到列表方法
		mav.setViewName("redirect:list.do");
		return mav;
	}

	// 添加
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav, Ccspxxb u, PurOrderInfo p,HttpServletRequest req) {
		//入库
		List<Ccspxxb> selectCcspxx = ccSpxxService.selectCcspxx();
		System.out.println("==========" + selectCcspxx);
		for (Ccspxxb ccspxxb : selectCcspxx) {
			if (p.getProductId() == ccspxxb.getProductId()) {
				Date date = new Date();
				ccspxxb.setKcSl(ccspxxb.getKcSl() + p.getProductCount());
				
				ccSpxxService.updateCcspxx(ccspxxb, p);
				mav.setViewName("redirect:../cgxqctlr/ck.do");
				return mav;
			}
		}
		//添加
		System.out.println("进入添加方法" + u);
		Date date = new Date();
		
		u.setLastTime(date);
		// 添加模型数据
		ccSpxxService.addCcspxx(u);
		// 设置视图名称 转发
		mav.setViewName("redirect:");// 响应的视图名称，路径是：/WEB-INF/users/list.jsp
		return mav;
	}

	// 模糊查询
	@RequestMapping("/mh.do")
	public ModelAndView selectmh(ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize, Ccspxxb ccspxx) {

		System.out.println("进入查询供应商信息方法" + ccspxx);

		mav.addObject("pi", ccSpxxService.selectmh(pageNum, pageSize, ccspxx));
		System.out.println(ccSpxxService.selectmh(pageNum, pageSize, ccspxx));
		String spMc = ccspxx.getSpMc();
		mav.addObject("spMc",spMc);
		mav.setViewName("Ck/splb");

		return mav;
	}

	// 修改
	@RequestMapping("/updateccspxx.do")
	public ModelAndView updateccspxx(ModelAndView mav, Ccspxxb u) {
		System.out.println("修改的的用户信息是：" + u);
		Date date = new Date();
		u.setLastTime(date);
		ccSpxxService.updateCcspxx(u, null);
		mav.setViewName("redirect:list.do");
		return mav;
	}

	// 通过id查询
	@RequestMapping("/select.do")
	@ResponseBody
	public Ccspxxb selectById(HttpServletRequest req) throws IllegalStateException, IOException {
		System.out.println("进入查看弹层页面");
		String productId = req.getParameter("productId");
		Long uid = (long) Integer.parseInt(productId);
		Ccspxxb byUid = ccSpxxService.selectCcspxxByUid(uid);
		System.out.println("查出的用户为" + byUid);
		return byUid;

	}

	// 批量删除
	@RequestMapping("/sc.do")
	public ModelAndView del(ModelAndView mav, HttpServletRequest req) {
		String[] xx = req.getParameterValues("bb");
		System.out.println("2222222222222222" + xx);
		System.out.println("进入删除3333333333333333");
		for (int i = 0; i < xx.length; i++) {
			long l = Long.parseLong(xx[i]);
			System.out.println("111111111111" + l);
			// pursupinfoservice.delinfo(l);
			ccSpxxService.delCcspxx(l);
		}
		// 重定向到列表方法
		mav.setViewName("redirect:list.do");
		return mav;
	}

	//查询销售出库单
	
	@RequestMapping("/xs.do")
	public ModelAndView xs(ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize) {

		System.out.println("进入查询方法1111");
		// 添加模型数据
		mav.addObject("pi", ccSpxxService.selectSalOrder(pageNum, pageSize));
		// 设置视图名称 转发
		mav.setViewName("Ck/xsxq");// 响应的视图名称，路径是：/WEB-INF/users/list.jsp
		return mav;
	}
	
	// 销售根据订单状态查询
		@RequestMapping("/xsmh.do")
		public ModelAndView xsmh(ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
				@RequestParam(defaultValue = "5") Integer pageSize, SalOrder salOrder) {

			System.out.println("进入查询销售信息方法" + salOrder.getOrderState());

			mav.addObject("pi", ccSpxxService.xsmh(pageNum, pageSize, salOrder));
			System.out.println(ccSpxxService.xsmh(pageNum, pageSize, salOrder));
	
			mav.setViewName("Ck/xsxq");

			return mav;
		}
	
		//通过销售单id查询该条商品的销售订单详情
		@RequestMapping("/xsid.do")	
		public ModelAndView  selectSalDetailsByUid(HttpServletRequest req,ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
				@RequestParam(defaultValue = "5") Integer pageSize ,Long orderId ) {
			System.out.println("进入查询销售信息方法" );
			String orderid = req.getParameter("orderId");
			Long uid = (long) Integer.parseInt(orderid);
			System.out.println("销售详情的销售单编号"+uid);
			PageInfo<SalDetails> list = ccSpxxService.selectSalDetailsByUid(pageNum, pageSize, orderId);		
			mav.addObject("pi",list);
			mav.setViewName("Ck/xsxq2");
			return mav ;
		}
		
		//销售出库
		@RequestMapping("/chuku.do")
		public ModelAndView ck(ModelAndView mav, Ccspxxb u, SalOrder p ,HttpServletRequest req)
		{
			String xx = req.getParameter("a");
			Long xxx=Long.parseLong(xx);
			String cc = req.getParameter("cc");
			Long ccc=Long.parseLong(cc);
			System.out.println(xx+"xxxxxxxxxxxxxxxxxxxx");
			System.out.println(ccc+"ccccccccccccccccccc");
			//出库
			List<Ccspxxb> selectCcspxx = ccSpxxService.selectCcspxx();
			System.out.println("进入出库方法" + selectCcspxx);
			for (Ccspxxb ccspxxb : selectCcspxx)
			{
				if (xxx.equals(ccspxxb.getProductId())) 
					{  
						System.out.println("+++++++++++++++++++");
						Date date = new Date();
						ccspxxb.setKcSl(ccspxxb.getKcSl()-ccc);			
						ccSpxxService.updaCcspxx(ccspxxb,p);
						System.out.println("+++++++++++++++++++");
						mav.setViewName("redirect:xs.do");
						
					}
			}
			return mav;
		}
		
		
		
/*	@RequestMapping("/excle.do")
		public void UserExcelDownloads(HttpServletResponse response) throws IOException {
			HSSFWorkbook workbook = new HSSFWorkbook();  
			HSSFSheet sheet = workbook.createSheet("职位信息表");
			sheet.setColumnWidth(5, 256*20); //设置列的宽度
			//List<SysDuty> selectDuty = sysDutyService.selectDuty();
			List<Ccspxxb> selectDuty = ccSpxxService.selectCcspxx();
			String str = "yyy-MM-dd HH:mm";
			SimpleDateFormat sdf = new SimpleDateFormat(str);
			String fileName = "sysduty" + ".xls";
			int rowNum = 1;
			String[] headers = { "商品编号", "商品名称", "商品类型", "单位", "仓库编号", "库存数量" ,"成本价","零售价","经销价","备注信息","公司编号","最后修改时间"};
			HSSFRow row = sheet.createRow(0);
			row.setHeightInPoints(30);//设置行的高度y
			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell((short) i);
				HSSFRichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			for (Ccspxxb student : selectDuty) {
				HSSFRow row1 = sheet.createRow(rowNum);
				row1.createCell((short) 0).setCellValue(student.getProductId());
				row1.createCell((short) 1).setCellValue(new HSSFRichTextString(student.getSpMc()));
				row1.createCell((short) 2).setCellValue(student.getSpLb());
				row1.createCell((short) 3).setCellValue(new HSSFRichTextString(student.getDw()));
				row1.createCell((short) 4).setCellValue(student.getCkBh());
				row1.createCell((short) 5).setCellValue(student.getKcSl());
				row1.createCellFromRecord((Float) 6).setCellStyle(student.getCbj());
				row1.createCellFromRecord((Float) 7).setCellValue(student.getLsj());
				row1.createCellFromRecord((Float) 8).setCellValue(student.getJxj());
				row1.createCell((short) 9).setCellValue(new HSSFRichTextString(student.getBzxx()));
				row1.createCell((short) 4).setCellValue(student.getComId());
				row1.createCell((short) 7).setCellValue(sdf.format(student.getLastTime()));
				rowNum++;
			}
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
			response.flushBuffer();
			workbook.write(response.getOutputStream());
		}
	

		
		*/
		
		
		
		
		
}