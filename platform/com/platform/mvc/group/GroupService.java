package com.platform.mvc.group;

import java.util.List;

import org.apache.log4j.Logger;

import com.platform.annotation.Service;
import com.platform.mvc.base.BaseService;
import com.platform.mvc.grouprole.GroupRoleService;
import com.platform.mvc.user.User;
import com.platform.mvc.usergroup.UserGroup;

@Service(name = GroupService.serviceName)
public class GroupService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(GroupService.class);

	public static final String serviceName = "groupService";

	/**
	 * 保存
	 * @param group
	 * @return
	 */
	public String save(Group group){
		group.save();
		return group.getPKValue();
	}

	/**
	 * 更新
	 * @param group
	 */
	public void update(Group group){
		group.update();
	}

	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids){
		String[] idsArr = splitByComma(ids);
		String sql = getSql("platform.group.getUserByGroup");
		for (String groupIds : idsArr) {
			// 缓存1：更新所有关联此分组的用户缓存
			List<UserGroup> ugList = UserGroup.dao.find(sql, groupIds);
			for (UserGroup userGroup : ugList) {
				User.cacheAdd(userGroup.getUserids());
			}
			
			// 缓存2：删除分组对应的功能缓存
			GroupRoleService.cacheRemove(groupIds); 
			
			// 删除
			Group.dao.deleteById(groupIds);
		}
	}
	
}
