package little.ant.cms.member.service;

import little.ant.platform.annotation.MyTxProxy;
import little.ant.platform.service.BaseService;

import org.apache.log4j.Logger;

public class ColumnService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ColumnService.class);
	
	public static final ColumnService service = MyTxProxy.newProxy(ColumnService.class);
	
}
