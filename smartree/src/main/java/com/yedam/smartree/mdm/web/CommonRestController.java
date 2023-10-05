package com.yedam.smartree.mdm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;
import com.yedam.smartree.mdm.service.MdmBomVO;
import com.yedam.smartree.mdm.service.MdmBpVO;
import com.yedam.smartree.mdm.service.MdmChkVO;
import com.yedam.smartree.mdm.service.MdmMtlVO;
import com.yedam.smartree.mdm.service.MdmPrcsVO;
import com.yedam.smartree.mdm.service.MdmPrdtVO;
import com.yedam.smartree.mdm.service.MdmService;
import com.yedam.smartree.prod.service.RequestVO;

/*
	개발자 : 정현철
	개발일자 : 2023/09/14
	기준정보관리 데이터 조회
*/
@RequestMapping("/mdm")
@RestController
public class CommonRestController {
	
	@Autowired
	MdmService mdmService;

	// 코드분류조회
	@GetMapping("/selectCommonCode")
	public List<CommonCodeVO> selectCommonCode() {
		return mdmService.selectCommonCode();
	}

	// 코드상세조회
	@GetMapping("/selectCodeDetail")
	public List<CommonCodeVO> selectCodeDetail(String codeType) {
		return mdmService.selectCodeDetail(codeType);
	}

	// 공통코드입력
	@PostMapping("/insertCommonCode")
	public void insertCommonCode(@RequestBody List<CommonCodeVO> commonCodeList) {
		for(CommonCodeVO commonCode : commonCodeList) {
			mdmService.insertCommonCode(commonCode);
		}
	}

	// 상세코드입력
	@PostMapping("/insertCodeDetail")
	public void insertCodeDetail(@RequestBody List<CommonCodeVO> codeDetailList) {
		for(CommonCodeVO codeDetail : codeDetailList) {
			mdmService.insertCodeDetail(codeDetail);
		}
	}

	// 공통코드삭제
	@PostMapping("/deleteCommonCode")
	public int deleteCommonCode(@RequestBody List<CommonCodeVO> delList) {
		int cnt = 0;
		for(CommonCodeVO delData : delList) {
			String codeType = delData.getCodeType();
			if(mdmService.selectCodeDetail(codeType).isEmpty()) { // 상세목록이 비어있는지 확인
				mdmService.deleteCommonCode(delData);
				cnt ++;
			}
		}
		return cnt;
	}
	
	// 상세코드삭제
	@PostMapping("/deleteCodeDetail")
	public int deleteCodeDetail(@RequestBody List<CommonCodeVO> delList) {
		int cnt=0;
		for(CommonCodeVO delData : delList) {
			cnt += mdmService.deleteCodeDetail(delData);
		}
		return cnt;
	}
	
	
	// 사원관리
		
	// 사원 조회
	@GetMapping("/selectEmpList")
	public List<EmpVO> selectEmpList(String empDept, String empName) {
		return mdmService.selectEmpList(empDept, empName);
	}
	
	//	사원 등록
	@PostMapping("/insertEmp")
	public String addEmp(@RequestBody EmpVO empInfo) {
		String msg = "";
		if(mdmService.addEmp(empInfo)>0) {
			msg = "등록성공";
		} else {
			msg = "등록실패";
		}
		return msg;
	}
	// 비밀번호 초기화
	@PostMapping("/resetPw")
	public int resetPw(@RequestBody EmpVO vo) {
		return mdmService.resetPw(vo);
	}
	
	/*
	 * // 비밀번호 변경
	 * 
	 * @PostMapping("/updatePw") public int updatePw() { return }
	 */

	// 제품관리
	
	// 제품리스트
	@GetMapping("/selectPrdtList")
	public List<MdmPrdtVO> selectPrdtList(){
		return mdmService.selectPrdtList();
	}
	
	// 제품단건조회
	@GetMapping("/selectPrdt")
	public MdmPrdtVO selectPrdt(String prdtCode) {
		return mdmService.selectPrdt(prdtCode);
	}
	
	// 제품검색
	@PostMapping("/searchPrdt")
	public List<MdmPrdtVO> searchPrdt(@RequestBody MdmPrdtVO vo) {
		return mdmService.searchPrdt(vo);
	}
	
	// 제품등록
	@PostMapping("/insertPrdt")
	public String insertPrdt(@RequestBody MdmPrdtVO vo) {
		String msg ="등록실패";
		if(mdmService.insertPrdt(vo)>0) msg = "등록완료";
		return msg;
	}
	
	// 제품수정
	@PostMapping("/updatePrdt")
	public String updatePrdt(@RequestBody MdmPrdtVO vo) {
		String msg = "수정실패";
		if(mdmService.updatePrdt(vo)>0) msg = "수정완료";
		return msg;
	}
	
	// 제품삭제
	@PostMapping("/deletePrdt")
	public String deletePrdt(String prdtCode) {
		String msg = "삭제실패";
		if(mdmService.deletePrdt(prdtCode)>0) msg = "삭제완료";
		return msg;
	}
	
	// 자재관리
	
	// 자재리스트
	@GetMapping("/selectMtlList")
	public List<MdmMtlVO> selectMtlList(){
		return mdmService.selectMtlList();
	}
	
	// 자재단건조회
	@GetMapping("/selectMtl")
	public MdmMtlVO selectMtl(String mtlCode) {
		return mdmService.selectMtl(mtlCode);
	}
	
	// 자재검색
	@PostMapping("/searchMtl")
	public List<MdmMtlVO> searchMtl(@RequestBody MdmMtlVO vo) {
		return mdmService.searchMtl(vo);
	}
	
