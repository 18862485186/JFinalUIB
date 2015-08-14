package little.ant.platform.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import little.ant.platform.annotation.Table;
import little.ant.platform.constant.ConstantCache;
import little.ant.platform.constant.ConstantInit;
import little.ant.platform.plugin.ParamInitPlugin;

import org.apache.log4j.Logger;

import com.jfinal.plugin.ehcache.CacheKit;

/**
 * 字典model
 * @author 董华健
 */
@SuppressWarnings("unused")
@Table(tableName = "pt_dict")
public class Dict extends BaseModelCache<Dict> {
	
	private static final long serialVersionUID = 2051998642258015518L;

	private static Logger log = Logger.getLogger(Dict.class);
	
	public static final Dict dao = new Dict();

	/**
	 * 字段描述：主键 
	 * 字段类型 ：character varying 
	 */
	public static final String column_ids = "ids";
	
	/**
	 * 字段描述：版本号 
	 * 字段类型 ：bigint 
	 */
	public static final String column_version = "version";
	
	/**
	 * 字段描述：描述 
	 * 字段类型 ：character varying 
	 */
	public static final String column_description = "description";
	
	/**
	 * 字段描述：图标 
	 * 字段类型 ：character varying 
	 */
	public static final String column_images = "images";
	
	/**
	 * 字段描述：名称 
	 * 字段类型 ：character varying 
	 */
	public static final String column_names = "names";
	
	/**
	 * 字段描述：排序号 
	 * 字段类型 ：bigint 
	 */
	public static final String column_orderids = "orderids";
	
	/**
	 * 字段描述：tree路径 
	 * 字段类型 ：character varying 
	 */
	public static final String column_paths = "paths";
	
	/**
	 * 字段描述：状态 
	 * 字段类型 ：character 
	 */
	public static final String column_zhuangtai = "zhuangtai";
	
	/**
	 * 字段描述：上级ids 
	 * 字段类型 ：character varying 
	 */
	public static final String column_parentids = "parentids";
	
	/**
	 * 字段描述：是否上级节点 
	 * 字段类型 ：character varying 
	 */
	public static final String column_isparent = "isparent";
	
	/**
	 * 字段描述：层级级别 
	 * 字段类型 ：bigint 
	 */
	public static final String column_levels = "levels";
	
	/**
	 * 字段描述：编号 
	 * 字段类型 ：character varying 
	 */
	public static final String column_numbers = "numbers";
	
	/**
	 * 字段描述：值 
	 * 字段类型 ：character varying 
	 */
	public static final String column_val = "val";
	
	/**
	 * 字段描述：是否国际化 : 0否1是 
	 * 字段类型 ：character 
	 */
	public static final String column_i18n = "i18n";
	
	/**
	 * 字段描述：中文简体值 
	 * 字段类型 ：character varying 
	 */
	public static final String column_val_zhcn = "val_zhcn";
	
	/**
	 * 字段描述：中文香港值 
	 * 字段类型 ：character varying 
	 */
	public static final String column_val_zhhk = "val_zhhk";
	
	/**
	 * 字段描述：中文台湾值 
	 * 字段类型 ：character varying 
	 */
	public static final String column_val_zhtw = "val_zhtw";
	
	/**
	 * 字段描述：日文值 
	 * 字段类型 ：character varying 
	 */
	public static final String column_val_ja = "val_ja";
	
	/**
	 * 字段描述：英文值 
	 * 字段类型 ：character varying 
	 */
	public static final String column_val_enus = "val_enus";
	
	/**
	 * 字段描述：账号状态 
	 * 字段类型 ：character 
	 */
	public static final String column_status = "status";

	/**
	 * sqlId : platform.dict.all
	 * 描述：查询所有字典
	 */
	public static final String sqlId_all = "platform.dict.all";

	/**
	 * sqlId : platform.dict.treeTableNodeRoot
	 * 描述：查询字典树根节点
	 */
	public static final String sqlId_treeTableNodeRoot = "platform.dict.treeTableNodeRoot";

	/**
	 * sqlId : platform.dict.treeTableChildNode
	 * 描述：查询字典树子节点
	 */
	public static final String sqlId_treeTableChildNode = "platform.dict.treeTableChildNode";

	/**
	 * sqlId : platform.dict.treeNodeRoot
	 * 描述：查询字典树根节点
	 */
	public static final String sqlId_treeNodeRoot = "platform.dict.treeNodeRoot";

	/**
	 * sqlId : platform.dict.treeChildNode
	 * 描述：查询字典树子节点
	 */
	public static final String sqlId_treeChildNode = "platform.dict.treeChildNode";

	/**
	 * sqlId : platform.dict.idAndI18n
	 * 描述：根据id查询国际化字典值
	 */
	public static final String sqlId_idAndI18n = "platform.dict.idAndI18n";

	/**
	 * sqlId : platform.dict.numbers
	 * 描述：根据编号查询字典值
	 */
	public static final String sqlId_numbers = "platform.dict.numbers";

	/**
	 * sqlId : platform.dict.numbersAndI18n
	 * 描述：根据编号查询国际化字典值
	 */
	public static final String sqlId_numbersAndI18n = "platform.dict.numbersAndI18n";

