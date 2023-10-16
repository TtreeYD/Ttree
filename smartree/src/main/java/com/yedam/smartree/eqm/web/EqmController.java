package com.yedam.smartree.eqm.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.smartree.eqm.service.EqmInspService;
import com.yedam.smartree.eqm.service.EqmInspVO;
import com.yedam.smartree.eqm.service.EqmNoperVO;
import com.yedam.smartree.eqm.service.EqmService;
import com.yedam.smartree.eqm.service.EqmVO;

/*
  개발자  : 이승준
  개발일자 : 2023/09/14
           설비조회,설비점검조회 
  */

@Controller
@RequestMapping("/eqm")
public class EqmController {

	@Value("${file.upload.path}")
	private String uploadPath;

	@Autowired
	EqmService eqmservice;

	@Autowired
	EqmInspService eqminspservice;

	// 설비 전체 조회
	@GetMapping("/eqmList")
	public String selectAllEqm() {

		return "eqm/eqmList";
	}

	// 설비 점검 전체 조회
	@GetMapping("/eqmInspList")
	public String selectAllEqmInsp() {
		return "eqm/eqmInspList";
	}

	// 설비 등록 - 페이지
	@GetMapping("/eqmForm")
	public String registerEqmForm() {
		//model.addAttribute("eqmVO", new EqmVO());
		return "eqm/eqmForm";
	}