	// 자재등록
	@PostMapping("/insertMtl")
	public String insertMtl(@RequestBody MdmMtlVO vo) {
		String msg ="등록실패";
		if(mdmService.insertMtl(vo)>0) msg = "등록완료";
		return msg;
	}
	
	// 자재수정
	@PostMapping("/updateMtl")
	public String updateMtl(@RequestBody MdmMtlVO vo) {
		String msg = "수정실패";
		if(mdmService.updateMtl(vo)>0) msg = "수정완료";
		return msg;
	}
	
	// 자재삭제
	@PostMapping("/deleteMtl")
	public String deleteMtl(String mtlCode) {
		String msg = "삭제실패";
		if(mdmService.deleteMtl(mtlCode)>0) msg = "삭제완료";
		return msg;
	}
	
	// 거래처관리
	
	// 거래처리스트
	@GetMapping("/selectBpList")
	public List<MdmBpVO> selectBpList(){
		return mdmService.selectBpList();
	}
	
	// 거래처단건조회
	@GetMapping("/selectBp")
	public MdmBpVO selectBp(String bpCode) {
		return mdmService.selectBp(bpCode);
	}
	
	// 거래처검색
	@PostMapping("/searchBp")
	public List<MdmBpVO> searchBp(@RequestBody MdmBpVO vo) {
		return mdmService.searchBp(vo);
	}
	
	// 거래처등록
	@PostMapping("/insertBp")
	public String insertBp(@RequestBody MdmBpVO vo) {
		String msg ="등록실패";
		if(mdmService.insertBp(vo)>0) msg = "등록완료";
		return msg;
	}
	
	// 거래처수정
	@PostMapping("/updateBp")
	public String updateBp(@RequestBody MdmBpVO vo) {
		String msg = "수정실패";
		if(mdmService.updateBp(vo)>0) msg = "수정완료";
		return msg;
	}
	
	// 거래처삭제
	@PostMapping("/deleteBp")
	public String deleteBp(String bpCode) {
		String msg = "삭제실패";
		if(mdmService.deleteBp(bpCode)>0) msg = "삭제완료";
		return msg;
	}
	
	// 공정관리
	// 공정리스트
	@GetMapping("/selectPrcsList")
	public List<MdmPrcsVO> selectPrcsList(){
		return mdmService.selectPrcsList();
	}
	
	// 공정단건조회
	@GetMapping("/selectPrcs")
	public MdmPrcsVO selectPrcs(String prcsStdCode) {
		return mdmService.selectPrcs(prcsStdCode);
	}
	
	// 공정검색
	@PostMapping("/searchPrcs")
	public List<MdmPrcsVO> searchPrcs(@RequestBody MdmPrcsVO vo) {
		return mdmService.searchPrcs(vo);
	}
	
	// 공정등록
	@PostMapping("/insertPrcs")
	public String insertPrcs(@RequestBody MdmPrcsVO vo) {
		String msg ="등록실패";
		if(mdmService.insertPrcs(vo)>0) msg = "등록완료";
		return msg;
	}
	
	// 공정수정
	@PostMapping("/updatePrcs")
	public String updatePrcs(@RequestBody MdmPrcsVO vo) {
		String msg = "수정실패";
		if(mdmService.updatePrcs(vo)>0) msg = "수정완료";
		return msg;
	}
	
	// 공정삭제
	@PostMapping("/deletePrcs")
	public String deletePrcs(String prcsStdCode) {
		String msg = "삭제실패";
		if(mdmService.deletePrcs(prcsStdCode)>0) msg = "삭제완료";
		return msg;
	}
	
	// 품질검사관리
	// 품질검사리스트
	@GetMapping("/selectChkList")
	public List<MdmChkVO> selectChkList(){
		return mdmService.selectChkList();
	}
	
	// 품질검사단건조회
	@GetMapping("/selectChk")
	public MdmChkVO selectChk(String chkStdCode) {
		return mdmService.selectChk(chkStdCode);
	}
	
	// 품질검사검색
	@PostMapping("/searchChk")
	public List<MdmChkVO> searchChk(@RequestBody MdmChkVO vo) {
		return mdmService.searchChk(vo);
	}
	
	// 품질검사등록
	@PostMapping("/insertChk")
	public String insertChk(@RequestBody MdmChkVO vo) {
		String msg ="등록실패";
		if(mdmService.insertChk(vo)>0) msg = "등록완료";
		return msg;
	}
	
	// 품질검사수정
	@PostMapping("/updateChk")
	public String updateChk(@RequestBody MdmChkVO vo) {
		String msg = "수정실패";
		if(mdmService.updateChk(vo)>0) msg = "수정완료";
		return msg;
	}
	
	// 품질검사삭제
	@PostMapping("/deleteChk")
	public String deleteChk(String chkStdCode) {
		String msg = "삭제실패";
		if(mdmService.deleteChk(chkStdCode)>0) msg = "삭제완료";
		return msg;
	}
	
	
	// BOM관리
	
	// BOM 정보
	@GetMapping("/selectBomList")
	public List<MdmBomVO> selectBomList(String prdtCode){
		return mdmService.selectBomList(prdtCode);
	}
	
	// BOM 상세
	@GetMapping("/selectBomDetail")
	public List<MdmBomVO> selectBomDetail(String prdtCode, String bomCode) {
		return mdmService.selectBomDetail(prdtCode,bomCode);
	}
	
	// BOM 등록&수정
	@PostMapping("/bomProcess")
	public int bomProcess(@RequestBody RequestVO<MdmBomVO> reqVO) {
		return mdmService.bomProcess(reqVO);
	}
}
