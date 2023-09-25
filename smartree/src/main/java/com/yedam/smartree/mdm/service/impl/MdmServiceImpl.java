package com.yedam.smartree.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.mdm.mapper.MdmMapper;
import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;
import com.yedam.smartree.mdm.service.MdmBomDtVO;
import com.yedam.smartree.mdm.service.MdmBpVO;
import com.yedam.smartree.mdm.service.MdmChkVO;
import com.yedam.smartree.mdm.service.MdmMtlVO;
import com.yedam.smartree.mdm.service.MdmPrcsVO;
import com.yedam.smartree.mdm.service.MdmPrdtVO;
import com.yedam.smartree.mdm.service.MdmService;

@Service
public class MdmServiceImpl implements MdmService {

	@Autowired
	MdmMapper mdmMapper;
	
	// 공통코드
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

	// 사원관리
	@Override
	public List<EmpVO> selectEmpList(String empDept, String empName) {
		return mdmMapper.selectEmpList(empDept,empName);
	}
	
	@Override
	public int addEmp(EmpVO vo) {
		return mdmMapper.addEmp(vo);
	}
	
	// 제품관리
	@Override
	public List<MdmPrdtVO> selectPrdtList() {
		return mdmMapper.selectPrdtList();
	}

	@Override
	public int insertPrdt(MdmPrdtVO vo) {
		return mdmMapper.insertPrdt(vo);
	}

	@Override
	public int updatePrdt(MdmPrdtVO vo) {
		return mdmMapper.updatePrdt(vo);
	}
	

	@Override
	public MdmPrdtVO selectPrdt(String prdtCode) {
		return mdmMapper.selectPrdt(prdtCode);
	}
	
	@Override
	public int deletePrdt(String prdtCode) {
		return mdmMapper.deletePrdt(prdtCode);
	}

	@Override
	public List<MdmPrdtVO> searchPrdt(MdmPrdtVO vo) {
		return mdmMapper.searchPrdt(vo);
	}

	// 자재관리
	@Override
	public List<MdmMtlVO> selectMtlList() {
		return mdmMapper.selectMtlList();
	}

	@Override
	public int insertMtl(MdmMtlVO vo) {
		return mdmMapper.insertMtl(vo);
	}

	@Override
	public int updateMtl(MdmMtlVO vo) {
		return mdmMapper.updateMtl(vo);
	}

	@Override
	public MdmMtlVO selectMtl(String mtlCode) {
		return mdmMapper.selectMtl(mtlCode);
	}
	
	@Override
	public int deleteMtl(String mtlCode) {
		return mdmMapper.deleteMtl(mtlCode);
	}

	@Override
	public List<MdmMtlVO> searchMtl(MdmMtlVO vo) {
		return mdmMapper.searchMtl(vo);
	}
	
	// 거래처관리
	@Override
	public List<MdmBpVO> selectBpList() {
		return mdmMapper.selectBpList();
	}

	@Override
	public int insertBp(MdmBpVO vo) {
		return mdmMapper.insertBp(vo);
	}

	@Override
	public int updateBp(MdmBpVO vo) {
		return mdmMapper.updateBp(vo);
	}

	@Override
	public MdmBpVO selectBp(String bpCode) {
		return mdmMapper.selectBp(bpCode);
	}
	
	@Override
	public int deleteBp(String bpCode) {
		return mdmMapper.deleteBp(bpCode);
	}

	@Override
	public List<MdmBpVO> searchBp(MdmBpVO vo) {
		return mdmMapper.searchBp(vo);
	}
	
	// 공정관리
	@Override
	public List<MdmPrcsVO> selectPrcsList() {
		return mdmMapper.selectPrcsList();
	}

	@Override
	public int insertPrcs(MdmPrcsVO vo) {
		return mdmMapper.insertPrcs(vo);
	}

	@Override
	public int updatePrcs(MdmPrcsVO vo) {
		return mdmMapper.updatePrcs(vo);
	}

	@Override
	public MdmPrcsVO selectPrcs(String prcsStdCode) {
		return mdmMapper.selectPrcs(prcsStdCode);
	}
	
	@Override
	public int deletePrcs(String prcsStdCode) {
		return mdmMapper.deletePrcs(prcsStdCode);
	}

	@Override
	public List<MdmPrcsVO> searchPrcs(MdmPrcsVO vo) {
		return mdmMapper.searchPrcs(vo);
	}
	
	// 품질검사관리
	@Override
	public List<MdmChkVO> selectChkList() {
		return mdmMapper.selectChkList();
	}

	@Override
	public int insertChk(MdmChkVO vo) {
		return mdmMapper.insertChk(vo);
	}

	@Override
	public int updateChk(MdmChkVO vo) {
		return mdmMapper.updateChk(vo);
	}

	@Override
	public MdmChkVO selectChk(String chkStdCode) {
		return mdmMapper.selectChk(chkStdCode);
	}
	
	@Override
	public int deleteChk(String chkStdCode) {
		return mdmMapper.deleteChk(chkStdCode);
	}

	@Override
	public List<MdmChkVO> searchChk(MdmChkVO vo) {
		return mdmMapper.searchChk(vo);
	}

	@Override
	public List<MdmBomDtVO> selectBomDetail(String prdtCode) {
		return mdmMapper.selectBomDetail(prdtCode);
	}

}
