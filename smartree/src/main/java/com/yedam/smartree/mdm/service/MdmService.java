package com.yedam.smartree.mdm.service;

import java.util.List;

import com.yedam.smartree.prod.service.RequestVO;

public interface MdmService {
	// 공통코드관리
	public List<CommonCodeVO> selectCommonCode();
	public List<CommonCodeVO> selectCodeDetail(String codeType);
	public int insertCommonCode(CommonCodeVO commonCodeVO);
	public int insertCodeDetail(CommonCodeVO commonCodeVO);
	public int deleteCommonCode(CommonCodeVO commonCodeVO);
	public int deleteCodeDetail(CommonCodeVO commonCodeVO);
	
	// 사원관리
	public List<EmpVO> selectEmpList(String empDept, String empName);
	List<EmpVO> selectUnusedEmp(EmpVO vo);
	public int addEmp(EmpVO vo);
	int resetPw(EmpVO vo);
	int updatePassword(EmpVO vo);
	int delEmp(List<EmpVO> list);
	int unUseEmp(List<EmpVO> list);
	int upEmp(List<EmpVO> list);
	
	
	// 제품관리
	List<MdmPrdtVO> selectPrdtList();
	MdmPrdtVO selectPrdt(String prdtCode);
	List<MdmPrdtVO> searchPrdt(MdmPrdtVO vo);
	int insertPrdt(MdmPrdtVO vo);
	int updatePrdt(MdmPrdtVO vo);
	int deletePrdt(String prdtCode);
	
	// 자재관리
	List<MdmMtlVO> selectMtlList();
	MdmMtlVO selectMtl(String mtlCode);
	List<MdmMtlVO> searchMtl(MdmMtlVO vo);
	int insertMtl(MdmMtlVO vo);
	int updateMtl(MdmMtlVO vo);
	int deleteMtl(String mtlCode);
	
	// 거래처관리
	List<MdmBpVO> selectBpList();
	MdmBpVO selectBp(String bpCode);
	List<MdmBpVO> searchBp(MdmBpVO vo);
	int insertBp(MdmBpVO vo);
	int updateBp(MdmBpVO vo);
	int deleteBp(String bpCode);
	
	// 공정관리
	List<MdmPrcsVO> selectPrcsList();
	MdmPrcsVO selectPrcs(String prcsStdCode);
	List<MdmPrcsVO> searchPrcs(MdmPrcsVO vo);
	int insertPrcs(MdmPrcsVO vo);
	int updatePrcs(MdmPrcsVO vo);
	int deletePrcs(String prcsStdCode);
	
	// 품질검사관리
	List<MdmChkVO> selectChkList();
	MdmChkVO selectChk(String chkStdCode);
	List<MdmChkVO> searchChk(MdmChkVO vo);
	int insertChk(MdmChkVO vo);
	int updateChk(MdmChkVO vo);
	int deleteChk(String chkStdCode);
	
	// BOM관리
	List<MdmBomVO> selectBomDetail(String prdtCode,String bomCode);
	List<MdmBomVO> selectBomList(String prdtCode);
	int bomProcess(RequestVO<MdmBomVO> vo);
	
	// 도움말 작성
	int insertHelp(HelpVO vo);
	HelpVO selectHelp(HelpVO vo);
}