	// 설비 등록 - 등록, 수정
	@PostMapping("/eqmForm")
	public String registerEqmProcess(MultipartFile file, EqmVO eqmVO, RedirectAttributes attributes) {

		// 파일업로드

		// 파일명 가져오기
		String originalName = file.getOriginalFilename();
		String fileName = originalName.substring(originalName.lastIndexOf("//") + 1);

		// 파일명 변경없으면 변화없게 하기위해서(update)
		if (!fileName.equals("")) {

			// 날짜 폴더 생성
			String folderPath = makeFolder();

			// 유니크한 이름 때문에
			String uuid = UUID.randomUUID().toString();
			String uploadFileName = folderPath + "/" + uuid + "_" + fileName;
			eqmVO.setEqmImg(uploadFileName);

			// uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
			String saveName = uploadPath + "/" + uploadFileName;
			Path savePath = Paths.get(saveName);
			try {
				file.transferTo(savePath); // 파일의 핵심
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// eqmcode 없으면 등록 / 있으면 수정
		if (eqmVO.getEqmCode().equals("")) {
			eqmservice.insertEqm(eqmVO);
		} else {
			eqmservice.updateEqm(eqmVO);
		}

		// ?eqmCode= 안보이게 /
		attributes.addFlashAttribute("eqmCode", eqmVO.getEqmCode());
		return "redirect:eqmForm";
	}

	// 설비 수정 - 폼
	/*
	 * @GetMapping("/eqmUpdate") public String updateEqm(EqmVO eqmVO, Model model) {
	 * EqmVO findEqm = eqmservice.selectEqm(eqmVO); model.addAttribute("eqmInfo",
	 * findEqm); return "eqm/eqmForm"; }
	 */
	// 설비 수정 - 처리
	/*
	 * @PostMapping("/eqmUpdate") public String updateEqmProcess(EqmVO eqmVO) {
	 * 
	 * eqmservice.updateEqm(eqmVO); return "redirect:eqmForm"; }
	 */

	// 비가동 페이지
	@GetMapping("/eqmNoperForm")
	public String EqmNoperForm() {
		// model.addAttribute("eqmInspVO", new EqmInspVO());
		return "eqm/eqmNoperForm";
	}
	// 비가동 등록
	@PostMapping("/eqmNoperForm")
	@ResponseBody
	public String registerEqmNoperFormProcess(@RequestBody EqmNoperVO eqmNoperVO ) {
		eqminspservice.insertEqmNoper(eqmNoperVO);
		
		// 비가동 등록 시작		
		 String eqmCode = eqmNoperVO.getEqmCode(); 
		 String emqState = "S"; 
		 EqmVO eqmvo= new EqmVO();
		 eqmvo.setEqmCode(eqmCode); 
		 eqmvo.setEqmState(emqState);
		 eqmservice.updateEqm(eqmvo);
		 
		//
		
		return "redirect:eqmNoperForm";

	}
	// 비가동 수정
	@PostMapping("/updateEqmNoper")
	@ResponseBody
	public String updateEqmNoper(@RequestBody EqmNoperVO eqmNoperVO) {
		eqminspservice.updateEqmNoper(eqmNoperVO);
		
		// 등록사유가 기타('n')일때는 사용가능 
		if(eqmNoperVO.getReasonKnd().equals("n")) {
			 String eqmCode = eqmNoperVO.getEqmCode(); 
			 String emqState = "Y"; 
			 EqmVO eqmvo= new EqmVO();
			 eqmvo.setEqmCode(eqmCode); 
			 eqmvo.setEqmState(emqState);
			 eqmservice.updateEqm(eqmvo);
			 
			String noperCode = eqmNoperVO.getNoperCode();				
	        String inspIcheck = "Y"; 
			EqmNoperVO eqmnopervo = new EqmNoperVO();
		    eqmnopervo.setNoperCode(noperCode);
			eqmnopervo.setInspIcheck(inspIcheck);
		    eqminspservice.updateEqmNoper(eqmnopervo);
				 
		}else {
				// 비가동 등록 끝
		 String eqmCode = eqmNoperVO.getEqmCode(); 
		 String emqState = "E"; 
		 EqmVO eqmvo= new EqmVO();
		 eqmvo.setEqmCode(eqmCode); 
		 eqmvo.setEqmState(emqState);
		 eqmservice.updateEqm(eqmvo);
		//
		}
		
		
	
		return "redirect:eqmNoperForm";
	}
	
	
	// 설비 점검 등록 - 페이지
	@GetMapping("/eqmInspForm")
	public String registerEqmInspForm() {
		// model.addAttribute("eqmInspVO", new EqmInspVO());
		return "eqm/eqmInspForm";
	}

	// 설비 점검 등록 - 등록
	@PostMapping("/eqmInspForm")
	public String registerEqmInspFormProcess(EqmInspVO eqmInspVO, RedirectAttributes attributes) {
		eqminspservice.insertEqmInsp(eqmInspVO);
		//
		if(!eqmInspVO.getNoperCode().equals("")) {
			// 설비상태를 사용가능으로 바꾼다
			 String eqmCode = eqmInspVO.getEqmCode(); 
			 String emqState = "Y"; 
			 EqmVO eqmvo= new EqmVO();
			 //
				/*
				 * String eqmUcheck ="N"; if(eqmInspVO.getInspJudg().equals("N")) {
				 * eqmvo.setEqmUcheck(eqmUcheck); }
				 */
			 //
			 eqmvo.setEqmCode(eqmCode); 
			 eqmvo.setEqmState(emqState);
			 eqmservice.updateEqm(eqmvo);
			 // 비가동 -> 설비점검에 등록
			 String noperCode =eqmInspVO.getNoperCode();
			 String inspIcheck = "Y";
			 EqmNoperVO eqmnopervo = new EqmNoperVO();
			 eqmnopervo.setNoperCode(noperCode);
			 eqmnopervo.setInspIcheck(inspIcheck);
			 eqminspservice.updateEqmNoper(eqmnopervo);
		}	
		//
		attributes.addFlashAttribute("eqmCode", eqmInspVO.getEqmCode());
		attributes.addFlashAttribute("inspCode", eqmInspVO.getInspCode());
		return "redirect:eqmInspForm";
	}

	/////////////////////////////////////

	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")); // 경로에서 사용하는 /는 인지 못함
		// LocalDate를 문자열로 포멧
		String folderPath = str;// .replace("/", File.separator); // <- 그래서 separator 사용
		File uploadPathFoler = new File(uploadPath, folderPath);
		// File newFile= new File(dir,"파일명");
		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}

	// 이미지 보여주기
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {
		File file = new File(uploadPath + fileName);
		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();

			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 파일 업로드 처리
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}

}
