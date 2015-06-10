package little.ant.cms.model;

import little.ant.platform.annotation.Table;
import little.ant.platform.constant.ConstantInit;
import little.ant.platform.model.BaseModel;

import org.apache.log4j.Logger;

/**
 * 回答 model
 * @author 董华健
 */
@SuppressWarnings("unused")
@Table(dataSourceName = ConstantInit.db_dataSource_main, tableName = "cms_answers")
public class Answers extends BaseModel<Answers> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Answers.class);
	
	public static final Answers dao = new Answers();
	
	/**
	 * 字段描述：主键 
	 * 字段类型 ：character varying 
	 */
	public static final String column_ids = "ids";
	
	/**
	 * 字段描述：乐观锁 
	 * 字段类型 ：bigint 
	 */
	public static final String column_version = "version";
	
	/**
	 * 字段描述：评论内容 
	 * 字段类型 ：text 
	 */
	public static final String column_content = "content";
	
	/**
	 * 字段描述：评论人 
	 * 字段类型 ：character varying 
	 */
	public static final String column_createuser = "createuser";
	
	/**
	 * 字段描述：评论时间 
	 * 字段类型 ：timestamp with time zone 
	 */
	public static final String column_createdate = "createdate";
	
	/**
	 * 字段描述：最后修改人 
	 * 字段类型 ：character varying 
	 */
	public static final String column_updateuser = "updateuser";
	
	/**
	 * 字段描述：最后修改时间 
	 * 字段类型 ：timestamp with time zone 
	 */
	public static final String column_updatedate = "updatedate";
	
	/**
	 * 字段描述：是否删除 
	 * 字段类型 ：character 
	 */
	public static final String column_isdelete = "isdelete";
	
	/**
	 * 字段描述：删除人 
	 * 字段类型 ：character varying 
	 */
	public static final String column_deleteuser = "deleteuser";
	
	/**
	 * 字段描述：删除时间 
	 * 字段类型 ：timestamp with time zone 
	 */
	public static final String column_deletedate = "deletedate";
	
	/**
	 * 字段描述：点赞次数 
	 * 字段类型 ：bigint 
	 */
	public static final String column_praisecount = "praisecount";
	
	/**
	 * 字段描述：踩次数 
	 * 字段类型 ：bigint 
	 */
	public static final String column_tramplecount = "tramplecount";
	
	/**
	 * 字段描述：上级评论 
	 * 字段类型 ：character varying 
	 */
	public static final String column_pids = "pids";
	
	/**
	 * 字段描述：是否最佳答案 : 0否，1是 
	 * 字段类型 ：character 
	 */
	public static final String column_answers = "answers";
	
	/**
	 * 字段描述：主键 
	 * 字段类型 ：character varying 
	 */
	public static final String column_questionsids = "questionsids";

	/**
	 * sqlId : cms.answers.splitPageSelect
	 * 描述：分页Select
	 */
	public static final String sqlId_splitPage_select = "cms.answers.splitPageSelect";

	/**
	 * sqlId : cms.answers.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPage_from = "cms.answers.splitPageFrom";

	
}
