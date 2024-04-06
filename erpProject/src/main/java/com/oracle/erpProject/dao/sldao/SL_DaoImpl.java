package com.oracle.erpProject.dao.sldao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.slmodel.SLBuying;
import com.oracle.erpProject.model.slmodel.SLBuying_detail;
import com.oracle.erpProject.model.slmodel.SLProduct;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SL_DaoImpl implements SL_Dao_Interface{

	private final SqlSession session;

	@Override
	public int totalbuyingCnt() {
		int totalbuyingCnt = session.selectOne("LsltotalbuyingCnt");
		return totalbuyingCnt;
	}

	@Override
	public List<SLBuying> buyAlllist(SLBuying buying) {
		System.out.println("SL_DaoImpl buyAlllist Start ->>>>>>");
		
		List<SLBuying> buyAlllist = session.selectList("LslbuyAlllist", buying);
		
		
		System.out.println("SL_DaoImpl buyAlllist ->>>>>>" + buyAlllist );
		
		return buyAlllist;
	}

	
	
	@Override
	public int dateSearchtotCnt(SLBuying buying) {
		System.out.println("SL_DaoImpl dateSearchtotCnt Start ->>>>>>");
		
		
		int dateSearchtotCnt = session.selectOne("LsldateSearchtotCnt", buying);
	
		
		return dateSearchtotCnt;
	}

	
	@Override
	public List<SLBuying> dateSearchAllList(SLBuying buying) {
		System.out.println("SL_DaoImpl dateSearchAllList Start ->>>>>>");
		System.out.println("SL_DaoImpl dateSearchAllList buying ->"+buying);
		System.out.println("SL_DaoImpl dateSearchAllList getBuy_date ->"+buying.getBuy_date());
		
		List<SLBuying> dateSearchAllList = session.selectList("LsldateSearchAllList",buying);
		System.out.println("SL_DaoImpl dateSearchAllList dateSearchAllList.size() ->>>>>>"+dateSearchAllList.size());
		
		return dateSearchAllList;
	}

	@Override
	public SLBuying buyingDetail(SLBuying buying) {
		System.out.println("SL_DaoImpl buyingDetail Start ->>>>>>");
		
		SLBuying buyingDetail = session.selectOne("LslbuyingDetail",buying);
		
		
		return buyingDetail;
	}


	@Override
	public List<SLBuying> productDetail(SLBuying buying) {
		System.out.println("SL_DaoImpl productDetail Start  kkk ->>>>>>");
		System.out.println("SL_DaoImpl productDetail Start  buying->"+buying);
		// 전체 품목 Get 
		List<SLBuying> productDetail = session.selectList("LslproductDetail", buying);
		
		return productDetail;
	}

	// 제품 리스트
	@Override
	public List<SLProduct> productList() {
		System.out.println("SL_DaoImpl productList  kkk ->>>>>>");

		List<SLProduct> productList = session.selectList("LslproductList");
		System.out.println("SL_DaoImpl productList  ㅎㅎㅎ ->>>>>>" +productList);
		
		return productList;
	}


	@Override
	public List<SLBuying_detail> getProductList(SLBuying_detail slBuying_detail) {
		
		List<SLBuying_detail> getProductList = session.selectList("LslgetProductList",slBuying_detail);
		return getProductList;
	}

	
	@Override
	public int deleteProduct(SLBuying_detail sLBuying_detail) {
		
		int deleteProduct = session.delete("LsldeleteProduct", sLBuying_detail);
		
		return deleteProduct;
	}

	@Override
	public int buyingModify(SLBuying buying) {
		int buyingModify = session.update("LslbuyingModify",buying);
		System.out.println("buyingModify buyingModify->"+buyingModify);
		return buyingModify;
	}
	
	@Override
	public int addProduct(SLBuying_detail slBuying_detail) {
		System.out.println("SL_DaoImpl addProduct Start ->>>>>>");
		System.out.println("SL_DaoImpl addProduct slBuying_detail ->"+slBuying_detail);
		int addProduct = session.insert("LsladdProduct", slBuying_detail);
		return addProduct;
	}

	@Override
	public int productCntModify(SLBuying_detail sLBuying_detail) {
		int productCntModify = session.update("LslproductCntModify",sLBuying_detail);
		
		return productCntModify;
	}

	@Override
	public int buyStatusChange(SLBuying buying) {
		int buyStatusChange = session.update("LslbuyStatusChange", buying);
		
		return buyStatusChange;
	}

	@Override
	public SLBuying customerSearch(SLBuying buying) {
		SLBuying customerSearch = session.selectOne("LslcustomerSearch",buying);
		
		System.out.println("customerSearch >>>>>>>>" +customerSearch);
		return customerSearch;
	}

	@Override
	public List<SLBuying> getManagerList(SLBuying buying) {
		
		List<SLBuying> getManagerList = session.selectList("LslgetManagerList", buying);
		System.out.println("getManagerList getManagerList >>>>>>" + getManagerList);
		
		
		return getManagerList;
	}
	
	@Override
	public int buyingApplyWrite(SLBuying buying) {
		
		System.out.println("buyingApplyWrite SLBuying >>>>>>" + buying);
		
		int buyingApplyWrite = session.insert("LslbuyingApplyWrite", buying);
		
		return buyingApplyWrite;
	}
	

	@Override
	public int buyingApplyAddDetail(SLBuying buying) {
		int buyingApplyAddDetail = session.insert("LslbuyingApplyAddDetail", buying);
		return buyingApplyAddDetail;
	}
	
	
	
}