	/**
	 * sqlId : platform.dict.child
	 * 描述：查询子节点字典值
	 */
	public static final String sqlId_child = "platform.dict.child";

	/**
	 * sqlId : platform.dict.childAndI8n
	 * 描述：查询子节点国际化字典值
	 */
	public static final String sqlId_childAndI8n = "platform.dict.childAndI8n";

	/**
	 * sqlId : platform.dict.parent
	 * 描述：查询父节点字典值
	 */
	public static final String sqlId_parent = "platform.dict.parent";

	/**
	 * sqlId : platform.dict.parentAndI18n
	 * 描述：查询父节点国际化字典值
	 */
	public static final String sqlId_parentAndI18n = "platform.dict.parentAndI18n";

	/**
	 * sqlId : platform.dict.childCount
	 * 描述：查询子节点数量
	 */
	public static final String sqlId_childCount = "platform.dict.childCount";
	
	/**
	 * 根据主键查询字典，带国际化
	 * @param ids 主键
	 * @param i18n 国际化参数
	 * @return
	 */
	public Dict getByIds(String ids, String i18n){
		String val = "val" + i18n(i18n);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("val", val);
		
		String sql = getSqlByBeetl(sqlId_idAndI18n, param);
		
		Dict dict = dao.findFirst(sql, ids);
		
		return dict;
	}
	
	/**
	 * 根据编号查询字典
	 * @param number
	 * @return
	 */
	public Dict getByNumber(String number){
		String sql = getSql(sqlId_numbers);
		Dict dict = dao.findFirst(sql, number);
		return dict;
	}
	
	/**
	 * 根据编号查询字典，带国际化
	 * @param number 编号
	 * @param i18n 国际化参数
	 * @return
	 */
	public Dict getByNumber(String number, String i18n){
		String val = "val" + i18n(i18n);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("val", val);
		
		String sql = getSqlByBeetl(sqlId_numbersAndI18n, param);
		
		Dict dict = dao.findFirst(sql, number);
		
		return dict;
	}

	/**
	 * 查询子节点字典
	 * @return
	 */
	public List<Dict> getChild(){
		String sql = getSql(sqlId_child);
		return dao.find(sql, getPKValue());
	}

	/**
	 * 查询子节点字典
	 * @param prentIds
	 * @return
	 */
	public List<Dict> getChild(String prentIds){
		String sql = getSql(sqlId_child);
		return dao.find(sql, prentIds);
	}

	/**
	 * 查询子节点字典，国际化
	 * @param prentIds
	 * @param i18n
	 * @return
	 */
	public List<Dict> getChild(String prentIds, String i18n){
		String val = "val" + i18n(i18n);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("val", val);
		
		String sql = getSqlByBeetl(sqlId_childAndI8n, param);
		
		return dao.find(sql, prentIds);
	}

	/**
	 * 查询父节点字典
	 * @return
	 */
	public Dict getParent(){
		String sql = getSql(sqlId_parent);
		return dao.findFirst(sql, get(column_parentids));
	}

	/**
	 * 查询父节点字典，国际化
	 * @param i18n
	 * @return
	 */
	public Dict getParent(String i18n){
		String val = "val" + i18n(i18n);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("val", val);
		
		String sql = getSqlByBeetl(sqlId_parentAndI18n, param);
		
		return dao.findFirst(sql, get(column_parentids));
	}

	/**
	 * 添加或者更新缓存
	 */
	public void cacheAdd(String ids){
		Dict dict = Dict.dao.findById(ids);
		List<Dict> dictList = dict.getChild();
		CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict + ids, dict);
		CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict + dict.getStr(column_numbers), dict);
		CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + ids, dictList);
		CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + dict.getStr(column_numbers), dictList);

		String parentIds = dict.getStr("parentids");
		if(null != parentIds){
			Dict parent = Dict.dao.findById(parentIds);
			if(null != parent){
				List<Dict> parentList = parent.getChild();
				CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + parent.getPKValue(), parentList);
				CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + parent.getStr(column_numbers), parentList);
			}
		}
	}

	/**
	 * 删除缓存
	 * @param ids
	 */
	public void cacheRemove(String ids){
		Dict dict = Dict.dao.findById(ids);
		
		CacheKit.remove(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict + ids);
		CacheKit.remove(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict + dict.getStr(column_numbers));
		CacheKit.remove(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + ids);
		CacheKit.remove(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + dict.getStr(column_numbers));

		String parentIds = dict.getStr("parentids");
		if(null != parentIds){
			Dict parent = Dict.dao.findById(parentIds);
			if(null != parent){
				List<Dict> parentList = parent.getChild();
				CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + parent.getPKValue(), parentList);
				CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + parent.getStr(column_numbers), parentList);
			}
		}
	}

	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	public Dict cacheGet(String key){
		Dict dict = CacheKit.get(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict + key);
		return dict;
	}
	
	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	public List<Dict> cacheGetChild(String key){
		List<Dict> dictList = CacheKit.get(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_dict_child + key);
		return dictList;
	}
	
}
