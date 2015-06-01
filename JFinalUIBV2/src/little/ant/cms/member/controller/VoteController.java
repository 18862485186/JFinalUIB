package little.ant.cms.member.controller;

import little.ant.platform.annotation.Controller;
import little.ant.platform.controller.BaseController;
import little.ant.cms.member.service.VoteService;
import little.ant.cms.member.validator.VoteValidator;
import little.ant.cms.model.Vote;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;

/**
 * XXX 管理	
 * 描述：
 * 
 * /jf/cms/member/vote
 * /jf/cms/member/vote/save
 * /jf/cms/member/vote/edit
 * /jf/cms/member/vote/update
 * /jf/cms/member/vote/view
 * /jf/cms/member/vote/delete
 * /common/vote/add.html
 * 
 */
@Controller(controllerKey = "/jf/cms/member/vote")
public class VoteController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(VoteController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		VoteService.service.list(splitPage);
		render("/cms/member/vote/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(VoteValidator.class)
	public void save() {
		getModel(Vote.class).save();
		render("/cms/member/vote/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Vote vote = Vote.dao.findById(getPara());
		setAttr("vote", vote);
		render("/cms/member/vote/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(VoteValidator.class)
	public void update() {
		getModel(Vote.class).update();
		redirect("/jf/cms/member/vote");
	}

	/**
	 * 查看
	 */
	public void view() {
		Vote vote = Vote.dao.findById(getPara());
		setAttr("vote", vote);
		render("/cms/member/vote/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		String param = (getPara() == null ? ids : getPara());
		VoteService.service.delete(param);
		redirect("/jf/cms/member/vote");
	}
	
}


