package com.platform.mvc.user;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModelCache;
import com.platform.mvc.dept.Department;
import com.platform.mvc.station.Station;
import com.platform.plugin.ParamInitPlugin;
import com.platform.tools.ToolCache;

/**
 * 用户model
 * @author 董华健
 */
@SuppressWarnings("unused")
@Table(tableName = User.table_name)
public class User extends BaseModelCache<User> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(User.class);
	
	public static final User dao = new User();

	/**
	 * 表名称
	 */
	public static final String table_name = "pt_user";
	
	/**
	 * 字段描述：主键 
	 * 字段类型：character varying  长度：32
	 */
	public static final String column_ids = "ids";
	
	/**
	 * 字段描述：版本号 
	 * 字段类型：bigint  长度：null
	 */
	public static final String column_version = "version";
	
	/**
	 * 字段描述：密码连续错误次数 
	 * 字段类型：bigint  长度：null
	 */
	public static final String column_errorcount = "errorcount";
	
	/**
	 * 字段描述：排序号 
	 * 字段类型：bigint  长度：null
	 */
	public static final String column_orderids = "orderids";
	
	/**
	 * 字段描述：密码 
	 * 字段类型：bytea  长度：null
	 */
	public static final String column_password = "password";
	
	/**
	 * 字段描述：密钥 
	 * 字段类型：bytea  长度：null
	 */
	public static final String column_salt = "salt";
	
	/**
	 * 字段描述：账号状态 
	 * 字段类型：character  长度：1
	 */
	public static final String column_status = "status";
	
	/**
	 * 字段描述：账号停用时间 
	 * 字段类型：timestamp without time zone  长度：null
	 */
	public static final String column_stopdate = "stopdate";
	
	/**
	 * 字段描述：账号 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_username = "username";
	
	/**
	 * 字段描述：所在部门ids 
	 * 字段类型：character varying  长度：32
	 */
	public static final String column_departmentids = "departmentids";
	
	/**
	 * 字段描述：用户扩展信息ids 
	 * 字段类型：character varying  长度：32
	 */
	public static final String column_userinfoids = "userinfoids";
	
	/**
	 * 字段描述：所在岗位ids 
	 * 字段类型：character varying  长度：32
	 */
	public static final String column_stationids = "stationids";
	
	/**
	 * sqlId : platform.user.splitPageSelect
	 * 描述：分页Select
	 */
	public static final String sqlId_splitPageSelect = "platform.user.splitPageSelect";

	/**
	 * sqlId : platform.user.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.user.splitPageFrom";

	/**
	 * sqlId : platform.user.paging
	 * 描述：查询所有用户
	 */
	public static final String sqlId_paging = "platform.user.paging";

	/**
	 * sqlId : platform.user.treeUserNode
	 * 描述：根据部门Id查询，人员树节点数据 
	 */
	public static final String sqlId_treeUserNode = "platform.user.treeUserNode";

	/**
	 * sqlId : platform.user.column
	 * 描述：查询用户，自定义字段和值
	 */
	public static final String sqlId_column = "platform.user.column";

	/**
	 * sqlId : platform.user.stop
	 * 描述：停用账户
	 */
	public static final String sqlId_stop = "platform.user.stop";

	/**
	 * sqlId : platform.user.start
	 * 描述：启用停用账户
	 */
	public static final String sqlId_start = "platform.user.start";

	private String ids;
	private Long version;
	private Long errorcount;
	private Long orderids;
	private byte[] password;
	private byte[] salt;
	private String status;
	private Timestamp stopdate;
	private String username;
	private String departmentids;
	private String userinfoids;
	private String stationids;
	private String groupids;
	private String departmentnames;
	private String stationnames;
	private String groupnames;
	
	public void setIds(String ids){
		set(column_ids, ids);
	}
	public String getIds() {
		return get(column_ids);
	}
	public void setVersion(Long version){
		set(column_version, version);
	}
	public Long getVersion() {
		return get(column_version);
	}
	public void setErrorcount(Long errorcount){
		set(column_errorcount, errorcount);
	}
	public Long getErrorcount() {
		return get(column_errorcount);
	}
	public void setOrderids(Long orderids){
		set(column_orderids, orderids);
	}
	public Long getOrderids() {
		return get(column_orderids);
	}
	public void setPassword(byte[] password){
		set(column_password, password);
	}
	public byte[] getPassword() {
		return get(column_password);
	}
	public void setSalt(byte[] salt){
		set(column_salt, salt);
	}
	public byte[] getSalt() {
		return get(column_salt);
	}
	public void setStatus(String status){
		set(column_status, status);
	}
	public String getStatus() {
		return get(column_status);
	}
	public void setStopdate(Timestamp stopdate){
		set(column_stopdate, stopdate);
	}
	public Timestamp getStopdate() {
		return get(column_stopdate);
	}
	public void setUsername(String username){
		set(column_username, username);
	}
	public String getUsername() {
		return get(column_username);
	}
	public void setDepartmentids(String departmentids){
		set(column_departmentids, departmentids);
	}
	public String getDepartmentids() {
		return get(column_departmentids);
	}
	public void setUserinfoids(String userinfoids){
		set(column_userinfoids, userinfoids);
	}
	public String getUserinfoids() {
		return get(column_userinfoids);
	}
	public void setStationids(String stationids){
		set(column_stationids, stationids);
	}
	public String getStationids() {
		return get(column_stationids);
	}
	
	/**
	 * 关联查询，获取用户详细信息
	 * @return
	 */
	public UserInfo getUserInfo(){
		String userinfoIds = get(column_userinfoids);
		if(null != userinfoIds && !userinfoIds.isEmpty()){
			return UserInfo.dao.findById(userinfoIds);
		}
		return null;
	}

	/**
	 * 关联查询，获取用户部门信息
	 * @return
	 */
	public Department getDepartment(){
		String departmentids = get(column_departmentids);
		if(null != departmentids && !departmentids.isEmpty()){
			return Department.dao.findById(departmentids);
		}
		return null;
	}

	/**
	 * 关联查询，获取用户岗位信息
	 * @return
	 */
	public Station getStation(){
		String stationids = get(column_stationids);
		if(null != stationids && !stationids.isEmpty()){
			return Station.dao.findById(stationids);
		}
		return null;
	}
	
	/**
	 * 添加或者更新缓存
	 */
	public void cacheAdd(String ids){
		User user = User.dao.findById(ids);
		
		ToolCache.set(ParamInitPlugin.cacheStart_user + ids, user);
		ToolCache.set(ParamInitPlugin.cacheStart_user + user.getStr(column_username), user);
		
		String userInfoIds = user.getStr(User.column_userinfoids);
		UserInfo.dao.cacheAdd(userInfoIds);
	}

	/**
	 * 删除缓存
	 */
	public void cacheRemove(String ids){
		User user = User.dao.findById(ids);
		ToolCache.remove(ParamInitPlugin.cacheStart_user + ids);
		ToolCache.remove(ParamInitPlugin.cacheStart_user + user.getStr(column_username));

		String userInfoIds = user.getStr(User.column_userinfoids);
		UserInfo.dao.cacheRemove(userInfoIds);
	}

	/**
	 * 获取缓存
	 * @param ids
	 * @return
	 */
	public User cacheGet(String ids){
		User user = ToolCache.get(ParamInitPlugin.cacheStart_user + ids);
		if(user == null){
			user = User.dao.findById(ids);
			cacheAdd(ids);
		}
		return user;
	}
	
}
