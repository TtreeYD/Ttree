package com.yedam.smartree.mdm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;

@Mapper
public interface MdmMapper {
	public List<CommonCodeVO> selectCommonCodeList(int codeType);
	public List<EmpVO> selectEmpList(String empDept);
}
