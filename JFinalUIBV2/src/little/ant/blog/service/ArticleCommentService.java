package little.ant.blog.service;

import org.apache.log4j.Logger;

import little.ant.platform.service.BaseService;
import little.ant.platform.common.SplitPage;
import little.ant.platform.common.DictKeys;
import little.ant.blog.model.ArticleComment;

public class ArticleCommentService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ArticleCommentService.class);
	
	public static final ArticleCommentService service = new ArticleCommentService();
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		String select = " select * ";
		splitPageBase(DictKeys.db_dataSource_main, splitPage, select, "src.articleComment.splitPage");
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids){
		String[] idsArr = splitByComma(ids);
		for (String id : idsArr) {
			ArticleComment.dao.deleteById(id);
		}
	}
	
}
