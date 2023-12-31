package com.yedam.smartree.mdm.web;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


/*
 	개발자 : 정현철
  	개발일자 : 2023/09/14
  	기준정보관리 페이지 조회
*/

@Controller
@RequestMapping("/mdm")
public class CommonContorller {
	
	@Value("${file.upload.path}")
	private String uploadPath;
	
	// 공통코드관리 페이지
	@GetMapping("/commonCode")
	public String commonCodeManage() {
		return "mdm/commonCode";
	}
	
	// 사원관리 페이지
	@GetMapping("/emp")
	public String empList() {
		return "mdm/emp";
	}
	
	// 자재관리 페이지
	@GetMapping("/mtl")
	public String mtlManage() {
		return "mdm/mtl";
	}
	
	// 제품관리 페이지
	@GetMapping("/prdt")
	public String prodManage() {
		return "mdm/prdt";
	}
	
	// 공정기준 페이지
	@GetMapping("/prcs")
	public String prcsManage() {
		return "mdm/prcs";
	}
	
	// 거래처 관리 페이지
	@GetMapping("/bp")
	public String bpManage() {
		return "mdm/bp";
	}
	
	// bom관리 페이지
	@GetMapping("/bom")
	public String bomManage() {
		return "mdm/bom";
	}
	
	// 품질기준관리 페이지
	@GetMapping("/chkStd")
	public String chkStdManage() {
		return "mdm/chkStd";
	}
	
	// 도움말 등록페이지
	@GetMapping("/help")
	public String helpManage() {
		return "mdm/help";
	}
	
	@PostMapping("/upload")
	public ModelAndView image(MultipartHttpServletRequest request) throws Exception {
    
		// ckeditor는 이미지 업로드 후 이미지 표시하기 위해 uploaded 와 url을 json 형식으로 받아야 함
		// modelandview를 사용하여 json 형식으로 보내기위해 모델앤뷰 생성자 매개변수로 jsonView 라고 써줌
		// jsonView 라고 쓴다고 무조건 json 형식으로 가는건 아니고 @Configuration 어노테이션을 단 
		// WebConfig 파일에 MappingJackson2JsonView 객체를 리턴하는 jsonView 매서드를 만들어서 bean으로 등록해야 함 
		ModelAndView mav = new ModelAndView("jsonView");

		// ckeditor 에서 파일을 보낼 때 upload : [파일] 형식으로 해서 넘어오기 때문에 upload라는 키의 밸류를 받아서 uploadFile에 저장함
		MultipartFile uploadFile = request.getFile("upload");

		// 파일의 오리지널 네임
		String originalFileName = uploadFile.getOriginalFilename();
		
        // 파일의 확장자
		String ext = originalFileName.substring(originalFileName.indexOf("."));
		
        // 서버에 저장될 때 중복된 파일 이름인 경우를 방지하기 위해 UUID에 확장자를 붙여 새로운 파일 이름을 생성
		String newFileName = UUID.randomUUID() + ext;

		// 이미지를 현재 경로와 연관된 파일에 저장하기 위해 현재 경로를 알아냄
		
		File uploadPathFolder = new File(uploadPath, "image");
		
		if (uploadPathFolder.exists() == false) {
			uploadPathFolder.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		
		// 현재경로/upload/파일명이 저장 경로
		String savePath = uploadPathFolder+ "/" + newFileName;

		// 브라우저에서 이미지 불러올 때 절대 경로로 불러오면 보안의 위험 있어 상대경로를 쓰거나 이미지 불러오는 jsp 또는 클래스 파일을 만들어 가져오는 식으로 우회해야 함
		// 때문에 savePath와 별개로 상대 경로인 uploadPath 만들어줌
		String uploadPath = "/eqm/display?fileName=/image/" + newFileName; 

		// 파일 업로드
		Path filePath = Paths.get(savePath);
		uploadFile.transferTo(filePath);

		// uploaded, url 값을 modelandview를 통해 보냄
		mav.addObject("uploaded", true); // 업로드 완료
		mav.addObject("url", uploadPath); // 업로드 파일의 경로
		System.out.println(mav);
		return mav;
	}
	
}

