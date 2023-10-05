package com.yedam.smartree.check.web;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.check.service.CheckService;
import com.yedam.smartree.check.service.MtlCheckService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;



 /* 자재관리
 개발일자 2023/09/14 
 개발자 안영진
 */

@RequestMapping("/check")
@Controller
public class CheckController {
	@Autowired DataSource datasource;
	
	@Autowired
	MtlCheckService mtlcheckservice;
	
	@Autowired
	CheckService checkservice;
	
	@GetMapping("/check")
	public String selectMtlAllCheck() {
		return "check/check";
	}
	
	@GetMapping("mtlCheck")
	public String selectAllCheck() {
		
		return "check/mtlCheck";
	}
	
	@GetMapping("/prdtStd")
	public String selectPrdtStd() {
		return "check/prdtStd";
	}
	
	@GetMapping("/prdtCheck")
	public String selectPrdtCheck() {
		return "check/prdtCheck";
	}
	
	@GetMapping("/prdtCheckList")
	public String selectPrdtCheckList() {
		return "check/prdtCheckList";
	}
	
	@GetMapping(value="checkPdf1")
	public ResponseEntity<byte[]> generateStatus(String prdtChkCode) throws Exception, JRException {
		Connection conn = datasource.getConnection();
        
        // jasper 컴파일할 양식 설정 - 만들어둔 jrxml 파일 경로 설정
		JasperReport compileReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("/check.jrxml"));
		
        // datasource를 매핑해 양식(jrxml)에 맞게 컴파일
        HashMap<String, Object> map =new HashMap<>();
        map.put("P_PRDT_CHK_CODE", prdtChkCode);
		JasperPrint report = JasperFillManager.fillReport(compileReport, map, conn);
        
        // return 방식1. 컴파일된 pdf파일을 현재 폴더에 생성
//		JasperExportManager.exportReportToPdfFile(report, "BoardStatus.pdf");
//		return "generated";
		
        // return 방식2. 프린트 및 adobe pdf 화면 띄우기
        // *주의: 프론트에서 화면을 띄울 수 없고, 서버 url을 직접 띄워야함..
		byte[] data = JasperExportManager.exportReportToPdf(report);
		HttpHeaders headers = new HttpHeaders();
		String formatter = new SimpleDateFormat("yyyyMMdd").format(new Date());//오늘날짜 구하기
		String fileName = "inline;filename=check"+formatter+".pdf";//check + 오늘날짜 저장할때 이름
		headers.set(HttpHeaders.CONTENT_DISPOSITION, fileName);
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

}
