package spring.mvc.spring_pj_ict05.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.spring_pj_ict05.dao.ProductDAO;
import spring.mvc.spring_pj_ict05.dto.ProductDTO;
import spring.mvc.spring_pj_ict05.page.Paging;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO dao;
	
	// 상품 등록
	@Override
	public void productAddAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" <<< ProductServiceImpl - productAddAction()  >>>");
		
		MultipartFile file = request.getFile("pdImg");
		
		// input 경로 - 폴더 먼저 생성 후에 작성
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/");
		System.out.println(saveDir);
		// upload 폴더 우클릭 > properties > loaction 정보 복붙 > 맨 뒤에 upload \\ 추가
		String realDir="D:\\DEV05\\workspace_spring_ict05\\spring_pj_ict05\\src\\main\\webapp\\resources\\upload\\";
		System.out.println(realDir);
		
		// io에 있음
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			
			file.transferTo(new File(saveDir + file.getOriginalFilename()));	// import java.io.File
			fis = new FileInputStream(saveDir + file.getOriginalFilename());
			fos = new FileOutputStream(realDir + file.getOriginalFilename());
			
			int date = 0;
			while((date = fis.read()) != -1) {	// 값이 존재하면 
				fos.write(date);
			}
			
			// 3단계. 화면에서 입력받은 값 가져와, DTO에 담기
			ProductDTO dto = new ProductDTO();
			dto.setPdBrand(request.getParameter("pdBrand"));
			dto.setPdName(request.getParameter("pdName"));
			
			String p_img1 = "/spring_pj_ict05/resources/upload/" + file.getOriginalFilename();
			System.out.println("p_img1 : " + p_img1 );
			
			dto.setPdImg(p_img1);
			
			dto.setPdCategory(request.getParameter("pdCategory"));
			dto.setPdContent(request.getParameter("pdContent"));
			dto.setPdPrice(Integer.parseInt(request.getParameter("pdPrice")));
			dto.setPdQuantity(Integer.parseInt(request.getParameter("pdQuantity")));
			dto.setPdStatus(request.getParameter("pdStatus"));
			
			// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용  => @Autowired로 대체
			
			// 5단계. 상품 등록 insert
			int insertCnt = dao.productInsert(dto);
			
			// 6단계. jsp로 처리 결과 전달
			model.addAttribute("insertCnt", insertCnt);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) fis.close();
			if(fos != null) fos.close();
		}
		
		
		
	}

	// 상품 목록
	@Override
	public void productListAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" <<< ProductServiceImpl - productListAction()  >>>");
		
		// 3단계. 화면에서 입력받은 값 가져와, DTO에 담기
		String pageNum = request.getParameter("pageNum");
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용  => @Autowired로 대체
		
		// 5-1단계. 상품 갯수
		int total = dao.productCnt();
		System.out.println("상품갯수total : "+total);
		
		// 5-2단계. 상품 목록
		Paging paging = new Paging(pageNum);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		// Hash 맵 생성 후 추가
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		List<ProductDTO> list = dao.productList(map);
		
		// 6단계. jsp로 처리 결과 전달
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}

	// 상품 상세 페이지
	@Override
	public void productDetailAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" <<< ProductServiceImpl - productDetailAction()  >>>");

	}

	// 상품 수정
	@Override
	public void productUpdateAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" <<< ProductServiceImpl - productUpdateAction()  >>>");

	}

	// 상품 삭제
	@Override
	public void productDeleteAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" <<< ProductServiceImpl - productDeleteAction()  >>>");

	}

}
