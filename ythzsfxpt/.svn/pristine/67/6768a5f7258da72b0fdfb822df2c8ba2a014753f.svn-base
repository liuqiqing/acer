package com.inspur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LibIndexService {
	
	@Resource
	@Qualifier("dzzz_jdbcTemplate")
	private JdbcTemplate dzzzJdbcTemplate;
	
	//登记单位数
	public String djdws() {
		String sql = "select count(distinct dept_organize_code) from LICENSE_DEPT_STATIS";
		return dzzzJdbcTemplate.queryForObject(sql, String.class);
	}
	
	//证照目录
	public Map<String, Object> zzml(){
		String sql = "select sum(case\r\n" + 
				"             when b.certificate_directory_status = 'checked' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) zzmlzs,\r\n" + 
				"       sum(case\r\n" + 
				"             when b.certificate_directory_status = 'checked' and\r\n" + 
				"                  b.category = 'licence' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) zzmlzz,\r\n" + 
				"       sum(case\r\n" + 
				"             when b.certificate_directory_status = 'checked' and\r\n" + 
				"                  b.category = 'approval' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) zzmlpw,\r\n" + 
				"       sum(case\r\n" + 
				"             when b.certificate_directory_status = 'checked' and\r\n" + 
				"                  b.category = 'material' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) zzmlcl\r\n" + 
				"  from LICENSE_DIR b";
		
		return dzzzJdbcTemplate.queryForMap(sql);
	}

	//按照目录统计
	public Map<String,Object> amltj(Integer startRows,Integer endRows){
		String sql = "select a.dept_name \n" +
				"       ,a.license_type_name\n" +
				"       ,a.category\n" +
				"       ,a.update_class\n" +
				"       ,a.count\n" +
				"       ,a.unsign_count\n" +
				"       ,a.last_time\n" +
				"from LICENSE_TYPE_STATIS a";

		StringBuilder sb = new StringBuilder();
		String countSql = sb.append("select count(1) from ( ").append(sql).append(")").toString();
		String num = dzzzJdbcTemplate.queryForObject(countSql, String.class);
		StringBuilder sb2 = new StringBuilder();
		String pageSql = sb2.append("select * from (select rownum r1,aa.* from ( ").append(sql).append(") aa where rownum < ?) where r1 > ?").toString();
		List<Map<String, Object>> pageList = dzzzJdbcTemplate.queryForList(pageSql, endRows, startRows);

		Map<String,Object> map = new HashMap<String, Object>();
		map.put("num",num);
		map.put("pageList",pageList);

		return map;

	}
	
	//证照数据与未签章数据
	public Map<String, Object> zzsjywqzsj(){
		String sql = "select a.Z_VALID_NUM,\r\n" + 
				"       a.P_VALID_NUM,\r\n" + 
				"       a.M_VALID_NUM,\r\n" + 
				"       (a.Z_VALID_NUM + a.P_VALID_NUM + a.M_VALID_NUM) ZPM_VALID_NUM,\r\n" + 
				"       a.Z_UNSIGN_NUM,\r\n" + 
				"       a.P_UNSIGN_NUM,\r\n" + 
				"       a.M_UNSIGN_NUM,\r\n" + 
				"       (a.Z_UNSIGN_NUM + a.P_UNSIGN_NUM + a.M_UNSIGN_NUM) ZPM_UNSIGN_NUM\r\n" + 
				"  from (select sum(valid_license) Z_VALID_NUM,\r\n" + 
				"               sum(valid_approval) P_VALID_NUM,\r\n" + 
				"               sum(valid_material) M_VALID_NUM,\r\n" + 
				"               sum(unsign_license) Z_UNSIGN_NUM,\r\n" + 
				"               sum(unsign_approval) P_UNSIGN_NUM,\r\n" + 
				"               sum(unsign_material) M_UNSIGN_NUM\r\n" + 
				"          from license_dept_statis\r\n" + 
				"         where 1 = 1) a\r\n" + 
				"";
		
		return dzzzJdbcTemplate.queryForMap(sql);
		
	}
	
	//证照模版统计-按主题统计
	public Map<String, Object> zzmbtjazttj() {
		String sql = "select sum(case\r\n" + 
				"             when a.subject_name like '%从业资格%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 从业资格,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%住房%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 住房,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%教育%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 教育,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%食品卫生%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 食品卫生,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%就业%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 就业,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%建设规划%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 建设规划,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%医疗%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 医疗,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%认证%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 认证,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%经营%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 经营,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%交通%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 交通,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%备案%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 备案,\r\n" + 
				"       sum(case\r\n" + 
				"             when a.subject_name like '%养老%' and a.state = 'effective' then\r\n" + 
				"              1\r\n" + 
				"             else\r\n" + 
				"              0\r\n" + 
				"           end) 养老\r\n" + 
				"  from LICENSE_TYPE a\r\n" + 
				"";
		return dzzzJdbcTemplate.queryForMap(sql);
	}
	
	//证照统计
	public Map<String, Object> zztjTableData(int startRows,int endRows) {
		String sql = "select a.dept_name as deptName,\r\n" + 
				"       nvl(a.template_license, 0) as templateLicense,\r\n" + 
				"       nvl(a.template_approval, 0) as templateApproval,\r\n" + 
				"       nvl(a.template_material, 0) as templateMaterial,\r\n" + 
				"       nvl(a.valid_license, 0) as validLicense,\r\n" + 
				"       nvl(a.valid_approval, 0) as validApproval,\r\n" + 
				"       nvl(a.valid_material, 0) as validMaterial,\r\n" + 
				"       nvl(a.unsign_license, 0) as unsignLicense,\r\n" + 
				"       nvl(a.unsign_approval, 0) as unsignApproval,\r\n" + 
				"       nvl(a.unsign_material, 0) as unsignMaterial\r\n" + 
				"  from LICENSE_DEPT_STATIS a\r\n" + 
				"";
		//总条数sql
		StringBuilder sb = new StringBuilder();
		String countSql = sb.append("select count(1) from (")
							.append(sql)
							.append(")")
							.toString();
		//分页sql
		StringBuilder sb2 = new StringBuilder();
		String paginationSql = sb2.append("select * from (select rownum r1, aa.* from (")
		   .append(sql)
		   .append(") aa where rownum < ?) bb where bb.r1 > ?")
		   .toString();
		//查询为分页的记录数
		String nums = dzzzJdbcTemplate.queryForObject(countSql, String.class);
		//分页查询
		List<Map<String,Object>> resultList = dzzzJdbcTemplate.queryForList(paginationSql,endRows,startRows);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("nums", nums);
		resultMap.put("resultList", resultList);
		
		return resultMap;
	}

	//证照数据与未签章数据更多数据表格
	public List<Map<String,Object>> zjsjywqzsjMoreTable(){
		String sql = "select a.dept_name as deptName,\n" +
				"       nvl(a.template_license, 0) as templateLicense,\n" +
				"       nvl(a.template_approval, 0) as templateApproval,\n" +
				"       nvl(a.template_material, 0) as templateMaterial,\n" +
				"       nvl(a.valid_license, 0) as validLicense,\n" +
				"       nvl(a.valid_approval, 0) as validApproval,\n" +
				"       nvl(a.valid_material, 0) as validMaterial,\n" +
				"       nvl(a.unsign_license, 0) as unsignLicense,\n" +
				"       nvl(a.unsign_approval, 0) as unsignApproval,\n" +
				"       nvl(a.unsign_material, 0) as unsignMaterial\n" +
				"  from LICENSE_DEPT_STATIS a";

		return dzzzJdbcTemplate.queryForList(sql);
	}


	
	
}
