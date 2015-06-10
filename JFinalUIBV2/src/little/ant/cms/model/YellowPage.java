package little.ant.cms.model;

import little.ant.platform.annotation.Table;
import little.ant.platform.constant.ConstantInit;
import little.ant.platform.model.BaseModel;

import org.apache.log4j.Logger;

/**
 * 黄页 model
 * @author 董华健
 */
@SuppressWarnings("unused")
@Table(dataSourceName = ConstantInit.db_dataSource_main, tableName = "cms_yellowpage")
public class YellowPage extends BaseModel<YellowPage> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(YellowPage.class);
	
	public static final YellowPage dao = new YellowPage();
	
	/**
	 * 字段描述：主键 
	 * 字段类型 ：character varying 
	 */
	public static final String column_ids = "ids";
	
	/**
	 * 字段描述：地址 
	 * 字段类型 ：character varying 
	 */
	public static final String column_address = "address";
	
	/**
	 * 字段描述：联系人 
	 * 字段类型 ：character varying 
	 */
	public static final String column_contacts = "contacts";
	
	/**
	 * 字段描述：固话 
	 * 字段类型 ：character varying 
	 */
	public static final String column_fixphone = "fixphone";
	
	/**
	 * 字段描述：移动电话 
	 * 字段类型 ：character varying 
	 */
	public static final String column_mobile = "mobile";
	
	/**
	 * 字段描述：邮编 
	 * 字段类型 ：character varying 
	 */
	public static final String column_postcode = "postcode";
	
	/**
	 * 字段描述：在线qq : 多个逗号隔开，最多5个 
	 * 字段类型 ：character varying 
	 */
	public static final String column_qq = "qq";
	
	/**
	 * 字段描述：内容主键 
	 * 字段类型 ：character varying 
	 */
	public static final String column_contentids = "contentids";

	/**
	 * sqlId : cms.yellowPage.splitPageSelect
	 * 描述：分页Select
	 */
	public static final String sqlId_splitPage_select = "cms.yellowPage.splitPageSelect";

	/**
	 * sqlId : cms.yellowPage.splitPageFrom
	 * 描述：分页from
	 */
	public static final String sqlId_splitPage_from = "cms.yellowPage.splitPageFrom";

	
}
