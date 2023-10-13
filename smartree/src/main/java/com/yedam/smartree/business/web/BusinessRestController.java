package com.yedam.smartree.business.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.BusinessService;
import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.business.service.ChartDataVO;
import com.yedam.smartree.business.service.FinPrdtVO;
import com.yedam.smartree.business.service.MonitoringVO;
import com.yedam.smartree.business.service.ReqVO;
import com.yedam.smartree.check.service.CheckVO;
/*
개발자:정호현
개발일자:23/09/14
영업관리
*/
@RestController
public class BusinessRestController {
	@Autowired
	BusinessService businessService;
	
	//리스트OrderAjax
	@GetMapping("/orders")
	public List<BusinessVO> getOrders(BusinessVO businessVO){
		return businessService.selectOrderList(businessVO);
	}
	
	//리스트DtListAjax || 주문서관리-주문서검색후 더블클릭(위의 주문정보정보는 클릭했을때let searchModalData; 검색버튼 클릭 할때 그 result를 담아준다.
	//										그리고 해당 열 더블 클릭 할때 ev.rowKey값으로 해당열의 값 받아서 뿌려주고 상세페이지만 데이터가져오면되서 dtorder 가져오는리스트 같이사용)
	@GetMapping("/orderDtList")
	public List<BusinessVO> getDtOrders(BusinessVO businessVO){
		return businessService.selectOrderDtList(businessVO);
	}
	
//	//주문서관리-주문서검색 출고전 주문서조회
	@PostMapping("/selectOrder")
	public List<BusinessVO> getOrderDt(BusinessVO businessVO) {
		return businessService.selectOrderBfOutList(businessVO);
	}

	
	//주문서관리-주문서검색후 더블클릭
//	@GetMapping("/orderDtList")
//	public List<BusinessVO>  selectOrder(BusinessVO businessVO) {
//		System.out.println(businessVO);
//		System.out.println(businessService.clickOrder(businessVO));
//		return businessService.selectOrderDtList(businessVO);
//	}
	//주문등록
	@PostMapping("/insertOrder")
	public int insertOrder(@RequestBody ReqVO<BusinessVO> businessvo) {
		return businessService.insertOrder(businessvo);
	}
	//주문수정
//	@PostMapping("/updateOrder")
//	public int updateOrder(@RequestBody ReqVO<BusinessVO> businessvo) {
//		System.out.println(businessvo);
//		return businessService.updateOrder(businessvo);
//	}
	
	//주문수정중 상세주문 추가로 등록하는경우 
	@PostMapping("/plusDtOrder")
	public int plusDtOrder(@RequestBody ReqVO<BusinessVO> businessvo) {
		return businessService.plusDtOrder(businessvo);
	}
	
	//주문서삭제
	@PostMapping("/deleteOrder")
	public int deleteOrder(@RequestBody ReqVO<BusinessVO> businessvo) {
		return businessService.deleteOrder(businessvo);
	}
	
	//주문서상세삭제
//	@PostMapping("/deleteDtOrder")
//	public int deleteDtOrder(@RequestBody ReqVO<BusinessVO> businessvo) {
//		return businessService.deleteDtOrder(businessvo);
//	}
	
	//업체목록 불러오기
	@GetMapping("/partnerList")
	public List<BpVO> getBpList(BpVO bpVO){
		
		return businessService.selectBpList(bpVO);
	}	
	//제품목록 불러오기
	@GetMapping("/prdtList")
	public List<BpVO> getprdtList(BpVO bpVO){
		return businessService.selectPrdtList(bpVO);
	}

	//Lot별 수량
	@GetMapping("/lotPrdtList")
	public List<FinPrdtVO> lotPrdtList(FinPrdtVO fpvo){
		System.out.println("111111111111111111111"+fpvo);
		return businessService.selectFinLotPrdt(fpvo);
	}
	//lot별 수량(출고시 수량0인것들 안보이게)
	@GetMapping("/lotPrdtOutList")
	public List<FinPrdtVO> lotPrdtOutList(FinPrdtVO fpvo){
		return businessService.selectFinLotOutPrdt(fpvo);
	}
	//완제품조건조회
	@PostMapping("/prdtSearch")
	public List<FinPrdtVO> prdtSearchList(FinPrdtVO fpvo){
		return businessService.prdtSearchList(fpvo);
	}
	//미출고 주문서 조회
	@GetMapping("/bfOutList")
	public List<BusinessVO> selectOrderBfOutList(BusinessVO businessVO){
		return businessService.selectOrderBfOutList(businessVO);
	}
	//기출고 주문서 조회
	@GetMapping("/searchFinOrder")
	public List<FinPrdtVO> searchFinOrder(){
		return businessService.searchFinOrder();
	}
	//출고관리 lot별
	@PostMapping("/prdtOutProcess")
	public int prdtOutProcess(@RequestBody ReqVO<FinPrdtVO> finPrdtVO) {
		System.out.println(finPrdtVO);
		return businessService.prdtOutProcess(finPrdtVO);
	}
	//출고완료시 update
	@PostMapping("/prdtFinOut")
	public int prdtFinOut( BusinessVO businessvo) {
		return businessService.prdtFinOut(businessvo);
	}
	//출고조회 
	@GetMapping("/prdtOutList")
	public List<FinPrdtVO> prdtOutList(FinPrdtVO fpv){
		
		return businessService.prdtOutList(fpv);
	}
	//출고상세조회
	@GetMapping("/prdtOutDtList")
	public List<FinPrdtVO> prdtOutDtList(FinPrdtVO fpv){
		System.out.println(fpv);
		return businessService.prdtOutDtList(fpv);
	}
	//검사끝난 입고대기품목
	@GetMapping("/prdtFinAfterChkList")
	public List<CheckVO> prdtFinAfterChkList(){
		return businessService.prdtFinAfterChkList();
	}
	//입고처리
	@PostMapping("/recievePrdt")
	public int recievePrdt(@RequestBody ReqVO<FinPrdtVO> fpv){
		
		return businessService.recievePrdt(fpv);
	}
	//입고조회
	@GetMapping("/recieveList")
	public List<FinPrdtVO> prdtRecieveList(FinPrdtVO fpv){
		return businessService.prdtRecieveList(fpv);
	}
	//출고취소처리
	@PostMapping("/cancleOutPrdt")
	public int cancleOutPrdt(@RequestBody List<BusinessVO> businessVO) {
		return businessService.cancleOutPrdt(businessVO);
	}
	
	//입고 취소처리
	@PostMapping("/cancleRecivePrdt")
	public int cancleRecivePrdt(@RequestBody List<FinPrdtVO> fpv) {
		System.out.println(fpv);
		return businessService.cancleRecivePrdt(fpv);
	}
	//키오스크:제품별출고
	@GetMapping("/getPrdtOutChartData")
	public List<BusinessVO> getPrdtOutChartData(){
		return businessService.getPrdtOutChartData();
	}
	
	//메인페이지 당일 차트 전부가져오기
	@GetMapping("/getAllChartData")
	public ChartDataVO getAllChartData() {
		return businessService.getAllChartData();
	}
	//메인페이지 제품별주문
	@GetMapping("/getOrderChartData")
	public List<BusinessVO> getOrderChartData(){
		return businessService.getOrderChartData();
	}
	//온도현황모니터링
	@GetMapping("/monitoringTemperature")
	public String monitoring(){
		return businessService.monitoring();
	}
	//습도현황모니터링
	@GetMapping("/monitoringHumidity")
	public String monitoringHumidity(){
		return businessService.monitoringHumidity();
	}
}
