package little.ant.blog.service;

import org.apache.log4j.Logger;

import little.ant.platform.service.BaseService;
import little.ant.platform.common.SplitPage;
import little.ant.platform.common.DictKeys;
import little.ant.blog.model.NewsDeliver;

public class NewsDeliverService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(NewsDeliverService.class);
	
	public static final NewsDeliverService service = new NewsDeliverService();
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		String select = " select * ";
		splitPageBase(DictKeys.db_dataSource_main, splitPage, select, "blog.newsDeliver.splitPage");
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids){
		String[] idsArr = splitByComma(ids);
		for (String id : idsArr) {
			NewsDeliver.dao.deleteById(id);
		}
	}
	
}
