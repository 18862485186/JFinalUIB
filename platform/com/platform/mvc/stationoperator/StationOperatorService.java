package com.platform.mvc.stationoperator;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.platform.annotation.Service;
import com.platform.constant.ConstantInit;
import com.platform.dto.SplitPage;
import com.platform.mvc.base.BaseService;
import com.platform.mvc.role.Role;

@Service(name = StationOperatorService.serviceName)
public class StationOperatorService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(StationOperatorService.class);
	
	public static final String serviceName = "stationOperatorService";

	/**
	 * 获取岗位拥有的功能
	 * @param stationIds
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void paging(SplitPage splitPage){
		paging(ConstantInit.db_dataSource_main, splitPage, StationOperator.sqlId_splitPageSelect, StationOperator.sqlId_splitPageFrom);
		
		String stationIds = (String) splitPage.getQueryParam().get("stationIds");
		
		Role role = Role.dao.findById(stationIds);
		splitPage.setExtData(role);
		
		String sql = getSql("platform.roleOperator.findByRoleIds");
		
		List<Record> smList = (List<Record>) splitPage.getList();
		for (Record sm : smList) {
			String mids = sm.getStr("mids");
			List<Record> olist = Db.find(sql, stationIds, mids);
			if(olist != null && olist.size() != 0){
				sm.set("list", olist);
			}else{
				smList.remove(sm);
			}
		}
	}

	/**
	 * 设置岗位拥有的功能
	 * @param stationIds
	 * @param operatorIds
	 * @return
	 */
	public String add(String stationIds, String operatorIds){
		StationOperator ro = new StationOperator();
		ro.setStationids(stationIds);
		ro.setOperatorids(operatorIds);
		ro.save();
		return ro.getPKValue();
	}
	
}
