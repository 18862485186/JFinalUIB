package little.ant.cms.service;

import org.apache.log4j.Logger;

import little.ant.platform.service.BaseService;
import little.ant.platform.common.SplitPage;
import little.ant.platform.common.DictKeys;
import little.ant.cms.model.Template;

public class TemplateService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(TemplateService.class);
	
	public static final TemplateService service = new TemplateService();
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		String select = " select * ";
		splitPageBase(DictKeys.db_dataSource_main, splitPage, select, "src.template.splitPage");
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids){
		String[] idsArr = splitByComma(ids);
		for (String id : idsArr) {
			Template.dao.deleteById(id);
		}
	}
	
}
