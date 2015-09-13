package com.platform.mvc.role;

import org.apache.log4j.Logger;

import com.jfinal.plugin.ehcache.CacheKit;
import com.platform.annotation.Table;
import com.platform.constant.ConstantCache;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModelCache;
import com.platform.plugin.ParamInitPlugin;

/**
 * 角色model
 * @author 董华健
 */
@SuppressWarnings("unused")
//@Table(tableName = "pt_role")
public class Role extends BaseModelCache<Role> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Role.class);
	
	public static final Role dao = new Role();

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
	 * 字段描述：名称 
	 * 字段类型 ：character varying 
	 */
	public static final String column_names = "names";
	
	/**
	 * 字段描述：拥有的功能ids 
	 * 字段类型 ：text 
	 */
	public static final String column_operatorids = "operatorids";
	
	/**
	 * 字段描述：拥有的功能模块ids 
	 * 字段类型 ：text 
	 */
	public static final String column_moduleids = "moduleids";
	
	/**
	 * 字段描述：编号 
	 * 字段类型 ：character varying 
	 */
	public static final String column_numbers = "numbers";

	/**
	 * sqlId : platform.role.all
	 * 描述：查询所有角色
	 */
	public static final String sqlId_all = "platform.role.all";

	/**
	 * sqlId : platform.role.noCheckedFilter
	 * 描述：
	 */
	public static final String sqlId_noCheckedFilter = "platform.role.noCheckedFilter";

	/**
	 * sqlId : platform.role.checkedFilter
	 * 描述：
	 */
	public static final String sqlId_checkedFilter = "platform.role.checkedFilter";

	/**
	 * sqlId : platform.role.noChecked
	 * 描述：
	 */
	public static final String sqlId_noChecked = "platform.role.noChecked";

	/**
	 * sqlId : platform.role.splitPageSelect
	 * 描述：分页Select
	 */
	public static final String sqlId_splitPage_select = "platform.role.splitPageSelect";

	/**
	 * sqlId : platform.role.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPage_from = "platform.role.splitPageFrom";

	/**
	 * 添加或者更新缓存
	 */
	public void cacheAdd(String ids){
		CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_role + ids, Role.dao.findById(ids));
	}

	/**
	 * 删除缓存
	 */
	public void cacheRemove(String ids){
		CacheKit.remove(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_role + ids);
	}

	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	public Role cacheGet(String key){
		Role role = CacheKit.get(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_role + key);
		return role;
	}
	
}
