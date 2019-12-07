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
public class ShareResourceService {

	@Resource
	@Qualifier("dv_db_gdp_jdbcTemplate")
	private JdbcTemplate gdpJdbcTemplate;

	@Resource
	@Qualifier("dv_db_gop_jdbcTemplate")
	private JdbcTemplate gopJdbcTemplate;

	// 统计库表数、文件数
	public Map<String, Object> getCataTotal() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t1.total_cata_count, t2.count_db_table, t3.count_file "
				+ "from (select count(DISTINCT CATA_ID) as total_cata_count "
				+ "from dc_data_catalog c where c.`STATUS` in ('3','6','7','8') " + ")t1, "
				+ "(select count(DISTINCT CATA_ID) as count_db_table " + "from dc_data_catalog c where 1=1 "
				+ "and c.DATASET_TYPE in('数据库' , '自描述格式')" + "and c.`STATUS` in ('3','6','7','8'))t2, "
				+ "(select count(DISTINCT CATA_ID) as count_file "
				+ "from dc_data_catalog c where 1=1 AND c.DATASET_TYPE <> '数据库' and c.DATASET_TYPE <> '自描述格式' "
				+ "and c.`STATUS` in ('3','6','7','8'))t3");
		List<Map<String, Object>> queryForList = gdpJdbcTemplate.queryForList(sql.toString());
		Map<String, Object> map = queryForList.get(0);
		return map;
	}

	// 统计接口数
	public Map<String, Object> getServiceTotal() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select count(DISTINCT c.service_id) as total_service from api_service_catalog  c where c.status = '2'");
		List<Map<String, Object>> queryForList = gopJdbcTemplate.queryForList(sql.toString());
		Map<String, Object> map = queryForList.get(0);
		return map;
	}

	// 各部门可共享资源目录数
	public List<Map<String, Object>> bmCatalogTj() {
		String sql = "SELECT a.`CODE` as code,a.NAME as name , count(b.TITLE) as cataLogNum"
				+ " FROM dv_db_gom.pub_organ a " + " JOIN dv_db_gdp.dc_data_catalog b" + " ON a.CODE = b.ORGAN_CODE "
				+ " WHERE a.REGION_NAME='济南市' AND b.STATUS IN('3','6','7','8') GROUP BY a.CODE"
				+ " ORDER BY cataLogNum DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}

	// 现有资源数 :资源总数
	public List<Map<String, Object>> xyResourceTj_zy() {
		String sql = "SELECT organ_name AS organ_name, kbNum+jkNum+wjNum as zyNum,kbNum,jkNum,wjNum"
				+" FROM ( SELECT organ_name AS organ_name, ifnull(gz_kb,0) AS kbNum, ifnull(gz_wj,0) AS wjNum, ifnull(gz_jk,0)  AS jkNum"
				+" FROM dc_count_jns ) t where kbNum + jkNum + wjNum<>0 ORDER BY zyNum DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}
	
	// 现有资源数 :有效库表
	public List<Map<String, Object>> xyResourceTj_kb() {
		String sql = "SELECT organ_name,sum(case WHEN organ_name is null then 0 else 1 end) as kbNum,sum(table_rows) as shjNum"
				+ " FROM dv_db_gdp.dc_55table " + " where organ_name is not NULL" + " GROUP BY organ_name order by kbNum DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}
	// 现有资源数 :数据量 
	public List<Map<String, Object>> xyResourceTj_shjL() {
		String sql = "SELECT organ_name,sum(case WHEN organ_name is null then 0 else 1 end) as kbNum,sum(table_rows) as shjNum"
				+ " FROM dv_db_gdp.dc_55table " + " where organ_name is not NULL" + " GROUP BY organ_name order by shjNum DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}
	// 现有资源数 :接口
	public List<Map<String, Object>> xyResourceTj_jk() {
		String sql = "SELECT a.ORGAN_NAME as organ_name,sum(case WHEN organ_name is null then 0 else 1 end) as jkNum"
		+" FROM (SELECT ORGAN_NAME,ORGAN_CODE FROM dv_db_gdp.dc_data_catalog"
		+" WHERE REGION_NAME='济南市' AND `STATUS`IN('3','6','7','8') GROUP BY ORGAN_CODE) a"
		+" JOIN dv_db_gop.api_service_info b  ON a.ORGAN_CODE=b.ORG_CODE  GROUP BY b.ORG_CODE ORDER BY jkNum  DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}

	// 现有资源数 :文件
	public List<Map<String, Object>> xyResourceTj_wj() {
		String sql = "SELECT organ_name AS organ_name, ifnull(gz_wj, 0) AS wjNum FROM dc_count_jns where ifnull(gz_wj, 0) <>0 ORDER BY (wjNum+0) DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}
	// 申请省级资源情况:申请接口数（项）
	public List<Map<String,Object>> shqshjResourceQk_shqzyNum(){
		String sql ="SELECT t.ORGAN_NAME organ_name, count(t.ORGAN_NAME) applyNum FROM ("
				+" SELECT DISTINCT SERVICE_ID + organ_code, ORGAN_NAME, ORGAN_CODE FROM api_service_apply"
				+" WHERE service_name LIKE '%国%' OR service_name LIKE '%省%' ) t GROUP BY t.ORGAN_CODE"
				+" ORDER BY applyNum DESC";
		return gopJdbcTemplate.queryForList(sql);
	}

	// 申请省级资源情况:累计接口调用（次）
	public List<Map<String, Object>> shqshjResourceQk_ljJkDyNum() {
		String sql = "SELECT t.ORGAN_NAME organ_name, sum(t.call_times) JkNum FROM"
				+ " (SELECT call_times, ORGAN_NAME, ORGAN_CODE FROM api_service_apply WHERE"
				+ " service_name LIKE '%国%' OR service_name LIKE '%省%' AND call_times > 0 ) t"
				+ " GROUP BY t.ORGAN_CODE ORDER BY JkNum DESC";
		return gopJdbcTemplate.queryForList(sql);
	}
	
	// 申请市级资源情况:申请资源数（项） 、申请资源数（次）、通过数（次）、驳回数（次）
	public List<Map<String, Object>> applyCityResourceQK_applyZyNum() {
		String sql = "SELECT organ_name AS organ_name, if(apply is null,0,apply) AS zyNum, if(applys is null, 0,applys) AS zyCount, if(ok is null,0,ok) AS tgCount,"
				+" if(bh is null ,0,bh ) AS bhCount FROM dc_count_jns WHERE apply IS NOT NULL and apply <> '' ORDER BY (zyNum+0) DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}

	// 申请市级资源情况:申请接口数（个）、申请数（次）、通过数（次）、驳回数（次）、累计接口调用（次）
	public List<Map<String, Object>> applyCityResourceQK_applyJkNum() {
		String sql = "SELECT organ_name AS organ_name, apply_sz AS jkNum, if(applys_sz is null,0,applys_sz) AS jkCount,"
				+ " if(sz_ok is null,0,sz_ok) AS tgCount, if(sz_no is null,0,sz_no) AS bhCount, if(sz_calls is null,0,sz_calls) AS ljjkNum"
				+ " FROM dc_count_service where apply_sz is not NULL ORDER BY (apply_sz+0) DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}

	// 申请市级资源情况:累计接口调用（次）
	public List<Map<String, Object>> applyCityResourceQK_totalJkDyNum() {
		String sql = "select t.ORGAN_NAME as organ_name,sum(t.call_times) ljjkNum from ("
				+ " select call_times,ORGAN_NAME,ORGAN_CODE  from api_service_apply where service_name not like '%国%' and service_name  not  like '%省%' and call_times>0) t "
				+ " GROUP BY t.ORGAN_CODE  order by ljjkNum desc";
		return gopJdbcTemplate.queryForList(sql);
	}

	// 市级资源提供响应情况 :资源:被申请数（项）
	public List<Map<String, Object>> cityZyProvideQK_bShqZyNum() {
		String sql = "SELECT organ_name, count(organ_name) bzy FROM dc_data_catalog t1,"
				+ " (select  distinct cata_id from dc_data_apply_course) t2"
				+ " WHERE t2.cata_id = t1.cata_id AND t1.REGION_NAME = '济南市' GROUP BY t1.ORGan_CODE order by bzy DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}
	
	// 市级资源提供响应情况 :资源:被申请次数（次）
	public List<Map<String, Object>> cityZyProvideQK_bShqZyCshNum() {
		String sql = "SELECT organ_name, count(organ_name) bshzy FROM dc_data_catalog t1, dc_data_apply_course t2"
				+ " WHERE t2.cata_id = t1.cata_id AND t1.REGION_NAME = '济南市' GROUP BY t1.ORGan_CODE order by bshzy DESC";
		return gdpJdbcTemplate.queryForList(sql);
	}
	
	// 市级资源提供响应情况 :资源:被申请通过次数（次）
	public List<Map<String, Object>> cityZyProvideQK_bShqZyTgNum() {
		String sql = "SELECT organ_name, count(ORGAN_CODE) bshtgzy FROM dc_data_apply_course s,"
				+ " dc_data_catalog c WHERE s.cata_id=c.CATA_ID and c.REGION_NAME = '济南市'"
				+ " AND s.STATUS = 1 GROUP BY ORGAN_CODE ORDER BY bshtgzy DESC";
		return gdpJdbcTemplate.queryForList(sql);
		}
		
		
		// 市级资源提供响应情况 :接口:被申请数（项）
		public List<Map<String, Object>> cityZyProvideQK_bShqJkNum() {
			String sql = "SELECT org_name, count(org_name) bjkNum FROM (select distinct service_id from  api_service_apply) t1,"
					+ "api_service_info t2 WHERE t2.id = t1.service_id GROUP BY t2.org_code ORDER BY bjkNum DESC";
			return gopJdbcTemplate.queryForList(sql);
		}
		
		// 市级资源提供响应情况 :接口:被申请次数（次）
		public List<Map<String, Object>> cityZyProvideQK_bShqJkCshNum() {
			String sql = "SELECT org_name, count(org_name) bjkCount FROM api_service_apply t1, api_service_info t2"
					+ " WHERE t2.id = t1.service_id GROUP BY t2.org_code ORDER BY bjkCount DESC";
			return gopJdbcTemplate.queryForList(sql);
		}
		
		// 市级资源提供响应情况 :接口:被申请通过次数（次）
		public List<Map<String, Object>> cityZyProvideQK_bShqJkTgNum() {
			String sql = "SELECT t2.ORG_NAME org_name, count(t2.ORG_NAME) btgCount FROM api_service_apply t1, api_service_info t2"
					+ " WHERE t2.id = t1.service_id and t2.REGION_NAME = '济南市' AND t1.STATUS = 1 GROUP BY t2.ORG_CODE ORDER BY btgCount DESC";
			return gopJdbcTemplate.queryForList(sql);
		}
		
		// 区县资源情况：数据资源目录总数
		public List<Map<String,Object>> qxZyQk_zymlNum(){
			String sql = "SELECT region_name, count(REGION_code) zymlNum FROM dc_data_catalog WHERE STATUS IN (3, 6, 7, 8) GROUP BY REGION_code order by zymlNum desc";
			return gdpJdbcTemplate.queryForList(sql);
		}
		
		// 区县资源情况：文件（新）
		public List<Map<String, Object>> qxZyQk_gzZymLNum_N() {
			String sql ="SELECT f.region_name region_name,count(f.region_code) zygjNum_x from (select distinct cata_id,region_name,region_code  from dv_db_gdp.dc_source_file where is_mark=2)f "
					+" GROUP BY f.region_code ORDER BY zygjNum_x DESC";
			return gdpJdbcTemplate.queryForList(sql);
		}
		
		// 区县资源情况：接口
		public List<Map<String, Object>> qxZyQk_gzJkList() {
			String sql = "SELECT REGION_NAME region_name, count(REGION_CODE) qxjkNum FROM dv_db_gop.api_service_info GROUP BY REGION_CODE";
					return gopJdbcTemplate.queryForList(sql);
				}

	// 区县资源情况：库表（只为济南市数据）
	public List<Map<String, Object>> qxZyQk_gzkbList() {
		String sql = "select '济南市' as region_name ,count(*) as jnkbNum from dc_55table where table_rows>0  ";
		return gdpJdbcTemplate.queryForList(sql);
	}
}
