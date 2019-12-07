package com.inspur.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IndexService {
	
	@Resource
	@Qualifier("dv_db_gdp_jdbcTemplate")
	private JdbcTemplate dvDbGdpJdbcTemplate;

	@Resource
	@Qualifier("ywtb_jdbcTemplate")
	private JdbcTemplate ywtbJdbcTemplate;
	
	@Resource
	@Qualifier("sxgl_jdbcTemplate")
	private JdbcTemplate sxglJdbcTemplate;
	
	//今日受理办结数量
	public List<Map<String,Object>> jrslbjsl(){
		  StringBuilder sql = new StringBuilder();
		  sql.append("select t1.itemnums, t2.itemnumsed, t1.organnums, t2.organnumsed, t1.pronums,t2.pronumsed from ");
		  sql.append("(select count(DISTINCT ITEMNAME) itemnums,count(DISTINCT ACCEPTDEPTNAME) organnums, count(PROJECTNAME) pronums, '1' as num from QZKZH ");
		  sql.append("where to_char(submit_time,'yyyy-mm-dd')=to_char(sysdate,'yyyy-mm-dd') union all ");
		  sql.append("select count(DISTINCT ITEMNAME) itemnums,count(DISTINCT ACCEPTDEPTNAME) organnums, count(PROJECTNAME) pronums, '2' as num  from QZKZH ");
		  sql.append("where to_char(submit_time,'yyyy-mm')=to_char(sysdate,'yyyy-mm') union all ");
		  sql.append("select count(DISTINCT ITEMNAME) itemnums,count(DISTINCT ACCEPTDEPTNAME) organnums, count(PROJECTNAME) pronums, '3' as num  from QZKZH ");
		  sql.append("where to_char(submit_time,'yyyy')=to_char(sysdate,'yyyy')) t1, ");
		  sql.append("(select count(DISTINCT ITEMNAME) itemnumsed,count(DISTINCT ACCEPTDEPTNAME) organnumsed, count(PROJECTNAME) pronumsed, '1' as num  from QZKZH ");
		  sql.append("where to_char(finish_time,'yyyy-mm-dd')=to_char(sysdate,'yyyy-mm-dd') union all ");
		  sql.append("select count(DISTINCT ITEMNAME) itemnumsed,count(DISTINCT ACCEPTDEPTNAME) organnumsed, count(PROJECTNAME) pronumsed, '2' as num  from QZKZH ");
		  sql.append("where to_char(finish_time,'yyyy-mm')=to_char(sysdate,'yyyy-mm') union all ");
		  sql.append("select count(DISTINCT ITEMNAME) itemnumsed,count(DISTINCT ACCEPTDEPTNAME) organnumsed, count(PROJECTNAME) pronumsed, '3' as num  from QZKZH ");
		  sql.append("where to_char(finish_time,'yyyy')=to_char(sysdate,'yyyy')) t2 where t1.num = t2.num");
		  return ywtbJdbcTemplate.queryForList(sql.toString());
	}
	
	//今日服务接口调用次数
	public List<Map<String,Object>> jrfwjkdycs(){
		String sql = "SELECT total from dc_api_region_call where concat(create_time)=left(concat(SYSDATE()),10)";
		return dvDbGdpJdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> onlineConduct() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select t.online_status, count(*) as count_is_online from BASE_ONLINECONDUCT t where t.conduct_depth  in ('1','2','3','4') group by t.ONLINE_STATUS");
		List<Map<String, Object>> queryForList = sxglJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}

	public List<Map<String, Object>> getListNoServiceOrg() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select count(DISTINCT(ORGAN_CODE)) as count_org,c.DATASET_TYPE as source_type from dc_data_catalog c where c.`STATUS` in ('3','6','7','8') and c.DATASET_TYPE in ('电子文件','数据库') GROUP BY c.DATASET_TYPE");
		List<Map<String, Object>> queryForList = dvDbGdpJdbcTemplate.queryForList(sql.toString());
		return queryForList;
	}
}
