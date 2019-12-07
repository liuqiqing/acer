package com.inspur.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CityLevelService {
	
	@Resource
	@Qualifier("ywtb_jdbcTemplate")
	private JdbcTemplate ywtbJdbcTemplate;

	@Resource
	@Qualifier("sxgl_jdbcTemplate")
	private JdbcTemplate sxglJdbcTemplate;
	
	@Resource
	@Qualifier("spyh_jdbcTemplate")
	private JdbcTemplate spyhJdbcTemplate;
	
	//济南市已发布事项总数，不区分服务类别和网办深度
	public String sxzlsl() {
		String sql = "select count(1)\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";

		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
	
	//线上办理事项
	public String xsblsx() {
		String sql = "select count(1)\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				"   and t.is_online in ('1', '2', '3')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE\n";
		
		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
	
	//线下办理事项
	public String xxblsx() {
		String sql = "select count(1)\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				"   and t.is_online in ('0')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";
		
		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
	//线上线下皆可办理事项
	public String xsxxblsx() {
		String sql = "select count(i.ID) xsxxblsx\n" +
				"  from PROJECT_ITEM i\n" +
				" where i.state = '5'\n" +
				"   and INSTR(i.REGION_CODE, '370100') > 0\n" +
				"   and i.status = '5'\n" +
				"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and i.PROPERTY = '0'\n" +
				"   and is_online = 3";
		
		return sxglJdbcTemplate.queryForObject(sql, String.class);
	}
	
	//审批办件类型
	public Map<String, Object> spbjlx() {
		String sql = "select sum(case\r\n" + 
					"             when a.assort = '1' then\r\n" + 
					"              1\r\n" + 
					"             else\r\n" + 
					"              0\r\n" + 
					"           end) 承诺件,\r\n" + 
					"       sum(case\r\n" + 
					"             when a.assort = '2' then\r\n" + 
					"              1\r\n" + 
					"             else\r\n" + 
					"              0\r\n" + 
					"           end) 即办件,\r\n" + 
					"       sum(case\r\n" + 
					"             when a.assort = '3' then\r\n" + 
					"              1\r\n" + 
					"             else\r\n" + 
					"              0\r\n" + 
					"           end) 上报件,\r\n" + 
					"       sum(case\r\n" + 
					"             when a.assort = '4' then\r\n" + 
					"              1\r\n" + 
					"             else\r\n" + 
					"              0\r\n" + 
					"           end) 联报件\r\n" + 
					"  from PROJECT_ITEM a\r\n" + 
					"  where a.region_code = '370100000000'";
		
		return sxglJdbcTemplate.queryForMap(sql);
	}
	
	//事项性质
	public Map<String, Object> sxxzsl() {
		String sql = "    select sum(case when i.type = 'XK' then 1 else 0 end) XK,"
				+ " sum(case when i.type = 'ZS' then 1 else 0 end) ZS,"
				+ " sum(case when i.type = 'QR' then 1 else 0 end) QR,"
				+ " sum(case when i.type = 'JF' then 1 else 0 end) JF,"
				+ " sum(case when i.type = 'JL' then 1 else 0 end) JL,"
				+ " sum(case when i.type = 'CJ' then 1 else 0 end) CJ,"
				+ " sum(case when i.type = 'QT' then 1 else 0  end) QT,"
				+ " sum(case when i.type = 'GG' then 1  else 0 end) GG,"
				+ " sum(case  when i.type = 'JD' then 1 else  0 end) JD" + " from PROJECT_ITEM  i"
				+ " where type in ('JL', 'ZS', 'QT', 'GG', 'JF', 'JD', 'XK', 'QR','CJ')  and i.state = '5'"
				+ "  and i.status = '5'   and i.region_code = '370100000000'";

		return sxglJdbcTemplate.queryForMap(sql);
	}
	
	//部门受理
	public List<Map<String, Object>> jnsbmsl() {
		String sql = "select rownum, t.sl, t.org_name\r\n" + 
				"  from (select count(*) sl, org_name\r\n" + 
				"          from APPROVE_BUSINESS_INDEX x\r\n" + 
				"         where x.submit_time is not null\r\n" + 
				"           and x.region_code = '370100000000'\r\n" + 
				"         group by org_name\r\n" + 
				"         order by sl desc) t\r\n" + 
				" where rownum <= 10";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//部门办结
	public List<Map<String, Object>> jnsbmbj() {
		String sql = "select rownum, t.sl, t.org_name\r\n" + 
				"  from (select count(*) sl, org_name\r\n" + 
				"          from APPROVE_BUSINESS_INDEX x\r\n" + 
				"         where x.finish_time is not null\r\n" + 
				"           and x.region_code = '370100000000'\r\n" + 
				"         group by org_name\r\n" + 
				"         order by sl desc) t\r\n" + 
				" where rownum <= 10";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当日线上受理次数
	public List<Map<String,Object>> drxsslcs() {
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
				"   and region_code = '370100000000'\r\n" + 
				"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
				"   and to_char(SUBMIT_TIME, 'hh24') in\r\n" + 
				"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
				" group by to_char(SUBMIT_TIME, 'hh24')\r\n" + 
				" order by to_char(SUBMIT_TIME, 'hh24')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当日线上办结次数
	public List<Map<String,Object>> drxsbjcs() {
		String sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
				"   and region_code = '370100000000'\r\n" + 
				"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
				"   and to_char(FINISH_TIME, 'hh24') in\r\n" + 
				"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
				" group by to_char(FINISH_TIME, 'hh24')\r\n" + 
				" order by to_char(FINISH_TIME, 'hh24')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当月线上受理次数
	public List<Map<String,Object>> dyxsslcs() {
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
				"   and region_code = '370100000000'\r\n" + 
				"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
				" group by to_char(SUBMIT_TIME, 'dd')\r\n" + 
				" order by to_char(SUBMIT_TIME, 'dd')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当月线上办结次数
	public List<Map<String,Object>> dyxsbjcs() {
		String sql = " select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and FINISH_TIME is not null\r\n" + 
				"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
				" group by to_char(FINISH_TIME, 'dd')\r\n" + 
				" order by to_char(FINISH_TIME, 'dd')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当年线上受理次数
	public List<Map<String,Object>> dnxsslcs() {
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
				" group by to_char(SUBMIT_TIME, 'MM')\r\n" + 
				" order by to_char(SUBMIT_TIME, 'MM')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当年线上办结次数
	public List<Map<String,Object>> dnxsbjcs() {
		String sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('01', '04', '0401')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and FINISH_TIME is not null\r\n" + 
				"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
				" group by to_char(FINISH_TIME, 'MM')\r\n" + 
				" order by to_char(FINISH_TIME, 'MM')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当日线下受理 
	public List<Map<String,Object>> drxxslcs() {
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('02', '07')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
				"   and to_char(SUBMIT_TIME, 'hh24') in\r\n" + 
				"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
				" group by to_char(SUBMIT_TIME, 'hh24')\r\n" + 
				" order by to_char(SUBMIT_TIME, 'hh24')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当日线下办结
	public List<Map<String,Object>> drxxbjcs() {
		String sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('02', '07')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and FINISH_TIME is not null\r\n" + 
				"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\r\n" + 
				"   and to_char(FINISH_TIME, 'hh24') in\r\n" + 
				"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\r\n" + 
				" group by to_char(FINISH_TIME, 'hh24')\r\n" + 
				" order by to_char(FINISH_TIME, 'hh24')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当月线下受理
	public List<Map<String,Object>> dyxxslcs() {
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('02', '07')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
				" group by to_char(SUBMIT_TIME, 'dd')\r\n" + 
				" order by to_char(SUBMIT_TIME, 'dd')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当月线下办结
	public List<Map<String,Object>> dyxxbjcs() {
		String sql = " select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('02', '07')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and FINISH_TIME is not null\r\n" + 
				"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\r\n" + 
				" group by to_char(FINISH_TIME, 'dd')\r\n" + 
				" order by to_char(FINISH_TIME, 'dd')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当年线下受理
	public List<Map<String,Object>> dnxxslcs() {
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('02', '07')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
				" group by to_char(SUBMIT_TIME, 'MM')\r\n" + 
				" order by to_char(SUBMIT_TIME, 'MM')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}
	
	//业务办理变化趋势当年线下办结
	public List<Map<String,Object>> dnxxbjcs() {
		String sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\r\n" + 
				"  from APPROVE_BUSINESS_INDEX\r\n" + 
				" where APPLY_FROM in ('02', '07')\r\n" + 
				" and region_code = '370100000000'\r\n" + 
				"   and FINISH_TIME is not null\r\n" + 
				"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" + 
				" group by to_char(FINISH_TIME, 'MM')\r\n" + 
				" order by to_char(FINISH_TIME, 'MM')";
		
		return spyhJdbcTemplate.queryForList(sql);
	}

	//济南市依申请公开的事项zz
	public String ysqgksx() {
		String sql = "select count(1)\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				"   and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE\n";


		return sxglJdbcTemplate.queryForObject(sql,String.class);
	}

	//济南市依申请公开的事项中，根据网办深度进行查询
	public String ysqgkkwsbl(){
		String sql = "select count(1)\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				"   and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and o.conduct_depth in ('1','2','4')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";

		return sxglJdbcTemplate.queryForObject(sql,String.class);
	}

	//济南市根据事项性质分类，事项总数
	public Map<String,Object> jnssxxzflsxzs(){
		String sql = "select sum(case\n" +
				"             when T.type = 'XK' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) XK,\n" +
				"       sum(case\n" +
				"             when T.type = 'ZS' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) ZS,\n" +
				"       sum(case\n" +
				"             when T.type = 'QR' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) QR,\n" +
				"       sum(case\n" +
				"             when T.type = 'JF' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JF,\n" +
				"       sum(case\n" +
				"             when T.type = 'JL' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JL,\n" +
				"       sum(case\n" +
				"             when T.type = 'CJ' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) CJ,\n" +
				"       sum(case\n" +
				"             when T.type = 'QT' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) QT,\n" +
				"       sum(case\n" +
				"             when T.type = 'GG' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) GG,\n" +
				"       sum(case\n" +
				"             when T.type = 'JD' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JD\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				"   and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";

		return sxglJdbcTemplate.queryForMap(sql);
	}
	//济南市根据事项性质分类，可网上办理的数量
	public Map<String,Object> jnssxxzflkwsbl(){
		String sql = "select sum(case\n" +
				"             when T.type = 'XK' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) XK,\n" +
				"       sum(case\n" +
				"             when T.type = 'ZS' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) ZS,\n" +
				"       sum(case\n" +
				"             when T.type = 'QR' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) QR,\n" +
				"       sum(case\n" +
				"             when T.type = 'JF' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JF,\n" +
				"       sum(case\n" +
				"             when T.type = 'JL' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JL,\n" +
				"       sum(case\n" +
				"             when T.type = 'CJ' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) CJ,\n" +
				"       sum(case\n" +
				"             when T.type = 'QT' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) QT,\n" +
				"       sum(case\n" +
				"             when T.type = 'GG' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) GG,\n" +
				"       sum(case\n" +
				"             when T.type = 'JD' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JD\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				"   and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and o.conduct_depth in ('1', '2', '4')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";

        return sxglJdbcTemplate.queryForMap(sql);
	}

	//已发布依申请公开事项,根据网办深度进行查询,市本级总数
	public String ysqgksxgjwbsdcx(String checkVal){
	    String sql = "select count(1)\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				"   and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and o.conduct_depth in ("+checkVal+")\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";

	    return sxglJdbcTemplate.queryForObject(sql,String.class);
    }
    //根据事项性质分类，根据网办深度进行查询，市本级各个分类的数量
    public Map<String, Object> jnssxxzflgjwbsdcx(String checkVal){
	    String sql = "select sum(case\n" +
				"             when T.type = 'XK' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) XK,\n" +
				"       sum(case\n" +
				"             when T.type = 'ZS' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) ZS,\n" +
				"       sum(case\n" +
				"             when T.type = 'QR' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) QR,\n" +
				"       sum(case\n" +
				"             when T.type = 'JF' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JF,\n" +
				"       sum(case\n" +
				"             when T.type = 'JL' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JL,\n" +
				"       sum(case\n" +
				"             when T.type = 'CJ' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) CJ,\n" +
				"       sum(case\n" +
				"             when T.type = 'QT' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) QT,\n" +
				"       sum(case\n" +
				"             when T.type = 'GG' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) GG,\n" +
				"       sum(case\n" +
				"             when T.type = 'JD' then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) JD\n" +
				"  FROM PROJECT_ITEM T\n" +
				" INNER JOIN PROJECT_ITEM_EXT E\n" +
				"    ON E.ITEM_ID = T.ID\n" +
				" INNER JOIN PROJECT_FOLDER F\n" +
				"    ON F.CODE = T.FOLDER_CODE\n" +
				"  LEFT JOIN BASE_ONLINECONDUCT O\n" +
				"    ON O.ITEM_CODE = T.CODE\n" +
				"   AND O.ITEM_VERSION = T.VERSION\n" +
				" WHERE T.Property = '0'\n" +
				"   and T.STATE = '5'\n" +
				"   AND T.STATUS = '5'\n" +
				"   AND T.REGION_CODE LIKE '370100%'\n" +
				"   and t.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and o.conduct_depth in ("+checkVal+")\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";

	    return sxglJdbcTemplate.queryForMap(sql);
    }

    //济南市事项受理前十名
	public List<Map<String,Object>> jnssxslqsm(){
		String sql = "select rownum, t.sl sl, t.item_name name\n" +
				"  from (select count(*) sl, item_name\n" +
				"          from APPROVE_BUSINESS_INDEX a\n" +
				"         where SUBMIT_TIME is not null\n" +
				"           and instr(a.region_code, '370100') > 0\n" +
				"         group by item_name\n" +
				"         order by sl desc) t\n" +
				" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

    //济南市事项办结前十名
	public List<Map<String,Object>> jnssxbjqsm(){
		String sql = "select rownum, t.sl sl, t.item_name name\n" +
				"  from (select count(*) sl, item_name\n" +
				"          from APPROVE_BUSINESS_INDEX a\n" +
				"         where a.finish_time is not null\n" +
				"           and instr(a.region_code, '370100') > 0\n" +
				"         group by item_name\n" +
				"         order by sl desc) t\n" +
				" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}





	
}
