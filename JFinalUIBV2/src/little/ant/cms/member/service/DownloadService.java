package little.ant.cms.member.service;

import com.jfinal.aop.Enhancer;
import com.jfinal.plugin.activerecord.tx.Tx;

import little.ant.platform.service.BaseService;

import org.apache.log4j.Logger;

public class DownloadService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(DownloadService.class);
	
	public static final DownloadService service = Enhancer.enhance(DownloadService.class, Tx.class);
	
}
