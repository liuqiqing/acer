package com.inspur.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShareIndexService {

	@Resource
	@Qualifier("dv_db_gop_jdbcTemplate")
	private JdbcTemplate gopJdbcTemplate;

	@Resource
	@Qualifier("dv_db_gdp_jdbcTemplate")
	private JdbcTemplate gdpJdbcTemplate;
	//获取数据交换总数
	public Map<String, Object> getDataExchangeCount() {
		StringBuilder sql = new StringBuilder();
		sql.append("select sum(apply.failed_times)+sum(apply.success_times) as total_count,"
				+ "sum(apply.success_times) as sum_success_times," + "sum(apply.failed_times) as sum_failed_times "
				+ "from api_service_apply apply");

		List<Map<String, Object>> queryForList = gopJdbcTemplate.queryForList(sql.toString());
		Map<String, Object> map = queryForList.get(0);
		return map;
	}

	public Map<String, Object> getCataTotal() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t1.total_cata_count, t2.count_db_table, t3.count_file "
				+ "from (select count(DISTINCT CATA_ID) as total_cata_count "
				+ "from dc_data_catalog c where c.`STATUS` in ('3','6','7','8') " + ")t1, "
				+ "(select count(DISTINCT CATA_ID) as count_db_table " + "from dc_data_catalog c where 1=1 "
				+ "and c.DATASET_TYPE='数据库' " + "and c.`STATUS` in ('3','6','7','8'))t2, "
				+ "(select count(DISTINCT CATA_ID) as count_file "
				+ "from dc_data_catalog c where 1=1 and c.DATASET_TYPE='电子文件' "
				+ "and c.`STATUS` in ('3','6','7','8'))t3");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		Map<String, Object> map = queryForList.get(0);
		return map;
	}

	public Map<String, Object> getServiceTotal() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select count(DISTINCT c.service_id) as total_service from api_service_catalog  c where c.status = '2'");
		List<Map<String, Object>> queryForList = gopJdbcTemplate.queryForList(sql.toString());
		Map<String, Object> map = queryForList.get(0);
		return map;
	}

	public List<Map<String, Object>> getListServiceOrg() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select DISTINCT(SERVICE_ID),i.org_code,i.org_name from api_service_catalog  c, api_service_info i where c.service_id = i.id and c.status = '2'");
		List<Map<String, Object>> queryForList = gopJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

	public List<Map<String, Object>> getListNoServiceOrg() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select DISTINCT(ORGAN_CODE),ORGAN_NAME from dc_data_catalog c where c.`STATUS` in ('3','6','7','8')");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

	public List<Map<String, Object>> getHotSource() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select n.cata_name,count(*) as count_num from dc_catalog_need n GROUP BY cata_name ORDER BY count_num DESC ,cata_name LIMIT 5");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

	public List<Map<String, Object>> getHotOrg() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select count(DISTINCT CATA_ID) as count_cata,c.organ_name from dc_data_catalog c where  c.`STATUS` in ('3','6','7','8') GROUP BY c.organ_name ORDER BY count_cata desc LIMIT 6");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

	public List<Map<String, Object>> getHotOrgShare() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select count(DISTINCT CATA_ID) as count_cata,c.organ_name from dc_data_catalog c where  c.`STATUS` in ('3','6','7','8') GROUP BY c.organ_name ORDER BY count_cata desc LIMIT 8");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

	public Map<String, Object> getShareType() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select (select count(DISTINCT CATA_ID) as total_cata_count_condition from dc_data_catalog c where c.`STATUS` in ('3','6','7','8') and c.SHARE_TYPE = '2')as total_cata_count_condition, (select count(DISTINCT CATA_ID) from dc_data_catalog c where c.`STATUS` in ('3','6','7','8') and c.SHARE_TYPE = '1')as total_cata_count_nocondition");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		Map<String, Object> map = queryForList.get(0);
		return map;
	}

	public List<Map<String, Object>> getSourceUseFile() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT a.count_file,b.month_file from  (select count(c.PUBLISH_DATE) as count_file,FROM_UNIXTIME( UNIX_TIMESTAMP(c.PUBLISH_DATE),'%m' ) as mon from dc_data_catalog c where  c.DATASET_TYPE='电子文件' and c.`STATUS` in ('3','6','7','8') AND FROM_UNIXTIME( UNIX_TIMESTAMP(c.PUBLISH_DATE),'%Y' ) = year(now()) GROUP BY mon) a RIGHT JOIN (SELECT '01' as month_file from  DUAL UNION ALL SELECT '02' as month_file from  DUAL UNION ALL SELECT '03' as month_file from  DUAL UNION ALL SELECT '04' as month_file from  DUAL UNION ALL SELECT '05' as month_file from  DUAL UNION ALL SELECT '06' as month_file from  DUAL UNION ALL SELECT '07' as month_file from  DUAL UNION ALL SELECT '08' as month_file from  DUAL UNION ALL SELECT '09' as month_file from  DUAL UNION ALL SELECT '10' as month_file from  DUAL UNION ALL SELECT '11' as month_file from  DUAL UNION ALL SELECT '12' as month_file from  DUAL )b on a.mon = b.month_file");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

	public List<Map<String, Object>> getSourceUseDbTable() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT a.count_dbtable,b.month_dbtable from  (select count(c.PUBLISH_DATE) as count_dbtable,FROM_UNIXTIME( UNIX_TIMESTAMP(c.PUBLISH_DATE),'%m' ) as mon from dc_data_catalog c where  c.DATASET_TYPE='电子文件' and c.`STATUS` in ('3','6','7','8') AND FROM_UNIXTIME( UNIX_TIMESTAMP(c.PUBLISH_DATE),'%Y' ) = year(now()) GROUP BY mon) a RIGHT JOIN (SELECT '01' as month_dbtable from  DUAL UNION ALL SELECT '02' as month_dbtable from  DUAL UNION ALL SELECT '03' as month_dbtable from  DUAL UNION ALL SELECT '04' as month_dbtable from  DUAL UNION ALL SELECT '05' as month_dbtable from  DUAL UNION ALL SELECT '06' as month_dbtable from  DUAL UNION ALL SELECT '07' as month_dbtable from  DUAL UNION ALL SELECT '08' as month_dbtable from  DUAL UNION ALL SELECT '09' as month_dbtable from  DUAL UNION ALL SELECT '10' as month_dbtable from  DUAL UNION ALL SELECT '11' as month_dbtable from  DUAL UNION ALL SELECT '12' as month_dbtable from  DUAL )b on a.mon = b.month_dbtable");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

	public List<Map<String, Object>> getSourceUseService() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT a.count_service,b.month_service from  "
				+ "(select count(c.PUBLISH_time) as count_service,"
				+ "FROM_UNIXTIME( UNIX_TIMESTAMP(c.PUBLISH_time),'%m' ) as mon from api_service_catalog c where c.status = '2' and "
				+ "FROM_UNIXTIME( UNIX_TIMESTAMP(c.PUBLISH_time),'%Y' ) = year(now()) "
				+ "GROUP BY mon) a RIGHT JOIN (SELECT '01' as month_service from  DUAL UNION ALL  "
				+ "SELECT '02' as month_service from  DUAL UNION ALL SELECT '03' as month_service "
				+ "from  DUAL UNION ALL SELECT '04' as month_service from  DUAL UNION ALL SELECT '05' as month_service "
				+ "from  DUAL UNION ALL SELECT '06' as month_service from  DUAL UNION ALL SELECT '07' as month_service "
				+ "from  DUAL UNION ALL SELECT '08' as month_service from  DUAL UNION ALL SELECT '09' as month_service "
				+ "from  DUAL UNION ALL SELECT '10' as month_service from  DUAL UNION ALL SELECT '11' as month_service "
				+ "from  DUAL UNION ALL SELECT '12' as month_service from  DUAL )b on a.mon = b.month_service");
		List<Map<String, Object>> queryForList = gopJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

}
