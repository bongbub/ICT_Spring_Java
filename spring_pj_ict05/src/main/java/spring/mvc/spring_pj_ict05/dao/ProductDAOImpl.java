package spring.mvc.spring_pj_ict05.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SqlSession sqlSession;
	
	// 상품 등록
	@Override
	public int productInsert(ProductDTO dto) {
		System.out.println("ProductDAOImpl - productInsert");
		int insertCnt = sqlSession.insert("spring.mvc.spring_pj_ict05.dao.ProductDAO.productInsert", dto);
		return insertCnt;
	}

	// 상품 갯수
	@Override
	public int productCnt() {
		System.out.println("ProductDAOImpl - productCnt");
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.ProductDAO.productCnt");
		return selectCnt;
	}

	// 상품 목록
	@Override
	public List<ProductDTO> productList(Map<String, Object> map) {
		System.out.println("ProductDAOImpl - productList");
		List<ProductDTO> list = sqlSession.selectList("spring.mvc.spring_pj_ict05.dao.ProductDAO.productList", map);
		return list;
	}

	// 상품 상세 페이지
	@Override
	public ProductDTO productDetail(int pdNo) {
		System.out.println("ProductDAOImpl - productDetail");
		return null;
	}

	// 상품 수정
	@Override
	public int productUpdate(ProductDTO dto) {
		System.out.println("ProductDAOImpl - productUpdate");
		return 0;
	}

	// 상품 삭제
	@Override
	public int productDelete(int pdNo) {
		System.out.println("ProductDAOImpl - productDelete");
		return 0;
	}

}
