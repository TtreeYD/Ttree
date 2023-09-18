package com.yedam.smartree.mdm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;

@Mapper
public interface MdmMapper {
	// 공통코드관리
	public List<CommonCodeVO> selectCommonCode();
	public List<CommonCodeVO> selectCodeDetail(String codeType);
	public int insertCommonCode(CommonCodeVO commonCodeVO);
	public int insertCodeDetail(CommonCodeVO commonCodeVO);
	public int deleteCommonCode(CommonCodeVO commonCodeVO);
	public int deleteCodeDetail(CommonCodeVO commonCodeVO);
	
	// 사원관리
	public List<EmpVO> selectEmpList(@Param("empDept")String empDept, @Param("empName")String empName);
	public int addEmp(EmpVO vo);
}
