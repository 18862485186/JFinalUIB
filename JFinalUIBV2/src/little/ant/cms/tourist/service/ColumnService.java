package little.ant.cms.tourist.service;

import little.ant.platform.service.BaseService;

import org.apache.log4j.Logger;

import com.jfinal.aop.Enhancer;
import com.jfinal.plugin.activerecord.tx.Tx;

public class ColumnService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ColumnService.class);
	
	public static final ColumnService service = Enhancer.enhance(ColumnService.class, Tx.class);
	
}
