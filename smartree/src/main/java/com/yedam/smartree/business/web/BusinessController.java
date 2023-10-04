package com.yedam.smartree.business.web;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.business.service.BusinessService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
/*
개발자:정호현
개발일자:23/09/14
영업관리
*/
@Controller
@RequestMapping("/business")
public class BusinessController {
	@Autowired DataSource datasource;
	@Autowired
	BusinessService businessService;
	//주문서조회페이지이동
	@GetMapping("orderList")
	public String selectAllOrder() {
		
		return "business/orderList";
	}
	//주문서관리페이지이동
	@GetMapping("orderForm")
	public String selectOrderForm() {
		return "business/orderForm";
	}
	//완제품재고조회 페이지이동
	@GetMapping("finPrdt")
	public String selectFinPrdt(Model model) {
		model.addAttribute("finPrdt", businessService.selectFinPrdt());
		return "business/finPrdt";
	}
	
	//출고관리 페이지 이동
	@GetMapping("prdtOut")
	public String selectprdtOut() {
		return "business/prdtOut";
	}
	//출고조회 페이지이동
	@GetMapping("prdtOutCheck")
	public String prdtOutCheck() {
		return "business/prdtOutList";
	}
	//입고관리 페이지이동
	@GetMapping("prdtRecieve")
	public String prdtRecieve() {
		return "business/prdtRecieve";
	}
	//입고조회 페이지 이동
	@GetMapping("prdtRecieveList")
	public String prdtRecieveList() {
		return "business/prdtRecieveList";
	}

	/*
	 * @RequestMapping("orderPdf") public void report1(String orderCode,
	 * HttpServletResponse response) throws Exception { Connection conn =
	 * datasource.getConnection(); InputStream jasperStream =
	 * getClass().getResourceAsStream("/order.jasper"); JasperReport jasperReport =
	 * (JasperReport) JRLoader.loadObject(jasperStream); // 파라미터 맵 HashMap<String,
	 * Object> map = new HashMap<>(); map.put("P_ORDER_CODE", orderCode);
	 * JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,
	 * conn); JasperExportManager.exportReportToPdfStream(jasperPrint,
	 * response.getOutputStream()); }
	 */
	@GetMapping(value="orderPdf1")
	public ResponseEntity<byte[]> generateStatus(String orderCode) throws Exception, JRException {
		Connection conn = datasource.getConnection();
        
        // jasper 컴파일할 양식 설정 - 만들어둔 jrxml 파일 경로 설정
		JasperReport compileReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("/order.jrxml"));
		
        // datasource를 매핑해 양식(jrxml)에 맞게 컴파일
        HashMap<String, Object> map =new HashMap<>();
        map.put("P_ORDER_CODE", orderCode);
		JasperPrint report = JasperFillManager.fillReport(compileReport, map, conn);
        
        // return 방식1. 컴파일된 pdf파일을 현재 폴더에 생성
//		JasperExportManager.exportReportToPdfFile(report, "BoardStatus.pdf");
//		return "generated";
		
        // return 방식2. 프린트 및 adobe pdf 화면 띄우기
        // *주의: 프론트에서 화면을 띄울 수 없고, 서버 url을 직접 띄워야함..
		byte[] data = JasperExportManager.exportReportToPdf(report);
		HttpHeaders headers = new HttpHeaders();
		String formatter = new SimpleDateFormat("yyyyMMdd").format(new Date());//오늘날짜 구하기
		String fileName = "inline;filename=order"+formatter+".pdf";//order + 오늘날짜 저장할때 이름
		headers.set(HttpHeaders.CONTENT_DISPOSITION, fileName);
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
}
