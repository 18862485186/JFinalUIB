package little.ant.common.admin.service;

import little.ant.platform.annotation.MyTxProxy;
import little.ant.platform.common.ConstantPlatform;
import little.ant.platform.common.SplitPage;
import little.ant.platform.service.BaseService;

import org.apache.log4j.Logger;

public class AccessStatisticsService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(AccessStatisticsService.class);
	
	public static final AccessStatisticsService service = MyTxProxy.newProxy(AccessStatisticsService.class);
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		String select = " select * ";
		splitPageBase(ConstantPlatform.db_dataSource_main, splitPage, select, "common.accessStatistics.splitPage");
	}

}
