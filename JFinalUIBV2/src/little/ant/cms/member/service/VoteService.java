package little.ant.cms.member.service;

import org.apache.log4j.Logger;

import little.ant.platform.annotation.MyTxProxy;
import little.ant.platform.service.BaseService;
import little.ant.platform.dto.SplitPage;
import little.ant.platform.constant.ConstantInit;
import little.ant.cms.model.Vote;

public class VoteService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(VoteService.class);
	
	public static final VoteService service = MyTxProxy.newProxy(VoteService.class);
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		String select = " select * ";
		splitPageBase(ConstantInit.db_dataSource_main, splitPage, select, "src.vote.splitPage");
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids){
		String[] idsArr = splitByComma(ids);
		for (String id : idsArr) {
			Vote.dao.deleteById(id);
		}
	}
	
}
