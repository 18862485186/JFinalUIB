package little.ant.cms.service;

import org.apache.log4j.Logger;

import little.ant.platform.service.BaseService;
import little.ant.platform.common.SplitPage;
import little.ant.platform.common.ConstantPlatform;
import little.ant.cms.model.Questions;

public class QuestionsService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(QuestionsService.class);
	
	public static final QuestionsService service = new QuestionsService();
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		String select = " select * ";
		splitPageBase(ConstantPlatform.db_dataSource_main, splitPage, select, "cms.questions.splitPage");
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids){
		String[] idsArr = splitByComma(ids);
		for (String id : idsArr) {
			Questions.dao.deleteById(id);
		}
	}
	
}
