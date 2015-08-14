package little.ant.platform.model;

import little.ant.platform.annotation.Table;
import little.ant.platform.constant.ConstantCache;
import little.ant.platform.constant.ConstantInit;
import little.ant.platform.plugin.ParamInitPlugin;

import org.apache.log4j.Logger;

import com.jfinal.plugin.ehcache.CacheKit;

/**
 * 人员分组model
 * @author 董华健
 */
@SuppressWarnings("unused")
@Table(tableName = "pt_group")
public class Group extends BaseModelCache<Group> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Group.class);
	
	public static final Group dao = new Group();

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
	 * 字段描述：拥有的角色ids 
	 * 字段类型 ：text 
	 */
	public static final String column_roleids = "roleids";
	
	/**
	 * 字段描述：编号 
	 * 字段类型 ：character varying 
	 */
	public static final String column_numbers = "numbers";
	
	/**
	 * sqlId : platform.group.splitPageSelect
	 * 描述：分页Select
	 */
	public static final String sqlId_splitPage_select = "platform.group.splitPageSelect";

	/**
	 * sqlId : platform.group.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPage_from = "platform.group.splitPageFrom";

	/**
	 * sqlId : platform.group.all
	 * 描述：查询所有分组 
	 */
	public static final String sqlId_all = "platform.group.all";

	/**
	 * sqlId : platform.group.noCheckedFilter
	 * 描述：用户分组选择：未选择
	 */
	public static final String sqlId_noCheckedFilter = "platform.group.noCheckedFilter";

	/**
	 * sqlId : platform.group.checkedFilter
	 * 描述：用户分组选择：已选择
	 */
	public static final String sqlId_checkedFilter = "platform.group.checkedFilter";

	/**
	 * sqlId : platform.group.noChecked
	 * 描述：用户分组选择：所有未选择
	 */
	public static final String sqlId_noChecked = "platform.group.noChecked";
	
	/**
	 * 添加或者更新缓存
	 */
	public void cacheAdd(String ids){
		CacheKit.put(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_group + ids, Group.dao.findById(ids));
	}

	/**
	 * 删除缓存
	 */
	public void cacheRemove(String ids){
		CacheKit.remove(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_group + ids);
	}

	/**
	 * 获取缓存
	 * @param ids
	 * @return
	 */
	public Group cacheGet(String ids){
		Group group = CacheKit.get(ConstantCache.cache_name_system, ParamInitPlugin.cacheStart_group + ids);
		return group;
	}
	
}
