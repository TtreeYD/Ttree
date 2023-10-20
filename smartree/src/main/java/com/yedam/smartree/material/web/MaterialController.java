package com.yedam.smartree.material.web;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.material.service.MaterialService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
/*
	개발자   : 남태원
	개발일자  : 2023/09/13
			 자재관리
*/
@Controller
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	MaterialService materialService;
	@Autowired
	DataSource datasource;
	
	// 발주목록 전체조회
	@GetMapping("/mtlNeedList")
	public String selectNeedList() {
		return "material/mtlNeedList";
	}
	// 재고목록 전체조회
	@GetMapping("/mtlList")
	public String selectMtlList() {
		
		return "material/mtlList";
	}
	// 출고목록 전체조회
	@GetMapping("/mtlOutList")
	public String selectMtlOutList() {
		
		return "material/mtlOutList";
	}
	// 발주관리 
	@GetMapping("/mtlNeedControl")
	public String controlNeedList() {
		return "material/mtlNeedControl";
	}
	// 입고관리
	@GetMapping("/mtlInControl")
	public String controlInList() {
		return "material/mtlInControl";
	}
	// PDF 출력기능
	@GetMapping(value="mtlPdf1")
	public ResponseEntity<byte[]> generateStatus(String bpName, String mtlDate ,String pdfEncUrl) throws Exception, JRException {
		Connection conn = datasource.getConnection();
        
        // jasper 컴파일할 양식 설정 - 만들어둔 jrxml 파일 경로 설정
		JasperReport compileReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("/material.jrxml"));
		
        // datasource를 매핑해 양식(jrxml)에 맞게 컴파일
        HashMap<String, Object> map =new HashMap<>();
        map.put("P_BP_NAME", bpName);
        map.put("P_MTL_DATE", mtlDate);
		/* map.put("pdfEncUrl", pdfEncUrl); */
        System.out.println(pdfEncUrl);
		JasperPrint report = JasperFillManager.fillReport(compileReport, map, conn);
        
        // return 방식1. 컴파일된 pdf파일을 현재 폴더에 생성
//		JasperExportManager.exportReportToPdfFile(report, "BoardStatus.pdf");
//		return "generated";
		
        // return 방식2. 프린트 및 adobe pdf 화면 띄우기
        // *주의: 프론트에서 화면을 띄울 수 없고, 서버 url을 직접 띄워야함..
		byte[] data = JasperExportManager.exportReportToPdf(report);
		HttpHeaders headers = new HttpHeaders();
		String formatter = new SimpleDateFormat("yyyyMMdd").format(new Date());//오늘날짜 구하기
		String fileName = "inline;filename=material"+formatter+".pdf";
		headers.set(HttpHeaders.CONTENT_DISPOSITION, fileName);
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
}
