package com.yedam.smartree.mdm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;
import com.yedam.smartree.mdm.service.PrdtVO;

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
	int addEmp(EmpVO vo);
	
	// 제품관리
	List<PrdtVO> selectPrdtList();
	PrdtVO selectPrdt(String prdtCode);
	List<PrdtVO> searchPrdt(PrdtVO vo);
	int insertPrdt(PrdtVO vo);
	int updatePrdt(PrdtVO vo); 
	int deletePrdt(String prdtCode);
}
