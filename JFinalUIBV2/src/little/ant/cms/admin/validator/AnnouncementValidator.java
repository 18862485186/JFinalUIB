package little.ant.cms.admin.validator;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import little.ant.cms.model.Announcement;

public class AnnouncementValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(AnnouncementValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/cms/admin/announcement/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/cms/admin/announcement/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Announcement.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/cms/admin/announcement/save")){
			controller.render("/cms/admin/xxx.html");
		
		} else if (actionKey.equals("/jf/cms/admin/announcement/update")){
			controller.render("/cms/admin/xxx.html");
		
		}
	}
	
}
