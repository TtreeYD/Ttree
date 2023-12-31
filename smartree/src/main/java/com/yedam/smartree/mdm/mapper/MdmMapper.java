package com.yedam.smartree.mdm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;
import com.yedam.smartree.mdm.service.HelpVO;
import com.yedam.smartree.mdm.service.MdmBomVO;
import com.yedam.smartree.mdm.service.MdmBpVO;
import com.yedam.smartree.mdm.service.MdmChkVO;
import com.yedam.smartree.mdm.service.MdmMtlVO;
import com.yedam.smartree.mdm.service.MdmPrcsVO;
import com.yedam.smartree.mdm.service.MdmPrdtVO;

@Mapper
public interface MdmMapper {
	// 공통코드관리
	List<CommonCodeVO> selectCommonCode();
	List<CommonCodeVO> selectCodeDetail(String codeType);
	int insertCommonCode(CommonCodeVO commonCodeVO);
	int insertCodeDetail(CommonCodeVO commonCodeVO);
	int deleteCommonCode(CommonCodeVO commonCodeVO);
	int deleteCodeDetail(CommonCodeVO commonCodeVO);
	
	// 사원관리
	List<EmpVO> selectEmpList(@Param("empDept")String empDept, @Param("empName")String empName);
	List<EmpVO> selectUnusedEmp(EmpVO vo);
	int addEmp(EmpVO vo);
	EmpVO selectEmp(String id);
	int resetPw(EmpVO vo);
	int updatePassword(EmpVO vo);
	int delEmp(EmpVO vo);
	int unUseEmp(EmpVO vo);
	int upEmp(EmpVO vo);
	int reuseEmp(EmpVO vo);
	
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
	
	// 공정관리
	List<MdmPrcsVO> selectPrcsList();
	MdmPrcsVO selectPrcs(String prcsStdCode);
	List<MdmPrcsVO> searchPrcs(MdmPrcsVO vo);
	int insertPrcs(MdmPrcsVO vo);
	int updatePrcs(MdmPrcsVO vo); 
	int deletePrcs(String prcsStdCode);
	
	// 거래처관리
	List<MdmBpVO> selectBpList();
	MdmBpVO selectBp(String bpCode);
	List<MdmBpVO> searchBp(MdmBpVO vo);
	int insertBp(MdmBpVO vo);
	int updateBp(MdmBpVO vo);
	int deleteBp(String bpCode);
	
	// 품질검사관리
	List<MdmChkVO> selectChkList();
	MdmChkVO selectChk(String chkStdCode);
	List<MdmChkVO> searchChk(MdmChkVO vo);
	int insertChk(MdmChkVO vo);
	int updateChk(MdmChkVO vo); 
	int deleteChk(String chkStdCode);
	
	// BOM관리
	List<MdmBomVO> selectBomDetail(@Param("prdtCode")String prdtCode, @Param("bomCode")String bomCode);
	List<MdmBomVO> selectBomList(String prdtCode);
	int updateBom(MdmBomVO vo);
	int insertBom(MdmBomVO vo);
	int insertBomDt(MdmBomVO vo);
	int deleteBomDt(MdmBomVO vo);
	
	// 도움말 관리
	int insertHelp(HelpVO vo);
	int deleteHelp(HelpVO vo);
	HelpVO selectHelp(HelpVO vo);
	
}
