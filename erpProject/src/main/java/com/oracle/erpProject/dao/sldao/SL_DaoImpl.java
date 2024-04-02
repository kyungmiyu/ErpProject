package com.oracle.erpProject.dao.sldao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.model.Buying;

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
	public List<Buying> buyAlllist(Buying buying) {
		System.out.println("SL_DaoImpl buyAlllist Start ->>>>>>");
		
		List<Buying> buyAlllist = session.selectList("LslbuyAlllist", buying);
		
		System.out.println("SL_DaoImpl buyAlllist ->>>>>>" + buyAlllist );
		
		return buyAlllist;
	}

	
	
	@Override
	public int dateSearchtotCnt(Buying buying) {
		System.out.println("SL_DaoImpl dateSearchtotCnt Start ->>>>>>");
		
		
		int dateSearchtotCnt = session.selectOne("LsldateSearchtotCnt", buying);
	
		
		return dateSearchtotCnt;
	}

	
	@Override
	public List<Buying> dateSearchAllList(Buying buying) {
		System.out.println("SL_DaoImpl dateSearchAllList Start ->>>>>>");
		System.out.println("SL_DaoImpl dateSearchAllList buying ->"+buying);
		System.out.println("SL_DaoImpl dateSearchAllList getBuy_date ->"+buying.getBuy_date());
		
		List<Buying> dateSearchAllList = session.selectList("LsldateSearchAllList",buying);
		System.out.println("SL_DaoImpl dateSearchAllList dateSearchAllList.size() ->>>>>>"+dateSearchAllList.size());
		
		return dateSearchAllList;
	}

	@Override
	public Buying buyingDetail(Buying buying) {
		System.out.println("SL_DaoImpl buyingDetail Start ->>>>>>");
		
		Buying buyingDetail = session.selectOne("LslbuyingDetail",buying);
		
		
		return buyingDetail;
	}

	
	@Override
	public List<Buying> productDetail(Buying buying) {
		System.out.println("SL_DaoImpl productDetail Start ->>>>>>");
		
		List<Buying> productDetail = session.selectList("LSlproductDetail", buying);
		
		return productDetail;
	}
	
	
	
}
