package little.ant.common.controller;

import little.ant.platform.annotation.Controller;
import little.ant.platform.controller.BaseController;
import little.ant.common.service.SensitiveWordService;
import little.ant.common.validator.SensitiveWordValidator;
import little.ant.common.model.SensitiveWord;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;

/**
 * XXX 管理	
 * 描述：
 * 
 * /jf/common/sensitiveWord
 * /jf/common/sensitiveWord/save
 * /jf/common/sensitiveWord/edit
 * /jf/common/sensitiveWord/update
 * /jf/common/sensitiveWord/view
 * /jf/common/sensitiveWord/delete
 * /common/sensitiveWord/add.html
 * 
 */
@Controller(controllerKey = "/jf/common/sensitiveWord")
public class SensitiveWordController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(SensitiveWordController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		SensitiveWordService.service.list(splitPage);
		render("/common/sensitiveWord/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(SensitiveWordValidator.class)
	public void save() {
		getModel(SensitiveWord.class).save();
		render("/common/sensitiveWord/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		SensitiveWord sensitiveWord = SensitiveWord.dao.findById(getPara());
		setAttr("sensitiveWord", sensitiveWord);
		render("/common/sensitiveWord/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(SensitiveWordValidator.class)
	public void update() {
		getModel(SensitiveWord.class).update();
		redirect("/jf/common/sensitiveWord");
	}

	/**
	 * 查看
	 */
	public void view() {
		SensitiveWord sensitiveWord = SensitiveWord.dao.findById(getPara());
		setAttr("sensitiveWord", sensitiveWord);
		render("/common/sensitiveWord/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		String param = (getPara() == null ? ids : getPara());
		SensitiveWordService.service.delete(param);
		redirect("/jf/common/sensitiveWord");
	}
	
}


