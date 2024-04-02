package com.oracle.erpProject.dao.mkdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.mkmodel.mkCustomer;
import com.oracle.erpProject.model.mkmodel.mkFactory;
import com.oracle.erpProject.model.mkmodel.mkProduct;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MK_DaoImpl implements MK_Dao_Interface {
	//Mybatis DB 연동 
	
	private final SqlSession session;
	
	// 제품 리스트 
	
	@Override
	public List<mkProduct> productList(mkProduct product) {
	
		List<mkProduct> productList = null;
		System.out.println("MK_Dao_Impl productList start...");
		
		try {
			productList=session.selectList("mkproductList", product);
			System.out.println("MKDaoImpl productList product.size()->"+productList.size());
		}catch (Exception e) {
			System.out.println("MKDaoImpl productList e.getMessage()->"+e.getMessage());
		}
		return productList;
	}

	// 제품 상세 
	@Override
	public mkProduct productDetail(mkProduct product) {
		
		mkProduct productDetail = null;
	
		System.out.println("MK_DAO_IMPL productDetail Start  ");
		System.out.println("MK_DAO_IMPL productDetail->"+ product);
		try { 
			productDetail = session.selectOne("mkproductDetail",product);
			System.out.println("MKDaoImpl productDetail ProductDetail->"+productDetail);
		}catch (Exception e) {
			System.out.println("MKDaoImpl productDetail e.getMessage()->"+e.getMessage());
		}
		return productDetail;
	}

	// 제품 총 cnt
	@Override
	public int totalProduct(mkProduct product) {
		int totProductCount=0;
		System.out.println("MK_DaoImpl Start totalProductCount");
		
		try { 
			totProductCount=session.selectOne("mktotProduct");
			System.out.println("MK_DaoImpl total Product Count->"+totProductCount);
			System.out.println("insert 성공");
		} catch (Exception e) {
			System.out.println("MK_DaoImpl total Product Exception->"+e.getMessage());
		}
		return totProductCount;
	}

	//제품 등록
	@Override
	public int insertProduct(mkProduct product) {
		int insertResult=0;
		System.out.println("MkDaoImpl insert Produt Start");
		System.out.println("MK_DaoImpl mkinsertProduct ->" +product);
		try {
			insertResult = session.insert("mkinsertProduct",product);
		}catch (Exception e) {
			System.out.println("MkDaoImpl insertProduct Exception->"+e.getMessage());
		}
		return insertResult;
	}
	
	
	//검색 결과에 대한 제품 cnt
	@Override
	public int searchedProductTotal(mkProduct product) {
		int totProductCount=0;
		System.out.println("MKDaoImpl start searchedProductTotal Start");
		System.out.println("MK DaoImpl Start mkProduct->"+product);
		
		try {
			totProductCount = session.selectOne("searchedProductTotal",product);
			System.out.println("MKServiceImpl totalsearchedProduct -> " + totProductCount);
		} catch (Exception e) {
			System.out.println("MKServiceImpl totProductCount Exception->"+e.getMessage());
		}
		return totProductCount;
	}

	// 검색 결과에 대한 list
	@Override
	public List<mkProduct> productSearchList(mkProduct product) {
		List<mkProduct> productSearchList = null;
		System.out.println("MKDaoImpl start productSearchList start");
		System.out.println("MKDaoImpl Start product->"+product);
		try { 
			productSearchList= session.selectList("productSearchList",product);
			
		}catch (Exception e) {
			System.out.println("MKDaoImpl productSearchList exception->"+ e.getMessage());
		}
		return productSearchList;
	}

	//제품 수정
	@Override
	public int UpdataProduct(mkProduct product) {
		int UpdateResult=0;
		System.out.println("MkDaoImpl UpdateResult Produt Start");
		System.out.println("MK_DaoImpl UpdateResult ->" +product);
		try {
			UpdateResult = session.update("mkupdateProduct",product);
		}catch (Exception e) {
			System.out.println("MkDaoImpl mkupdateProduct Exception->"+e.getMessage());
		}
		return UpdateResult;
	}

	@Override
	public int totalFactory(mkFactory factory) {
		int tolFactoryCount=0;
		System.out.println("MK_DaoImpl Start tolFactoryCount");
		
		try { 
			tolFactoryCount=session.selectOne("mktotFactory");
			System.out.println("MK_DaoImpl total Product Count->"+tolFactoryCount);
			System.out.println("insert 성공");
		} catch (Exception e) {
			System.out.println("MK_DaoImpl tolFactoryCountt Exception->"+e.getMessage());
		}
		return tolFactoryCount;
	}

	@Override
	public List<mkFactory> listFactory(mkFactory factory) {
		List<mkFactory> foctoryList = null;
		System.out.println("MK_Dao_Impl foctoryList start...");
		
		try {
			foctoryList=session.selectList("mkfactoryList", factory);
			System.out.println("MKDaoImpl foctoryList factory.size()->"+foctoryList.size());
		}catch (Exception e) {
			System.out.println("MKDaoImpl foctoryList e.getMessage()->"+e.getMessage());
		}
		return foctoryList;
	}

	@Override
	public mkFactory factoryDetail(mkFactory factory) {
		mkFactory factoryDetail = null;
		System.out.println("MKDaoImpl factoryDetail start");
		
		try {
			factoryDetail = session.selectOne("mkFactoryDetail", factory);
			System.out.println("MKDaoImpl factoryDetail ->"+ factoryDetail);
		} catch (Exception e) {
			System.out.println("MK Dao Impl factoryDetail exception->"+e.getMessage());
		}
		return factoryDetail;
	}

	@Override
	public int insertFactory(mkFactory factory) {
		int insertResult=0;
		System.out.println("MkDaoImpl insertFactory Start");
		System.out.println("MK_DaoImpl mkinsertProduct ->" +factory);
		try {
			insertResult = session.insert("mkinsertFactory",factory);
		}catch (Exception e) {
			System.out.println("MkDaoImpl insertFactory Exception->"+e.getMessage());
		}
		return insertResult;
	}

	@Override
	public int searchedFactoryTotal(mkFactory factory) {
		int searchFactoryResult=0;
		System.out.println("MKDaoImpl searchedFactoryTotal Start");
		System.out.println("MKDaoImpl ->"+factory);
		try {
			searchFactoryResult=session.selectOne("mksearchFactoryCnt");
			}catch (Exception e) {
				System.out.println("searchedFactoryTotal Exception ->"+ e.getMessage());
			}
		return searchFactoryResult;
	}

	@Override
	public List<mkFactory> listSearchFactory(mkFactory factory) {
		List<mkFactory> searcedFactory = null;
		System.out.println("MKDaoImpl listSearchFactory start");
		System.out.println("MKDaoImpl->"+factory);
		try {
			searcedFactory = session.selectList("mksearchFactoryList",factory);
			
		}catch (Exception e) {
			System.out.println("listSearchFactory exception->"+e.getMessage());
		}
		return searcedFactory;
	}

	@Override
	public int updateFactory(mkFactory factory) {
		int updateFactory =0;
		System.out.println("MKDaoImpl updateFactory Start");
		System.out.println("MKDaoImpl"+factory);
		try {
			updateFactory = session.update("mkupdateFactory", factory);
		}catch (Exception e) {
			System.out.println("MKDaoImpl updateFactory Exception ->" + e.getMessage());
		}
		return updateFactory;
	}

	@Override
	public int totalCustomer(mkCustomer customer) {
		int totalCustomer = 0;
		System.out.println("MKDaoImpl totalCustomer Start");
		System.out.println("MKDaoImpl totalCustomer->"+ customer);
		try {
			totalCustomer = session.selectOne("totalCustomer");
			
		}catch (Exception e) {
			System.out.println("MKDaoImpl totalCustomer Exception->" + e.getMessage());
		}
		return totalCustomer;
	}

	@Override
	public List<mkCustomer> listCustomer(mkCustomer customer) {
		List<mkCustomer> listCustomer = null;
		System.out.println("MKDaoImpl listCustomer Start");
		System.out.println("MKDaoImpl listCustomer->" +customer);
		try {
			listCustomer = session.selectList("mklistCustomer", customer);
		}catch (Exception e) {
			System.out.println("MKDaoImpl listCustomer Exception->"+ e.getMessage());
		}
		
		return listCustomer;
	}

	@Override
	public mkCustomer getCustomerDetail(mkCustomer customer) {
		System.out.println("MK Dao Impl getCustomerDetail Start");
		mkCustomer getCustomerDetail = null;
		try {
			getCustomerDetail=session.selectOne("mkgetCustomerDetail", customer);
			
		} catch (Exception e) {
			System.out.println("MK_DaoImol getCustomerDetail Exception->"+ e.getMessage());
		}
		return getCustomerDetail;
	}


		
	}


