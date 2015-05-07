package little.ant.cms.model;

import little.ant.platform.annotation.Table;
import little.ant.platform.common.DictKeys;
import little.ant.platform.model.BaseModel;

import org.apache.log4j.Logger;

@SuppressWarnings("unused")
@Table(dataSourceName = DictKeys.db_dataSource_main, tableName = "cms_photogalleryitem")
public class PhotogalleryItem extends BaseModel<PhotogalleryItem> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(PhotogalleryItem.class);
	
	public static final PhotogalleryItem dao = new PhotogalleryItem();
	
	public static final String colunm_ids = "ids";
	public static final String colunm_version = "version";
	public static final String colunm_createuser = "createuser";
	public static final String colunm_createdate = "createdate";
	public static final String colunm_updateuser = "updateuser";
	public static final String colunm_updatedate = "updatedate";
	public static final String colunm_isdelete = "isdelete";
	public static final String colunm_deleteuser = "deleteuser";
	public static final String colunm_deletedate = "deletedate";
	public static final String colunm_uploadids = "uploadids";
	public static final String colunm_uploadpath = "uploadpath";
	public static final String colunm_photogalleryids = "photogalleryids";
	
}
