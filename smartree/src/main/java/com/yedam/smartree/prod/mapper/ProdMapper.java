package com.yedam.smartree.prod.mapper;

import java.util.List;

import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.mdm.service.MdmPrcsVO;
import com.yedam.smartree.prod.service.HoldingVO;
import com.yedam.smartree.prod.service.MtlNeedVO;
import com.yedam.smartree.prod.service.PrcsResultVO;
import com.yedam.smartree.prod.service.PrdtProdVO;
import com.yedam.smartree.prod.service.ProdVO;

public interface ProdMapper {
	
	public List<ProdVO> selectProdList();
	
	List<ProdVO> selectDtPlanList(ProdVO vo);
	
	public List<BusinessVO> selectAllOrderAndPrdt();
	
	public List<ProdVO> selectProd(ProdVO vo);
	
	public int insertProdPlan(ProdVO vo);
	
	public int insertDtProdPlan(ProdVO vo);
	
	public List<ProdVO> searchProdPlan(ProdVO vo);
	
	public List<ProdVO> selectProdListView(ProdVO vo);
	
	public int updateProd(ProdVO vo);
	
	public int updateDtProd(ProdVO vo);
	
	public int updateProdInst(ProdVO vo);
	
	public int updateDtProdInst(ProdVO vo);
	
	public int deleteProd(ProdVO vo);
	
	public int deleteDtProd(ProdVO vo);
	
	public void insertAndUpdateDtProd(ProdVO vo);
	
	public List<PrdtProdVO> selectPrdt(PrdtProdVO vo);
	
	public List<ProdVO> selectGetProd(ProdVO vo);
	
	public int insertProdInst(ProdVO vo);
	
	public int insertDtProdInst(ProdVO vo);
	
	public List<ProdVO> selectProdInst(ProdVO vo);
	
	public List<ProdVO> selectGetProdInst(ProdVO vo);
	
	public int deleteProdInst(ProdVO vo);
	
	public int deleteDtProdInst(ProdVO vo);
	
	int updateInstYn(String prodPlanCode);
	
	List<ProdVO> selectDtInstList(ProdVO vo);
	
	//생산지시조회
	public List<ProdVO> selectGetDtInst(ProdVO vo);
	//키오스크 :생산지시불러오기
	public List<ProdVO> selectGetProcess(ProdVO vo);

	public int insertProcess(ProdVO pvo);
	public int updateProcess(ProdVO pvo);

	public List<MdmPrcsVO> selectPrcsCode(ProdVO vo);
	
	// 자재 요구량 계산
	public List<MtlNeedVO> getMtlNeed(ProdVO vo);
	//공정흐름상세보기
	public List<ProdVO> getProcess(ProdVO vo);

	
	// 실적조회
	List<PrcsResultVO> selectPrcsResult(PrcsResultVO vo);

	
	

	//생산시작버튼클릭(공정실적관리 insert)
	public int insertDtProgress(ProdVO prodVO);
	//설비 상태 변경
	public int updateEqmState(ProdVO vo);

	
	//자재홀딩
	int insertHolding(ProdVO vo);
	List<HoldingVO> selectHolding(String prodInstCode);

	//생산종료List
	public List<ProdVO> getProcessResult(ProdVO vo);

	//생산종료Process - update Eqm
	public int updateEqm(ProdVO prodVO);
	int updateProcessResult(ProdVO vo);

	public int updateInst(ProdVO vo);

	int delHolding(String prodInstCode);
	
	int delProcess(ProdVO vo);

	public List<ProdVO> getChartData();


}
