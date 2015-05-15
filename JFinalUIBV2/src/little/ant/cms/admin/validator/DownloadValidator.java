package little.ant.cms.admin.validator;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import little.ant.cms.model.Download;

public class DownloadValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(DownloadValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/cms/admin/download/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/cms/admin/download/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Download.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/cms/admin/download/save")){
			controller.render("/cms/admin/xxx.html");
		
		} else if (actionKey.equals("/jf/cms/admin/download/update")){
			controller.render("/cms/admin/xxx.html");
		
		}
	}
	
}
