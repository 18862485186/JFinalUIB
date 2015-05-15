package little.ant.blog.admin.service;

import org.apache.log4j.Logger;

import little.ant.platform.service.BaseService;
import little.ant.platform.common.SplitPage;
import little.ant.platform.common.ConstantPlatform;
import little.ant.blog.model.Circleuser;

public class CircleuserService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(CircleuserService.class);
	
	public static final CircleuserService service = new CircleuserService();
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		String select = " select * ";
		splitPageBase(ConstantPlatform.db_dataSource_main, splitPage, select, "blog.circleuser.splitPage");
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids){
		String[] idsArr = splitByComma(ids);
		for (String id : idsArr) {
			Circleuser.dao.deleteById(id);
		}
	}
	
}
