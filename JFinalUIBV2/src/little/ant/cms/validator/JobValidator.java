package little.ant.cms.validator;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import little.ant.cms.model.Job;

public class JobValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(JobValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/cms/job/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/cms/job/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Job.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/cms/job/save")){
			controller.render("/cms/xxx.html");
		
		} else if (actionKey.equals("/jf/cms/job/update")){
			controller.render("/cms/xxx.html");
		
		}
	}
	
}
