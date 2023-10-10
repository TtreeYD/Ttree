package com.yedam.smartree.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.material.mapper.MaterialMapper;
import com.yedam.smartree.material.service.MaterialService;
import com.yedam.smartree.material.service.MaterialVO;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialMapper materialMapper;
	
	// 발주목록 전체조회
	@Override
	public List<MaterialVO> selectNeedList() {
		return materialMapper.selectNeedList();
	}
	// 재고목록 전체조회
	@Override
	public List<MaterialVO> selectMtlList() {
		return materialMapper.selectMtlList();
	}
	// 발주관리 전체출력
	@Override
	public List<MaterialVO> controlNeedList() {
		return materialMapper.controlNeedList();
	}
	// 입고관리 전체출력
	@Override
	public List<MaterialVO> controlInList() {
		return materialMapper.controlInList();
	}
	// 안전재고 미달목록
	@Override
	public List<MaterialVO> selectMinusMtl() {
		return materialMapper.selectMinusMtl();
	}
	// 검사완료 자재목록
	@Override
	public List<MaterialVO> selectChkMtl() {
		return materialMapper.selectChkMtl();
	}
	
	// 발주관리 등록
	@Override
	public int insertNeedMtl(MaterialVO vo) {
		return materialMapper.insertNeedMtl(vo);
	}
	
	//발주관리 수정
	@Override
	public int updateNeedMtl(MaterialVO vo) {
		return materialMapper.updateNeedMtl(vo);
	}
	
	//발주관리 삭제
	@Override
	public int deleteNeedMtl(MaterialVO vo) {
		return materialMapper.deleteNeedMtl(vo);
	}
	
	//입고관리 등록
	@Override
	public int insertInMtl(MaterialVO vo) {
		return materialMapper.insertInMtl(vo);
	}
	
	//입고관리 수정
	@Override
	public int updateInMtl(MaterialVO vo) {
		return materialMapper.updateInMtl(vo);
	}
	
	//입고관리 삭제
	@Override
	public int deleteInMtl(MaterialVO vo) {
		return materialMapper.deleteInMtl(vo);
	}
	
	// 발주관리 단건조회
	@Override
	public List<MaterialVO> getNeedMtl(MaterialVO vo) {
		return materialMapper.getNeedMtl(vo);
	}
	
	//입고관리 단건조회
	@Override
	public List<MaterialVO> getInMtl(MaterialVO vo) {
		return materialMapper.getInMtl(vo);
	}
	// 재고조회 로트별 조회
	@Override
	public List<MaterialVO> getLotMtl(MaterialVO vo) {
		return materialMapper.getLotMtl(vo);
	}
	// 발주목록 발주서별 출력
	@Override
	public List<MaterialVO> getPaperMtl(MaterialVO vo) {
		return materialMapper.getPaperMtl(vo);
	}
	// 발주조회 조건검색
	@Override
	public List<MaterialVO> searchNeed(MaterialVO vo) {
		return materialMapper.searchNeed(vo);
	}
	// 재고조회 조건검색
	@Override
	public List<MaterialVO> searchCont(MaterialVO vo) {
		return materialMapper.searchCont(vo);
	}
	// 출고조회 - 오른쪽
	@Override
	public List<MaterialVO> selectMtlOutList(MaterialVO vo) {
		return materialMapper.selectMtlOutList(vo);
	}
	// 출고조회 - 왼쪽
	@Override
	public List<MaterialVO> MtlOutList() {
		return materialMapper.MtlOutList();
	}
	// 출고조회 - 검색기능
	@Override
	public List<MaterialVO> searchOut(MaterialVO vo) {
		return materialMapper.searchOut(vo);
	}

}
