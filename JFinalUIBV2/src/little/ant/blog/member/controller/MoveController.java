package little.ant.blog.member.controller;

import little.ant.platform.annotation.Controller;
import little.ant.platform.controller.BaseController;
import little.ant.blog.member.service.MoveService;
import little.ant.blog.member.validator.MoveValidator;
import little.ant.blog.model.Move;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;

/**
 * XXX 管理	
 * 描述：
 * 
 * /jf/blog/member/move
 * /jf/blog/member/move/save
 * /jf/blog/member/move/edit
 * /jf/blog/member/move/update
 * /jf/blog/member/move/view
 * /jf/blog/member/move/delete
 * /common/move/add.html
 * 
 */
@Controller(controllerKey = "/jf/blog/member/move")
public class MoveController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MoveController.class);
	
	/**
	 * 列表
	 */
	public void index() {
		MoveService.service.list(splitPage);
		render("/blog/member/move/list.html");
	}
	
	/**
	 * 保存
	 */
	@Before(MoveValidator.class)
	public void save() {
		getModel(Move.class).save();
		render("/blog/member/move/add.html");
	}
	
	/**
	 * 准备更新
	 */
	public void edit() {
		Move move = Move.dao.findById(getPara());
		setAttr("move", move);
		render("/blog/member/move/update.html");
	}
	
	/**
	 * 更新
	 */
	@Before(MoveValidator.class)
	public void update() {
		getModel(Move.class).update();
		redirect("/jf/blog/member/move");
	}

	/**
	 * 查看
	 */
	public void view() {
		Move move = Move.dao.findById(getPara());
		setAttr("move", move);
		render("/blog/member/move/view.html");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		String param = (getPara() == null ? ids : getPara());
		MoveService.service.delete(param);
		redirect("/jf/blog/member/move");
	}
	
}


