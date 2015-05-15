package little.ant.common.admin.validator;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import little.ant.common.model.Location;

public class LocationValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(LocationValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/common/admin/location/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/common/admin/location/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Location.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/common/admin/location/save")){
			controller.render("/common/admin/xxx.html");
		
		} else if (actionKey.equals("/jf/common/admin/location/update")){
			controller.render("/common/admin/xxx.html");
		
		}
	}
	
}
