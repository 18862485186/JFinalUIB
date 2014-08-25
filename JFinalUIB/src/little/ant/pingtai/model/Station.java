package little.ant.pingtai.model;

import little.ant.pingtai.annotation.Table;
import little.ant.pingtai.common.DictKeys;
import little.ant.pingtai.thread.ThreadParamInit;

import org.apache.log4j.Logger;

import com.jfinal.plugin.ehcache.CacheKit;

@SuppressWarnings("unused")
@Table(tableName="pt_station")
public class Station extends BaseModel<Station> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Station.class);
	
	public static final Station dao = new Station();

	/**
	 * 添加或者更新缓存
	 */
	public void cacheAdd(String ids){
		CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_station + ids, Station.dao.findById(ids));
	}

	/**
	 * 删除缓存
	 */
	public void cacheRemove(String ids){
		CacheKit.remove(DictKeys.cache_name_system, ThreadParamInit.cacheStart_station + ids);
	}

	/**
	 * 获取缓存
	 * @param ids
	 * @return
	 */
	public Station cacheGet(String ids){
		Station station = CacheKit.get(DictKeys.cache_name_system, ThreadParamInit.cacheStart_station + ids);
		return station;
	}
	
}
