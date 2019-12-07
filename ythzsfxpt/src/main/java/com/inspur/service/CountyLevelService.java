package com.inspur.service;

import com.inspur.utils.KeyConstants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CountyLevelService {

	@Resource
	@Qualifier("ywtb_jdbcTemplate")
	private JdbcTemplate ywtbJdbcTemplate;
	
	@Resource
	@Qualifier("spyh_jdbcTemplate")
	private JdbcTemplate spyhJdbcTemplate;

	@Resource
	@Qualifier("sxgl_jdbcTemplate")
	private JdbcTemplate sxglJdbcTemplate;
	
	// 县事项总数:
	// STATE :事项服务状态编码,"5"代表"已发布"
	// STATUS：事项操作状态编码,"5"代表"法制办发布通过" 
	// TYPE:权力事项类型编码:xk:"许可”,ZS:"征收",QR:"确认",JF:"给付",JL:"奖励",CJ:"裁决",QT:"其他",GG:"公共服务","JD":"监督"
	// PROPERTY:事项属性状态编码
	public String qxsxzlCounty(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select count(i.ID) sxzl\n" +
					"  from PROJECT_ITEM i\n" +
					" where i.state = '5'\n" +
					"   and i.status = '5'\n" +
					"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
					"   and i.PROPERTY = '0'\n" +
					"   and i.region_code in ('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select count(i.ID) sxzl\n" +
					"  from PROJECT_ITEM i\n" +
					" where i.state = '5'\n" +
					"   and i.status = '5'\n" +
					"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
					"   and i.PROPERTY = '0'\n" +
					"   and i.region_code = ('"+region_code+"')";
		}

		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
	
	// 线上办理事项
	// is_online:是否网上办理 [0 仅窗口办理；1 是；2 仅网上办理；3 窗口、网上均可办理]
	public String xsblsx(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select count(i.ID) xsblsx\n" +
					"  from PROJECT_ITEM i\n" +
					" where i.state = '5'\n" +
					"   and i.status = '5'\n" +
					"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
					"   and i.PROPERTY = '0'\n" +
					"   and i.is_online in('1','2','3')\n" +
					"   and i.region_code in ('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select count(i.ID) xsblsx\n" +
					"  from PROJECT_ITEM i\n" +
					" where i.state = '5'\n" +
					"   and i.status = '5'\n" +
					"   and i.is_online in('1','2','3')\n" +
					"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
					"   and i.PROPERTY = '0'\n" +
					"   and i.region_code = ('"+region_code+"')";
		}
		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
		
	//线下办理事项
	// is_online:是否网上办理 [0 仅窗口办理；1 是；2 仅网上办理；3 窗口、网上均可办理]
	public String xxblsx(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select count(i.ID) xxblsx\n" +
					"  from PROJECT_ITEM i\n" +
					" where i.state = '5'\n" +
					"   and i.status = '5'\n" +
					"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
					"   and i.PROPERTY = '0'\n" +
					"   and i.is_online = 0\n" +
					"   and i.region_code in ('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select count(i.ID) xxblsx\n" +
					"  from PROJECT_ITEM i\n" +
					" where i.state = '5'\n" +
					"   and i.status = '5'\n" +
					"   and i.PROPERTY = '0'\n" +
					"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
					"   and i.PROPERTY = '0'\n" +
					"   and i.region_code = ('"+region_code+"')";
		}
		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
	// 信息公开数
    // project_item_ext.sub_type :事项服务类型：依申请服务1；主动服务2；依申请和主动服务1,2
	public String xxgkNum(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select count(i.ID) from PROJECT_ITEM i inner join project_item_ext a "
					+ " on i.ID = a.item_id  and i.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')"
					+ " and (a.sub_type = '2') left join BASE_ONLINECONDUCT o  on i.code = o.item_code "
					+ " and i.version = o.item_version  where i.state = '5' and i.status = '5' "
					+ "  and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD') "
					+ "  and i.PROPERTY = '0'";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select count(i.ID) from PROJECT_ITEM i inner join project_item_ext a "
					+ " on i.ID = a.item_id  and i.region_code = '" + region_code+"'"
					+ " and (a.sub_type = '2') left join BASE_ONLINECONDUCT o  on i.code = o.item_code "
					+ " and i.version = o.item_version  where i.state = '5' and i.status = '5' "
					+ "  and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD') "
					+ "  and i.PROPERTY = '0'";
		}
		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
	// 全区县依申请公开的事项数
	// project_item_ext.sub_type :事项服务类型：依申请服务1；主动服务2；依申请和主动服务1,2
	public String ysqgksxNum(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select count(i.ID)  from PROJECT_ITEM i inner join project_item_ext a "
					+ " on i.ID = a.item_id and i.region_code in ('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') "
					+ " and (a.sub_type <> '2' or a.sub_type is null)"
					+ " left join BASE_ONLINECONDUCT o " + " on i.code=o.item_code and i.version =o.item_version"
					+ " where  i.state='5' " + " and i.status='5' "
					+ " and i.type in('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')" + " and i.PROPERTY = '0' ";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select count(i.ID)  from PROJECT_ITEM i inner join project_item_ext a "
					+ " on i.ID = a.item_id and i.region_code= '" + region_code+"'"
					+ " and (a.sub_type <> '2' or a.sub_type is null)" + " left join BASE_ONLINECONDUCT o "
					+ " on i.code=o.item_code and i.version =o.item_version" + " where  i.state='5' "
					+ " and i.status='5' " + " and i.type in('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')"
					+ " and i.PROPERTY = '0' ";
		}
		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
	
	// 全区县依申请公开事项总数：可网上办理事项数
	// “conduct_depth”是网办深度或审批深度：“1”是全程网办（0跑腿）；“2”是在线预审（只跑1次）；“3”是事项公开，“4”是在线申办。
		public String ysqgkkwshblNum(String county,String depth) {
			String sql = "";
			if ((county == null || county.equals(""))&&(depth == null || depth.equals(""))) {
				// 当区县和网办深度都为空时，查询全区县的网上办理数据
				sql = "select count(t.ID) ysqgksxgjwbsdcx FROM PROJECT_ITEM T "
						+" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
						+" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
						+" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
						+" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5'"
						+" and t.region_code in ('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')"
						+" and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')"
						+" and o.conduct_depth in (1,2,4)";
			} else if((county == null || county.equals(""))&& !(depth == null || depth.equals(""))){
				// 当区县为空，网办深度不为空时，查询全区县的当前查询的网办深度的数据
				sql = "select count(t.ID) ysqgksxgjwbsdcx FROM PROJECT_ITEM T "
						+" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
						+" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
						+" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
						+" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5'"
						+" and t.region_code in ('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')"
						+" and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')"
		                +" and o.conduct_depth in ("+depth+")";
			}else if(!(county == null || county.equals(""))&& (depth == null || depth.equals(""))){
				// 当区县不为为空，网办深度为空时，查询的是当前区县的网上办理的数据
				String region_code = KeyConstants.region_Code_Map.get(county);
				sql = "select count(t.ID) ysqgksxgjwbsdcx FROM PROJECT_ITEM T "
						+" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
						+" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
						+" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
						+" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5'"
						 +" and t.region_code= '" + region_code+"'"
						+" and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')"
						+" and o.conduct_depth in (1,2,4)";
				
			}else if(!(county == null || county.equals(""))&& !(depth == null || depth.equals(""))){
				// 当区县不为为空，网办深度不为空时，查询的是当前区县的要查询的网办深度的数据
				String region_code = KeyConstants.region_Code_Map.get(county);
				sql = "select count(t.ID) ysqgksxgjwbsdcx FROM PROJECT_ITEM T "
						+" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
						+" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
						+" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
						+" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5'"
						 +" and t.region_code= '" + region_code+"'"
						+" and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')"
						 +" and o.conduct_depth in ("+depth+")";
			}
			
			
			return sxglJdbcTemplate.queryForObject(sql, String.class);
		}
	
	// 各区县依申请公开可网上办理事项统计
	public List<Map<String, Object>> ysqgkkwsblsxtjList() {
		String sql = "select distinct(i.region_code) regionName ,count(i.ID) wsblNUm from PROJECT_ITEM i,project_item_ext a, BASE_ONLINECONDUCT o  "
				+ " where i.ID = a.item_id and i.region_code in ('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') and i.state='5' "
				+ " and i.status='5'  and i.PROPERTY = '0'   and a.sub_type <> '2' and i.type in( 'XK','ZS','QR','JF','JL','CJ','QT','GG','JD')"
				+ " and i.code=o.item_code and i.version=o.item_version and o.conduct_depth !='3'"
				+ " group by i.region_code"
				+ " order by wsblNUm desc";
		return sxglJdbcTemplate.queryForList(sql);
	}
	
	// 事项性质数量
	public Map<String, Object> sxxzsl(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select sum(case when i.type = 'XK' then 1 else 0 end) XK,"
					+ " sum(case when i.type = 'ZS' then 1 else 0 end) ZS,"
					+ " sum(case when i.type = 'QR' then 1 else 0 end) QR,"
					+ " sum(case when i.type = 'JF' then 1 else 0 end) JF,"
					+ " sum(case when i.type = 'JL' then 1 else 0 end) JL,"
					+ " sum(case when i.type = 'CJ' then 1 else 0 end) CJ,"
					+ " sum(case when i.type = 'QT' then 1 else 0  end) QT,"
					+ " sum(case when i.type = 'GG' then 1  else 0 end) GG,"
					+ " sum(case  when i.type = 'JD' then 1 else  0 end) JD" + " from PROJECT_ITEM  i"
					+ " where type in ('JL', 'ZS', 'QT', 'GG', 'JF', 'JD', 'XK', 'QR','CJ')  and i.state = '5' "
					+ "  and i.status = '5'   and i.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select sum(case when i.type = 'XK' then 1 else 0 end) XK,"
					+ " sum(case when i.type = 'ZS' then 1 else 0 end) ZS,"
					+ " sum(case when i.type = 'QR' then 1 else 0 end) QR,"
					+ " sum(case when i.type = 'JF' then 1 else 0 end) JF,"
					+ " sum(case when i.type = 'JL' then 1 else 0 end) JL,"
					+ " sum(case when i.type = 'CJ' then 1 else 0 end) CJ,"
					+ " sum(case when i.type = 'QT' then 1 else 0  end) QT,"
					+ " sum(case when i.type = 'GG' then 1  else 0 end) GG,"
					+ " sum(case  when i.type = 'JD' then 1 else  0 end) JD" + " from PROJECT_ITEM  i"
					+ " where type in ('JL', 'ZS', 'QT', 'GG', 'JF', 'JD', 'XK', 'QR','CJ')  and i.state = '5' "
					+ "  and i.status = '5'   and i.region_code = '" + region_code + "'";
		}
		return sxglJdbcTemplate.queryForMap(sql);
	}

	// 部门受理
	public List<Map<String, Object>> qxbmsl(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select rownum, t.sl, t.org_name\r\n" + "  from (select count(*) sl, org_name\r\n"
					+ "          from APPROVE_BUSINESS_INDEX x\r\n" + "         where x.submit_time is not null\r\n"
					+ "           and x.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')\r\n"
					+ "         group by org_name\r\n" + "         order by sl desc) t\r\n" + " where rownum <= 10";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select rownum, t.sl, t.org_name\r\n" + "  from (select count(*) sl, org_name\r\n"
					+ "          from APPROVE_BUSINESS_INDEX x\r\n" + "         where x.submit_time is not null\r\n"
					+ "           and x.region_code = '" + region_code + "'\r\n" + "         group by org_name\r\n"
					+ "         order by sl desc) t\r\n" + " where rownum <= 10";
		}
		return spyhJdbcTemplate.queryForList(sql);
	}

	// 部门办结
	public List<Map<String, Object>> qxbmbj(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select rownum, t.sl, t.org_name\r\n" + "  from (select count(*) sl, org_name\r\n"
					+ "          from APPROVE_BUSINESS_INDEX x\r\n" + "         where x.finish_time is not null\r\n"
					+ "           and x.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')\r\n"
					+ "         group by org_name\r\n" + "         order by sl desc) t\r\n" + " where rownum <= 10";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select rownum, t.sl, t.org_name\r\n" + "  from (select count(*) sl, org_name\r\n"
					+ "          from APPROVE_BUSINESS_INDEX x\r\n" + "         where x.finish_time is not null\r\n"
					+ "           and i.region_code = '" + region_code + "'\r\n" + "         group by org_name\r\n"
					+ "         order by sl desc) t\r\n" + " where rownum <= 10";
		}
		return spyhJdbcTemplate.queryForList(sql);
	}

	// 全区县事项性质和网上办理：已发布
	public Map<String, Object> sxxzsyjwsbls_Publish(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = "select sum(case when i.type = 'XK' then 1 else 0 end) XK,"
					+ " sum(case when i.type = 'ZS' then 1 else 0 end) ZS,"
					+ " sum(case when i.type = 'QR' then 1 else 0 end) QR,"
					+ "  sum(case when i.type = 'JF' then 1 else 0 end) JF,"
					+ " sum(case when i.type = 'JL' then 1 else 0 end) JL,"
					+ " sum(case when i.type = 'CJ' then 1 else 0 end) CJ,"
					+ " sum(case when i.type = 'QT' then 1 else 0  end) QT,"
					+ "  sum(case when i.type = 'GG' then 1  else 0 end) GG,"
					+ " sum(case  when i.type = 'JD' then 1 else  0 end) JD"
					+ " from PROJECT_ITEM i, project_item_ext a, BASE_ONLINECONDUCT o"
					+ " where i.ID = a.item_id and i.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')"
					+ " and i.state = '5' and i.status = '5'  and i.PROPERTY = '0' and a.sub_type <> '2'"
					+ " and i.code = o.item_code and i.version = o.item_version";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = "select sum(case when i.type = 'XK' then 1 else 0 end) XK,"
					+ " sum(case when i.type = 'ZS' then 1 else 0 end) ZS,"
					+ " sum(case when i.type = 'QR' then 1 else 0 end) QR,"
					+ "  sum(case when i.type = 'JF' then 1 else 0 end) JF,"
					+ " sum(case when i.type = 'JL' then 1 else 0 end) JL,"
					+ " sum(case when i.type = 'CJ' then 1 else 0 end) CJ,"
					+ " sum(case when i.type = 'QT' then 1 else 0  end) QT,"
					+ "  sum(case when i.type = 'GG' then 1  else 0 end) GG,"
					+ " sum(case  when i.type = 'JD' then 1 else  0 end) JD"
					+ " from PROJECT_ITEM i, project_item_ext a, BASE_ONLINECONDUCT o"
					+ " where i.ID = a.item_id and i.region_code = '"+region_code+"'"
					+ " and i.state = '5' and i.status = '5'  and i.PROPERTY = '0' and a.sub_type <> '2'"
					+ " and i.code = o.item_code and i.version = o.item_version";
		}
		return sxglJdbcTemplate.queryForMap(sql);
	}
	
	// 全区县目录和运行事项：已发布
		public Map<String, Object> sxxzsyjwsbls_PublishSum(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
				
				sql="select sum(case when t.type = 'XK' then 1 else 0 end) XK,"
						+" sum(case when t.type = 'ZS' then 1 else 0 end) ZS,"
						+"sum(case when t.type = 'QR' then 1 else 0 end) QR,"
						+" sum(case when t.type = 'JF' then 1 else 0 end) JF,"
						+"sum(case when t.type = 'JL' then 1 else 0 end) JL,"
						+" sum(case when t.type = 'CJ' then 1 else 0 end) CJ,"
						+" sum(case when t.type = 'QT' then 1 else 0  end) QT,"
						+"  sum(case when t.type = 'GG' then 1  else 0 end) GG,"
						+" sum(case  when t.type = 'JD' then 1 else  0 end) JD "     
						+" FROM PROJECT_ITEM T "
						+" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
						+" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
						+" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
						+" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5'"
						+" and t.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') ";
				
			} else {
				String region_code = KeyConstants.region_Code_Map.get(county);
				sql="select sum(case when t.type = 'XK' then 1 else 0 end) XK,"
						+" sum(case when t.type = 'ZS' then 1 else 0 end) ZS,"
						+"sum(case when t.type = 'QR' then 1 else 0 end) QR,"
						+" sum(case when t.type = 'JF' then 1 else 0 end) JF,"
						+"sum(case when t.type = 'JL' then 1 else 0 end) JL,"
						+" sum(case when t.type = 'CJ' then 1 else 0 end) CJ,"
						+" sum(case when t.type = 'QT' then 1 else 0  end) QT,"
						+"  sum(case when t.type = 'GG' then 1  else 0 end) GG,"
						+" sum(case  when t.type = 'JD' then 1 else  0 end) JD "     
						+" FROM PROJECT_ITEM T "
						+" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
						+" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
						+" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
						+" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5'"
						+" and t.region_code  = '"+region_code+"'";
				
			}
			return sxglJdbcTemplate.queryForMap(sql);
		}
	// 全区县事项性质和网上办理：可网上办理数
	public Map<String, Object> sxxzsyjwsbls_onLine(String county) {
		String sql = "";
		if (county == null || county.equals("")) {
			sql = " select sum(case when t.type = 'XK' then 1 else 0 end) XK,"
            +" sum(case  when t.type = 'ZS' then  1  else  0  end) ZS,"
            +" sum(case when t.type = 'QR' then 1 else 0 end) QR,"
            +" sum(case when t.type = 'JF' then  1 else  0 end) JF,"
            +" sum(case when t.type = 'JL' then  1  else  0 end) JL,"
            +" sum(case  when t.type = 'CJ' then 1 else  0 end) CJ,"
            +" sum(case when t.type = 'QT' then  1 else 0 end) QT,"
            +" sum(case when t.type = 'GG' then  1 else 0 end) GG,"
            +" sum(case when t.type = 'JD' then 1 else  0 end) JD"
           +" FROM PROJECT_ITEM T "
           +" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
           +" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
           +" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
           +" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5'"
           +" and t.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')"
           +" and o.conduct_depth in ('1','2', '4')";
		} else {
			String region_code = KeyConstants.region_Code_Map.get(county);
			sql = " select sum(case when t.type = 'XK' then 1 else 0 end) XK,"
		            +" sum(case  when t.type = 'ZS' then  1  else  0  end) ZS,"
		            +" sum(case when t.type = 'QR' then 1 else 0 end) QR,"
		            +" sum(case when t.type = 'JF' then  1 else  0 end) JF,"
		            +" sum(case when t.type = 'JL' then  1  else  0 end) JL,"
		            +" sum(case  when t.type = 'CJ' then 1 else  0 end) CJ,"
		            +" sum(case when t.type = 'QT' then  1 else 0 end) QT,"
		            +" sum(case when t.type = 'GG' then  1 else 0 end) GG,"
		            +" sum(case when t.type = 'JD' then 1 else  0 end) JD"
		           +" FROM PROJECT_ITEM T "
		           +" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
		           +" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
		           +" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
		           +" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5'"
		           +" and t.region_code  ='"+region_code+"'"
		           +" and o.conduct_depth in ('1','2', '4')";
		}
		return sxglJdbcTemplate.queryForMap(sql);
	}
	
	//业务办理变化趋势当日线上受理次数
		public List<Map<String,Object>> drxsslcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			 sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
					"   and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
					"   and to_char(SUBMIT_TIME, 'hh24') in\r\n" + 
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
					" group by to_char(SUBMIT_TIME, 'hh24')\r\n" + 
					" order by to_char(SUBMIT_TIME, 'hh24')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\r\n" + 
						"  from APPROVE_BUSINESS_INDEX\r\n" + 
						" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
						"   and region_code ='"+region_code +"'"+ 
						"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
						"   and to_char(SUBMIT_TIME, 'hh24') in\r\n" + 
						"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
						" group by to_char(SUBMIT_TIME, 'hh24')\r\n" + 
						" order by to_char(SUBMIT_TIME, 'hh24')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当日线上办结次数
		public List<Map<String,Object>> drxsbjcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			 sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
					"   and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
					"   and to_char(FINISH_TIME, 'hh24') in\r\n" + 
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
					" group by to_char(FINISH_TIME, 'hh24')\r\n" + 
					" order by to_char(FINISH_TIME, 'hh24')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
							"   and region_code ='" +region_code +"'" +
							"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
							"   and to_char(FINISH_TIME, 'hh24') in\r\n" + 
							"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
							" group by to_char(FINISH_TIME, 'hh24')\r\n" + 
							" order by to_char(FINISH_TIME, 'hh24')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当月线上受理次数
		public List<Map<String,Object>> dyxsslcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			 sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
					"   and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
					" group by to_char(SUBMIT_TIME, 'dd')\r\n" + 
					" order by to_char(SUBMIT_TIME, 'dd')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\r\n" + 
						"  from APPROVE_BUSINESS_INDEX\r\n" + 
						" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
						"   and region_code ='"+region_code+"'" + 
						"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
						" group by to_char(SUBMIT_TIME, 'dd')\r\n" + 
						" order by to_char(SUBMIT_TIME, 'dd')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当月线上办结次数
		public List<Map<String,Object>> dyxsbjcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			 sql = " select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and FINISH_TIME is not null\r\n" + 
					"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
					" group by to_char(FINISH_TIME, 'dd')\r\n" + 
					" order by to_char(FINISH_TIME, 'dd')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = " select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
							" and region_code ='"+region_code+"'" + 
							"   and FINISH_TIME is not null\r\n" + 
							"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
							" group by to_char(FINISH_TIME, 'dd')\r\n" + 
							" order by to_char(FINISH_TIME, 'dd')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当年线上受理次数
		public List<Map<String,Object>> dnxsslcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			 sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
					" group by to_char(SUBMIT_TIME, 'MM')\r\n" + 
					" order by to_char(SUBMIT_TIME, 'MM')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
							" and region_code ='"+region_code+"'" + 
							"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
							" group by to_char(SUBMIT_TIME, 'MM')\r\n" + 
							" order by to_char(SUBMIT_TIME, 'MM')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当年线上办结次数
		public List<Map<String,Object>> dnxsbjcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			 sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and FINISH_TIME is not null\r\n" + 
					"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
					" group by to_char(FINISH_TIME, 'MM')\r\n" + 
					" order by to_char(FINISH_TIME, 'MM')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
							" and region_code ='"+region_code+"'" + 
							"   and FINISH_TIME is not null\r\n" + 
							"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
							" group by to_char(FINISH_TIME, 'MM')\r\n" + 
							" order by to_char(FINISH_TIME, 'MM')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当日线下受理 
		public List<Map<String,Object>> drxxslcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			 sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('02', '07')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
					"   and to_char(SUBMIT_TIME, 'hh24') in\r\n" + 
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
					" group by to_char(SUBMIT_TIME, 'hh24')\r\n" + 
					" order by to_char(SUBMIT_TIME, 'hh24')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('02', '07')\r\n" + 
							" and region_code ='"+region_code+"'" + 
							"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
							"   and to_char(SUBMIT_TIME, 'hh24') in\r\n" + 
							"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
							" group by to_char(SUBMIT_TIME, 'hh24')\r\n" + 
							" order by to_char(SUBMIT_TIME, 'hh24')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当日线下办结
		public List<Map<String,Object>> drxxbjcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {	
			 sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('02', '07')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and FINISH_TIME is not null\r\n" + 
					"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
					"   and to_char(FINISH_TIME, 'hh24') in\r\n" + 
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
					" group by to_char(FINISH_TIME, 'hh24')\r\n" + 
					" order by to_char(FINISH_TIME, 'hh24')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('02', '07')\r\n" + 
							" and region_code='"+region_code+"'" + 
							"   and FINISH_TIME is not null\r\n" + 
							"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
							"   and to_char(FINISH_TIME, 'hh24') in\r\n" + 
							"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
							" group by to_char(FINISH_TIME, 'hh24')\r\n" + 
							" order by to_char(FINISH_TIME, 'hh24')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当月线下受理
		public List<Map<String,Object>> dyxxslcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {	
			 sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('02', '07')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
					" group by to_char(SUBMIT_TIME, 'dd')\r\n" + 
					" order by to_char(SUBMIT_TIME, 'dd')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('02', '07')\r\n" + 
							" and region_code ='"+region_code+"'" + 
							"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
							" group by to_char(SUBMIT_TIME, 'dd')\r\n" + 
							" order by to_char(SUBMIT_TIME, 'dd')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当月线下办结
		public List<Map<String,Object>> dyxxbjcs(String county) {
			
			String sql = "";
			if (county == null || county.equals("")) {
				
			  sql = " select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('02', '07')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and FINISH_TIME is not null\r\n" + 
					"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
					" group by to_char(FINISH_TIME, 'dd')\r\n" + 
					" order by to_char(FINISH_TIME, 'dd')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = " select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('02', '07')\r\n" + 
							" and region_code  ='"+region_code+"'" + 
							"   and FINISH_TIME is not null\r\n" + 
							"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
							" group by to_char(FINISH_TIME, 'dd')\r\n" + 
							" order by to_char(FINISH_TIME, 'dd')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当年线下受理
		public List<Map<String,Object>> dnxxslcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			  sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('02', '07')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
					" group by to_char(SUBMIT_TIME, 'MM')\r\n" + 
					" order by to_char(SUBMIT_TIME, 'MM')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				  sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('02', '07')\r\n" + 
							" and region_code  ='"+region_code+"'" + 
							"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
							" group by to_char(SUBMIT_TIME, 'MM')\r\n" + 
							" order by to_char(SUBMIT_TIME, 'MM')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		//业务办理变化趋势当年线下办结
		public List<Map<String,Object>> dnxxbjcs(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
			 sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\r\n" + 
					"  from APPROVE_BUSINESS_INDEX\r\n" + 
					" where APPLY_FROM in ('02', '07')\r\n" + 
					" and region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000') \r\n" + 
					"   and FINISH_TIME is not null\r\n" + 
					"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
					" group by to_char(FINISH_TIME, 'MM')\r\n" + 
					" order by to_char(FINISH_TIME, 'MM')";
			}else{
				String region_code = KeyConstants.region_Code_Map.get(county);
				 sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\r\n" + 
							"  from APPROVE_BUSINESS_INDEX\r\n" + 
							" where APPLY_FROM in ('02', '07')\r\n" + 
							" and region_code  ='"+region_code+"'" + 
							"   and FINISH_TIME is not null\r\n" + 
							"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
							" group by to_char(FINISH_TIME, 'MM')\r\n" + 
							" order by to_char(FINISH_TIME, 'MM')";
			}
			return spyhJdbcTemplate.queryForList(sql);
		}
		
		// 网办深度--查询
		// “conduct_depth”是网办深度或审批深度：“1”是全程网办（0跑腿）；“2”是在线预审（只跑1次）；“3”是事项公开，“4”是在线申办。
		public Map<String, Object> sxxzsyjwsbls_depth(String county,String depth) {
			String sql = "";
			if (county == null || county.equals("")) {
				sql = "select sum(case when t.type = 'XK' then 1 else 0 end) XK,"
			            +" sum(case  when t.type = 'ZS' then  1  else  0  end) ZS,"
			            +" sum(case when t.type = 'QR' then 1 else 0 end) QR,"
			            +" sum(case when t.type = 'JF' then  1 else  0 end) JF,"
			            +" sum(case when t.type = 'JL' then  1  else  0 end) JL,"
			            +" sum(case  when t.type = 'CJ' then 1 else  0 end) CJ,"
			            +" sum(case when t.type = 'QT' then  1 else 0 end) QT,"
			            +" sum(case when t.type = 'GG' then  1 else 0 end) GG,"
			            +" sum(case when t.type = 'JD' then 1 else  0 end) JD"
			            +" from PROJECT_ITEM t"
			            +" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
			            +" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE "
			            +" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION "
			            +" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5' AND t.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')" 
			            +" and o.conduct_depth in ("+depth+")";
			} else {
				String region_code = KeyConstants.region_Code_Map.get(county);
				sql = "select sum(case when t.type = 'XK' then 1 else 0 end) XK,"
			            +" sum(case  when t.type = 'ZS' then  1  else  0  end) ZS,"
			            +" sum(case when t.type = 'QR' then 1 else 0 end) QR,"
			            +" sum(case when t.type = 'JF' then  1 else  0 end) JF,"
			            +" sum(case when t.type = 'JL' then  1  else  0 end) JL,"
			            +" sum(case  when t.type = 'CJ' then 1 else  0 end) CJ,"
			            +" sum(case when t.type = 'QT' then  1 else 0 end) QT,"
			            +" sum(case when t.type = 'GG' then  1 else 0 end) GG,"
			            +" sum(case when t.type = 'JD' then 1 else  0 end) JD"
			            +" from PROJECT_ITEM t"
			            +" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
			            +" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE "
			            +" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION "
			            +" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5' AND t.region_code  = '"+region_code+"'"
			            +" and o.conduct_depth in ("+depth+")";
			}
			return sxglJdbcTemplate.queryForMap(sql);
		}
		
		
		// 全区县目录和运行事项总数
		// project_item_ext.sub_type :事项服务类型：依申请服务1；主动服务2；依申请和主动服务1,2
		public String ysqgksxNumSum(String county) {
			String sql = "";
			if (county == null || county.equals("")) {
				sql = "select count(t.ID)  from PROJECT_ITEM t"
						+" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
						+" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
						+" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
						+" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5' AND t.region_code in('370125000000','370126000000','370181000000','370112000000','370102000000','370105000000','370103000000','370104000000','370113000000','370124000000','370190000000')"
						+" and t.type in('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')";
			} else {
				String region_code = KeyConstants.region_Code_Map.get(county);
				sql = "select count(t.ID)  from PROJECT_ITEM t"
						+" INNER JOIN PROJECT_ITEM_EXT E ON E.ITEM_ID=T.ID "
						+" INNER JOIN PROJECT_FOLDER F ON F.CODE=T.FOLDER_CODE"
						+" LEFT JOIN BASE_ONLINECONDUCT O ON O.ITEM_CODE=T.CODE AND O.ITEM_VERSION=T.VERSION"
						+" WHERE T.Property='0' and T.STATE='5' AND T.STATUS='5' AND t.region_code = '" + region_code+"'" 
						+" and t.type in('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')";
				}
			return sxglJdbcTemplate.queryForObject(sql, String.class);
		}
		
		
}
