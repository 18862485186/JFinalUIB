package little.ant.platform.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import little.ant.platform.annotation.Table;
import little.ant.platform.common.DictKeys;
import little.ant.platform.thread.ThreadParamInit;
import little.ant.platform.tools.ToolSqlXml;

import org.apache.log4j.Logger;

import com.jfinal.plugin.ehcache.CacheKit;

/**
 * 参数model
 * @author 董华健
 */
@SuppressWarnings("unused")
@Table(dataSourceName = DictKeys.db_dataSource_main, tableName = "pt_param")
public class Param extends BaseModel<Param> {
	
	private static final long serialVersionUID = 2051998642258015518L;

	private static Logger log = Logger.getLogger(Param.class);
	
	public static final Param dao = new Param();

	/**
	 * 主键
	 */
	public static final String colunm_ids = "ids";
	
	/**
	 * 版本号
	 */
	public static final String colunm_version = "version";
	
	/**
	 * 描述
	 */
	public static final String colunm_description = "description";
	
	/**
	 * 图标
	 */
	public static final String colunm_images = "images";
	
	/**
	 * 名称
	 */
	public static final String colunm_names = "names";
	
	/**
	 * 排序号
	 */
	public static final String colunm_orderids = "orderids";
	
	/**
	 * tree路径
	 */
	public static final String colunm_paths = "paths";
	
	/**
	 * 状态
	 */
	public static final String colunm_zhuangtai = "zhuangtai";
	
	/**
	 * 上级ids
	 */
	public static final String colunm_parentids = "parentids";
	
	/**
	 * 是否上级节点
	 */
	public static final String colunm_isparent = "isparent";
	
	/**
	 * 层级级别
	 */
	public static final String colunm_levels = "levels";
	
	/**
	 * 编号
	 */
	public static final String colunm_numbers = "numbers";
	
	/**
	 * 值
	 */
	public static final String colunm_val = "val";
	
	/**
	 * 是否国际化 : 0否1是
	 */
	public static final String colunm_i18n = "i18n";
	
	/**
	 * 中文简体值
	 */
	public static final String colunm_val_zhcn = "val_zhcn";
	
	/**
	 * 中文香港值
	 */
	public static final String colunm_val_zhhk = "val_zhhk";
	
	/**
	 * 中文台湾值
	 */
	public static final String colunm_val_zhtw = "val_zhtw";
	
	/**
	 * 日文值
	 */
	public static final String colunm_val_ja = "val_ja";
	
	/**
	 * 英文值
	 */
	public static final String colunm_val_enus = "val_enus";
	
	/**
	 * 账号状态
	 */
	public static final String colunm_status = "status";
	
	/**
	 * 根据主键查询参数，带国际化
	 * @param ids 主键
	 * @param i18n 国际化参数
	 * @return
	 */
	public Param getByIds(String ids, String i18n){
		String val = "val" + i18n(i18n);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("val", val);
		
		String sql = getSqlByBeetl("platform.param.idAndI18n", paramMap);
		
		Param param = dao.findFirst(sql, ids);
		return param;
	}
	
	/**
	 * 根据编号查询参数
	 * @param number
	 * @return
	 */
	public Param getByNumber(String number){
		String sql = getSql("platform.param.numbers");
		Param param = dao.findFirst(sql, number);
		return param;
	}
	
	/**
	 * 根据编号查询参数，带国际化
	 * @param number 编号
	 * @param i18n 国际化参数
	 * @return
	 */
	public Param getByNumber(String number, String i18n){
		String val = "val" + i18n(i18n);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("val", val);
		
		String sql = getSqlByBeetl("platform.param.numbersAndI18n", paramMap);
		
		Param param = dao.findFirst(sql, number);
		return param;
	}

	/**
	 * 查询子节点参数
	 * @return
	 */
	public List<Param> getChild(){
		String sql = getSql("platform.param.child");
		return dao.find(sql, getPKValue());
	}

	/**
	 * 查询子节点参数
	 * @param prentIds
	 * @return
	 */
	public List<Param> getChild(String prentIds){
		String sql = getSql("platform.param.child");
		return dao.find(sql, prentIds);
	}

	/**
	 * 查询子节点参数，国际化
	 * @param prentIds
	 * @param i18n
	 * @return
	 */
	public List<Param> getChild(String prentIds, String i18n){
		String val = "val" + i18n(i18n);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("val", val);
		
		String sql = getSqlByBeetl("platform.param.childAndI8n", param);
		
		return dao.find(sql, prentIds);
	}

	/**
	 * 查询父节点参数
	 * @return
	 */
	public Param getParent(){
		String sql = getSql("platform.param.parent");
		return dao.findFirst(sql, get("parentids"));
	}

	/**
	 * 查询父节点参数，国际化
	 * @param i18n
	 * @return
	 */
	public Param getParent(String i18n){
		String val = "val" + i18n(i18n);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("val", val);
		
		String sql = getSqlByBeetl("platform..parentAndI18n", param);
		
		return dao.findFirst(sql, get("parentids"));
	}

	/**
	 * 添加或者更新缓存
	 */
	public void cacheAdd(String ids){
		Param param = Param.dao.findById(ids);
		List<Param> paramList = param.getChild();
		CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param + ids, param);
		CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param + param.getStr("numbers"), param);
		CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + ids, paramList);
		CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + param.getStr("numbers"), paramList);
		
		String paramIds = param.getStr("parentids");
		if(null != paramIds){
			Param parent = Param.dao.findById(param.getStr("parentids"));
			if(null != parent){
				List<Param> parentList = parent.getChild();
				CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + parent.getPKValue(), parentList);
				CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + parent.getStr("numbers"), parentList);
			}
		}
	}

	/**
	 * 删除缓存
	 * @param ids
	 */
	public void cacheRemove(String ids){
		Param param = Param.dao.findById(ids);
		CacheKit.remove(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param + ids);
		CacheKit.remove(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param + param.getStr("numbers"));
		CacheKit.remove(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + ids);
		CacheKit.remove(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + param.getStr("numbers"));

		String paramIds = param.getStr("parentids");
		if(null != paramIds){
			Param parent = Param.dao.findById(param.getStr("parentids"));
			if(null != parent){
				List<Param> parentList = parent.getChild();
				CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + parent.getPKValue(), parentList);
				CacheKit.put(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + parent.getStr("numbers"), parentList);
			}
		}
	}

	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	public Param cacheGet(String key){
		Param param = CacheKit.get(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param + key);
		return param;
	}
	
	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	public List<Param> cacheGetChild(String key){
		List<Param> paramList = CacheKit.get(DictKeys.cache_name_system, ThreadParamInit.cacheStart_param_child + key);
		return paramList;
	}
	
}
