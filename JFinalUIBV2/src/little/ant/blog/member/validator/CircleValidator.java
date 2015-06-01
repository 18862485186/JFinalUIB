package little.ant.blog.member.validator;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import little.ant.blog.model.Circle;

public class CircleValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(CircleValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/blog/member/circle/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/blog/member/circle/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Circle.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/blog/member/circle/save")){
			controller.render("/blog/member/xxx.html");
		
		} else if (actionKey.equals("/jf/blog/member/circle/update")){
			controller.render("/blog/member/xxx.html");
		
		}
	}
	
}
