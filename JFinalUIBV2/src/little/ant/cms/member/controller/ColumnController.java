package little.ant.cms.member.controller;

import little.ant.platform.annotation.Controller;
import little.ant.platform.controller.BaseController;
import little.ant.cms.member.service.ColumnService;
import little.ant.cms.member.validator.ColumnValidator;
import little.ant.cms.model.Column;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;

/**
 * XXX 管理	
 * 描述：
 * 
 * /jf/cms/member/column
 * /jf/cms/member/column/save
 * /jf/cms/member/column/edit
 * /jf/cms/member/column/update
 * /jf/cms/member/column/view
 * /jf/cms/member/column/delete
 * /common/column/add.html
 * 
 */
@Controller(controllerKey = "/jf/cms/member/column")
public class ColumnController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ColumnController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		ColumnService.service.list(splitPage);
		render("/cms/member/column/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(ColumnValidator.class)
	public void save() {
		getModel(Column.class).save();
		render("/cms/member/column/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Column column = Column.dao.findById(getPara());
		setAttr("column", column);
		render("/cms/member/column/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(ColumnValidator.class)
	public void update() {
		getModel(Column.class).update();
		redirect("/jf/cms/member/column");
	}

	/**
	 * 查看
	 */
	public void view() {
		Column column = Column.dao.findById(getPara());
		setAttr("column", column);
		render("/cms/member/column/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		String param = (getPara() == null ? ids : getPara());
		ColumnService.service.delete(param);
		redirect("/jf/cms/member/column");
	}
	
}


