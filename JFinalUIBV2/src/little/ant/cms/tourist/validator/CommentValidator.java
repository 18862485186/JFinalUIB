package little.ant.cms.tourist.validator;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import little.ant.cms.model.Comment;

public class CommentValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(CommentValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/cms/tourist/comment/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/cms/tourist/comment/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Comment.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/cms/tourist/comment/save")){
			controller.render("/cms/tourist/xxx.html");
		
		} else if (actionKey.equals("/jf/cms/tourist/comment/update")){
			controller.render("/cms/tourist/xxx.html");
		
		}
	}
	
}
