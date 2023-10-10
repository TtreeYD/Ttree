package com.yedam.smartree.material.service;

import java.util.List;

public interface MaterialService {
	// 1. <전체조회들> 시작
	
	// 발주목록 전체조회
	public List<MaterialVO> selectNeedList();
	// 재고목록 전체조회
	public List<MaterialVO> selectMtlList();
	// 발주관리 전체출력
	public List<MaterialVO> controlNeedList();
	// 안전재고 미달목록 출력
	public List<MaterialVO> selectMinusMtl();
	// 입고관리 전체출력
	public List<MaterialVO> controlInList();
	// 입고관리 검사완료목록 출력
	public List<MaterialVO> selectChkMtl();
	// 출고자재 조회-왼쪽
	public List<MaterialVO> MtlOutList();
	// <전체조회들> 끝
	
	// 2. <검색 및 단건조회들> 시작
	
	// 발주관리 검색모달 조회
	public List<MaterialVO> getNeedMtl(MaterialVO vo);
	// 입고관리 검색모달 조회
	public List<MaterialVO> getInMtl(MaterialVO vo);
	// 재고조회 로트별 출력
	public List<MaterialVO> getLotMtl(MaterialVO vo);
	// 발주조회 발주서별 출력
	public List<MaterialVO> getPaperMtl(MaterialVO vo);
	// 발주조회 조건검색
	public List<MaterialVO> searchNeed(MaterialVO vo);
	// 재고조회 조건검색
	public List<MaterialVO> searchCont(MaterialVO vo);
	// 출고조회 자재별 출력
	public List<MaterialVO> selectMtlOutList(MaterialVO vo);
	// 출고조회 조건검색
	public List<MaterialVO> searchOut(MaterialVO vo);
	// <검색 및 단건조회들> 끝
	
	
	// 3. <CUD 기능들> 시작
	// 발주관리 발주기능
	public int insertNeedMtl(MaterialVO vo);
	// 발주관리 수정기능
	public int updateNeedMtl(MaterialVO vo);
	// 발주관리 삭제기능
	public int deleteNeedMtl(MaterialVO vo);
	
	
	// 입고관리 입고기능
	public int insertInMtl(MaterialVO vo);
	// 입고관리 수정기능
	public int updateInMtl(MaterialVO vo);
	// 입고관리 삭제기능
	public int deleteInMtl(MaterialVO vo);
	// <CUD 기능들> 끝
	
}
