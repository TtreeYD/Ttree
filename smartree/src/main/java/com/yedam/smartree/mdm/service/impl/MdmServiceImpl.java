package com.yedam.smartree.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.mdm.mapper.MdmMapper;
import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;
import com.yedam.smartree.mdm.service.MdmService;
import com.yedam.smartree.mdm.service.PrdtVO;

@Service
public class MdmServiceImpl implements MdmService {

	@Autowired
	MdmMapper mdmMapper;
	
	@Override
	public List<CommonCodeVO> selectCommonCode() {
		// TODO Auto-generated method stub
		return mdmMapper.selectCommonCode();
	}
	
	@Override
	public List<CommonCodeVO> selectCodeDetail(String codeType) {
		return mdmMapper.selectCodeDetail(codeType);
	}

	@Override
	public List<EmpVO> selectEmpList(String empDept, String empName) {
		return mdmMapper.selectEmpList(empDept,empName);
	}

	@Override
	public int insertCommonCode(CommonCodeVO commonCodeVO) {
		return mdmMapper.insertCommonCode(commonCodeVO);
	}

	@Override
	public int insertCodeDetail(CommonCodeVO commonCodeVO) {
		return mdmMapper.insertCodeDetail(commonCodeVO);
	}

	@Override
	public int deleteCommonCode(CommonCodeVO commonCodeVO) {
		return mdmMapper.deleteCommonCode(commonCodeVO);
	}
	
	@Override
	public int deleteCodeDetail(CommonCodeVO commonCodeVO) {
		return mdmMapper.deleteCodeDetail(commonCodeVO);
	}

	@Override
	public int addEmp(EmpVO vo) {
		return mdmMapper.addEmp(vo);
	}

	@Override
	public List<PrdtVO> selectPrdtList() {
		return mdmMapper.selectPrdtList();
	}

	@Override
	public int insertPrdt(PrdtVO vo) {
		return mdmMapper.insertPrdt(vo);
	}

	@Override
	public int updatePrdt(PrdtVO vo) {
		return mdmMapper.updatePrdt(vo);
	}

	@Override
	public PrdtVO selectPrdt(String prdtCode) {
		return mdmMapper.selectPrdt(prdtCode);
	}
	
	@Override
	public int deletePrdt(String prdtCode) {
		return mdmMapper.deletePrdt(prdtCode);
	}

	@Override
	public List<PrdtVO> searchPrdt(PrdtVO vo) {
		return mdmMapper.searchPrdt(vo);
	}

}
