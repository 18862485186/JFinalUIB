package little.ant.cms.service;

import org.apache.log4j.Logger;

import little.ant.platform.service.BaseService;
import little.ant.platform.common.SplitPage;
import little.ant.platform.common.DictKeys;
import little.ant.cms.model.Vote;

public class VoteService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(VoteService.class);
	
	public static final VoteService service = new VoteService();
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		String select = " select * ";
		splitPageBase(DictKeys.db_dataSource_main, splitPage, select, "cms.vote.splitPage");
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
