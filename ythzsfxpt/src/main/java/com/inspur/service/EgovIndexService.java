package com.inspur.service;

import java.util.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import com.inspur.dao.spyh.spyhMapper;
import com.inspur.dao.sxgl.sxglMapper;
import com.inspur.utils.DoubleUtils;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Transactional
public class EgovIndexService {

	//全部事项
	public static final String qbsxType = "'JL','ZS','QZ','CF','GG','JF','JD','ZJJG','CJ','SX','XK','QT','QR'";
	//政务服务事项
	public static final String zwfwsxType = "'JL','ZS','QZ','CF','GG','JF','JD','CJ','XK','QT','QR'";
	//依申请事项
	public static final String ysqsxType = "'XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD'";
	//试点事项
	public static final String sdsxType = "'XK','QR','JF','JL','CJ','QT'";

	@Resource
	@Qualifier("sxgl_jdbcTemplate")
	private JdbcTemplate sxglJdbcTemplate;

	@Autowired
	private sxglMapper sxglMapper;//事项管理mapper

	@Autowired
	private spyhMapper spyhMapper;//审批用户mapper

	@Resource
	@Qualifier("spyh_jdbcTemplate")
	private JdbcTemplate spyhJdbcTemplate;

	@Resource
	@Qualifier("dzjc_jdbcTemplate")
	private JdbcTemplate dzjcJdbcTemplate;

	@Resource
	@Qualifier("ywtb_jdbcTemplate")
	private JdbcTemplate ywtbJdbcTemplate;

	//事项总览
	public String sxzl(){
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
				"   AND T.REGION_CODE in ('370100000000',\n" +
				"                         '370181000000',\n" +
				"                         '370126000000',\n" +
				"                         '370105000000',\n" +
				"                         '370112000000',\n" +
				"                         '370103000000',\n" +
				"                         '370125000000',\n" +
				"                         '370124000000',\n" +
				"                         '370113000000',\n" +
				"                         '370104000000',\n" +
				"                         '370102000000',\n" +
				"                         '370190000000')\n" +
				"   and T.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";
		return sxglJdbcTemplate.queryForObject(sql,String.class);
	}

	//线上办理事项
	public String xsblsx(){
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
				"   AND T.REGION_CODE in ('370100000000',\n" +
				"                         '370181000000',\n" +
				"                         '370126000000',\n" +
				"                         '370105000000',\n" +
				"                         '370112000000',\n" +
				"                         '370103000000',\n" +
				"                         '370125000000',\n" +
				"                         '370124000000',\n" +
				"                         '370113000000',\n" +
				"                         '370104000000',\n" +
				"                         '370102000000',\n" +
				"                         '370190000000')\n" +
				"   and T.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and T.Is_Online in ('1','2','3')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE\n";
		return sxglJdbcTemplate.queryForObject(sql,String.class);
	}

	//线下办理事项
	public String xxblsx(){
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
				"   AND T.REGION_CODE in ('370100000000',\n" +
				"                         '370181000000',\n" +
				"                         '370126000000',\n" +
				"                         '370105000000',\n" +
				"                         '370112000000',\n" +
				"                         '370103000000',\n" +
				"                         '370125000000',\n" +
				"                         '370124000000',\n" +
				"                         '370113000000',\n" +
				"                         '370104000000',\n" +
				"                         '370102000000',\n" +
				"                         '370190000000')\n" +
				"   and T.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and T.Is_Online in ('0')\n" +
				" ORDER BY T.ORG_NAME, F.CODE, T.CODE";
		return sxglJdbcTemplate.queryForObject(sql,String.class);
	}


	//事项级别-市本级
	public List<Map<String,Object>> sxjbjn(){
		String sql = "select count(i.ID) jnsxsl\n" +
				"  from PROJECT_ITEM i\n" +
				" where i.state = '5'\n" +
				"   and i.status = '5'\n" +
				"   and i.PROPERTY = '0'\n" +
				"   and INSTR (i.REGION_CODE, '370100') > 0\n" +
				"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')";
		return sxglJdbcTemplate.queryForList(sql);
	}

	//事项级别-区县级
	public List<Map<String,Object>> sxjbjnqx(){
		String sql = "select count(i.ID) jnqxsxsl\n" +
				"  from PROJECT_ITEM i\n" +
				" where i.state = '5'\n" +
				"   and i.status = '5'\n" +
				"   and i.PROPERTY = '0'\n" +
				"   and i.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and i.region_code in ('370181000000',\n" +
				"                         '370126000000',\n" +
				"                         '370105000000',\n" +
				"                         '370112000000',\n" +
				"                         '370103000000',\n" +
				"                         '370125000000',\n" +
				"                         '370124000000',\n" +
				"                         '370113000000',\n" +
				"                         '370104000000',\n" +
				"                         '370102000000',\n" +
				"                         '370190000000')";
		return sxglJdbcTemplate.queryForList(sql);
	}

	//事项性质
	public List<Map<String,Object>> sxxz(){
		String sql = "select type, count(1) sxsl\n" +
				"  from PROJECT_ITEM a\n" +
				" where a.type in ('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')\n" +
				"   and state = '5'\n" +
				"   and a.status = '5'\n" +
				"   and a.property = '0'\n" +
				" group by type\n" +
				" order by count(1) desc";
		return sxglJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当日线上受理业务数量
	public List<Map<String,Object>> sxxzdrxsslywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(*) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('01', '04', '07','0401','0701')\n" +
				"                and to_char(SUBMIT_TIME, 'yyyy-MM-dd') =\n" +
				"                    to_char(sysdate, 'yyyy-MM-dd')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当日线上办结业务数量
	public List<Map<String,Object>> sxxzdrxsbjywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('01', '04', '07', '0401', '0701')\n" +
				"                and to_char(FINISH_TIME, 'yyyy-MM-dd') =\n" +
				"                    to_char(sysdate, 'yyyy-MM-dd')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当日线下受理业务数量
	public List<Map<String,Object>> sxxzdrxxslywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('02', '05', '09')\n" +
				"                and to_char(SUBMIT_TIME, 'yyyy-MM-dd') =\n" +
				"                    to_char(sysdate, 'yyyy-MM-dd')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当日线下办结业务数量
	public List<Map<String,Object>> sxxzdrxxbjywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('02', '05', '09')\n" +
				"                and to_char(FINISH_TIME, 'yyyy-MM-dd') =\n" +
				"                    to_char(sysdate, 'yyyy-MM-dd')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当月线上受理业务数量
	public List<Map<String,Object>> sxxzdyxsslywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('01', '04', '07','0401','0701')\n" +
				"                and to_char(SUBMIT_TIME, 'yyyy-MM') =\n" +
				"                    to_char(sysdate, 'yyyy-MM')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当月线上办结业务数量
	public List<Map<String,Object>> sxxzdyxsbjywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('01', '04', '07','0401','0701')\n" +
				"                and to_char(FINISH_TIME, 'yyyy-MM') =\n" +
				"                    to_char(sysdate, 'yyyy-MM')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当月线下受理业务数量
	public List<Map<String,Object>> sxxzdyxxslywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('02','05','09')\n" +
				"                and to_char(SUBMIT_TIME, 'yyyy-MM') =\n" +
				"                    to_char(sysdate, 'yyyy-MM')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当月线下办结业务数量
	public List<Map<String,Object>> sxxzdyxxbjywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('02','05','09')\n" +
				"                and to_char(FINISH_TIME, 'yyyy-MM') =\n" +
				"                    to_char(sysdate, 'yyyy-MM')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当年线上受理业务数量
	public List<Map<String,Object>> sxxzdnxsslywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('01', '04', '07','0401','0701')\n" +
				"                and to_char(SUBMIT_TIME, 'yyyy') =\n" +
				"                    to_char(sysdate, 'yyyy')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当年线上办结业务数量
	public List<Map<String,Object>> sxxzdnxsbjywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('01', '04', '07','0401','0701')\n" +
				"                and to_char(FINISH_TIME, 'yyyy') =\n" +
				"                    to_char(sysdate, 'yyyy')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当年线下受理业务数量
	public List<Map<String,Object>> sxxzdnxxslywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('02','05','09')\n" +
				"                and to_char(SUBMIT_TIME, 'yyyy') =\n" +
				"                    to_char(sysdate, 'yyyy')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类当年线下办结业务数量
	public List<Map<String,Object>> sxxzdnxxbjywsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('02','05','09')\n" +
				"                and to_char(FINISH_TIME, 'yyyy') =\n" +
				"                    to_char(sysdate, 'yyyy')\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类线上受理业务总数量
	public List<Map<String,Object>> sxxzxsslywzsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('01', '04', '07','0401','0701')\n" +
				"                and submit_time is not null\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类线上办结业务总数量
	public List<Map<String,Object>> sxxzxsbjywzsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('01', '04', '07','0401','0701')\n" +
				"                and finish_time is not null\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类线下受理业务总数量
	public List<Map<String,Object>> sxxzxxslywzsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('02','05','09')\n" +
				"                and submit_time is not null\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质分类线下办结业务总数量
	public List<Map<String,Object>> sxxzxxbjywzsl(){
		String sql = "select s.code type,\n" +
				"       (case\n" +
				"         when t.sl is null then\n" +
				"          0\n" +
				"         else\n" +
				"          sl\n" +
				"       end) sl\n" +
				"  from sxtype s\n" +
				"  left join (select count(1) sl, type\n" +
				"               from APPROVE_BUSINESS_INDEX\n" +
				"              where APPLY_FROM in ('02','05','09')\n" +
				"                and finish_time is not null\n" +
				"              group by type) t\n" +
				"    on s.code = t.type\n" +
				" order by s.code";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//按事项性质、系统、时限分类业务总数量
	public List<Map<String,Object>> sxxzxtsxywzsl(){
		String sql = "";
		String sqlCount = "";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项性质表格数据 办件量表格数据
	public LinkedHashMap<String,Object> bjlTableData(){
		final String zzr = "DC_PERSON";//自然人
		final String fr = "DC_COMPANY";//法人
		final String xm = "DC_PROJECT";//项目
        //sql语句使用not in，所以线上和线下的代码定义为恰好相反
		final String applyFromOnline = "'02','05','09'";//线上
		final String applyFromOffline = "'01','04','07','0401','0701'";//线下

		final ArrayList list1 = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
		try {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    //自然人办件总数
                    Integer zrrbjzs = spyhMapper.bjlTableData(zzr,null);
                    //自然人线上总数
                    Integer zzrxszs = spyhMapper.bjlTableData(zzr,applyFromOnline);
                    //自然人线下总数
                    Integer zzrxxzs = spyhMapper.bjlTableData(zzr,applyFromOffline);
                    //计算自然人上网率
                    String zzrswl = DoubleUtils.getDoublePercent(zzrxszs, zrrbjzs);
                    list1.add("自然人");
                    list1.add(zzrxszs);
                    list1.add(zzrxxzs);
                    list1.add(zrrbjzs);
                    list1.add(zzrswl);
                }
            });

		    Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    //法人办件总数
                    Integer frbjzs = spyhMapper.bjlTableData(fr,null);
                    //法人线上总数
                    Integer frxszs = spyhMapper.bjlTableData(fr,applyFromOnline);
                    //法人线下总数
                    Integer frxxzs = spyhMapper.bjlTableData(fr,applyFromOffline);
                    //计算法人上网率
                    String frswl = DoubleUtils.getDoublePercent(frxszs, frbjzs);
                    list2.add("法人");
                    list2.add(frxszs);
                    list2.add(frxxzs);
                    list2.add(frbjzs);
                    list2.add(frswl);
                }
            });

            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    //项目办件总数
                    Integer xmbjzs = spyhMapper.bjlTableData(xm,null);
                    //项目线上总数
                    Integer xmxszs = spyhMapper.bjlTableData(xm,applyFromOnline);
                    //项目线下总数
                    Integer xmxxzs = spyhMapper.bjlTableData(xm,applyFromOffline);
                    //计算项目上网率
                    String xmswl = DoubleUtils.getDoublePercent(xmxszs, xmbjzs);
                    list3.add("项目");
                    list3.add(xmxszs);
                    list3.add(xmxxzs);
                    list3.add(xmbjzs);
                    list3.add(xmswl);
                }
            });

		    t1.start();
		    t2.start();
		    t3.start();
		    t1.join();
		    t2.join();
		    t3.join();

		} catch (Exception e) {
			e.printStackTrace();
		}

        Double xstotal = Double.parseDouble(list1.get(1).toString())
                    + Double.parseDouble(list2.get(1).toString())
                    + Double.parseDouble(list3.get(1).toString());

        Double xxtotal = Double.parseDouble(list1.get(2).toString())
                + Double.parseDouble(list2.get(2).toString())
                + Double.parseDouble(list3.get(2).toString());

        Double total = Double.parseDouble(list1.get(3).toString())
                + Double.parseDouble(list2.get(3).toString())
                + Double.parseDouble(list3.get(3).toString());

        String totalswl = DoubleUtils.getDoublePercent(xstotal, total);
        list4.add("总数");
        list4.add(xstotal);
        list4.add(xxtotal);
        list4.add(total);
        list4.add(totalswl);

        LinkedHashMap<String,Object> map = new LinkedHashMap<String, Object>();
		map.put("list1",list1);
		map.put("list2",list2);
		map.put("list3",list3);
		map.put("list4",list4);

		return map;
	}

	//事项性质表格数据
	public Map<String, Object> sxxzTableDate(Integer startRows,Integer endRows){
		String sql = "select a.org_code,\n" +
				"       a.org_name,\n" +
				"       a.item_name,\n" +
				"       a.type,\n" +
				"       sum(case\n" +
				"             when a.submit_time is not null and\n" +
				"                  a.apply_from in ('01', '04', '0401') then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) qbslxs,\n" +
				"       sum(case\n" +
				"             when a.submit_time is not null and a.apply_from in ('02', '07') then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) qbslxx,\n" +
				"       sum(case\n" +
				"             when a.finish_time is not null and\n" +
				"                  a.apply_from in ('01', '04', '0401') then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) qbbjxs,\n" +
				"       sum(case\n" +
				"             when a.finish_time is not null and a.apply_from in ('02', '07') then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) qbbjxx,\n" +
				"       max(a.submit_time) submit_time\n" +
				"  from APPROVE_BUSINESS_INDEX a\n" +
				" group by a.org_name, a.item_name, a.org_code, a.type\n" +
				" order by a.org_code";
		StringBuilder sb = new StringBuilder();
		String countSql = sb.append("select count(1) from ( ").append(sql).append(")").toString();
		StringBuilder sb2 = new StringBuilder();
		String pageSql = sb2.append("select * from (select x.*, rownum r1 from (")
				.append(sql)
				.append(") x where rownum < ?) y where y.r1 > ?")
				.toString();

		//查询未分页的记录数
		String nums = spyhJdbcTemplate.queryForObject(countSql, String.class);
		//查询分页的数据
		List<Map<String, Object>> resultList = spyhJdbcTemplate.queryForList(pageSql, endRows,startRows);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("nums", nums);
		resultMap.put("resultList", resultList);

		return resultMap;

	}

	//事项性质表格下载
	public List<Map<String,Object>> sxxzDownload(){
		String sql = "select a.org_code,\n" +
				"       a.org_name,\n" +
				"       a.item_name,\n" +
				"       a.type,\n" +
				"       sum(case\n" +
				"             when a.submit_time is not null and\n" +
				"                  a.apply_from in ('01', '04', '0401') then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) qbslxs,\n" +
				"       sum(case\n" +
				"             when a.submit_time is not null and a.apply_from in ('02', '07') then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) qbslxx,\n" +
				"       sum(case\n" +
				"             when a.finish_time is not null and\n" +
				"                  a.apply_from in ('01', '04', '0401') then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) qbbjxs,\n" +
				"       sum(case\n" +
				"             when a.finish_time is not null and a.apply_from in ('02', '07') then\n" +
				"              1\n" +
				"             else\n" +
				"              0\n" +
				"           end) qbbjxx,\n" +
				"       max(a.submit_time) submit_time\n" +
				"  from APPROVE_BUSINESS_INDEX a\n" +
				" group by a.org_name, a.item_name, a.org_code, a.type\n" +
				" order by a.org_code";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当日线上受理次数
	public List<Map<String,Object>> xsdrslcs(){
		String sql = "SELECT COUNT(SUBMIT_TIME) SXSL, TO_CHAR(SUBMIT_TIME, 'hh24') SJ\n" +
				"  FROM APPROVE_BUSINESS_INDEX\n" +
				" WHERE APPLY_FROM IN ('01', '04', '0401','0701')\n" +
				"   AND TO_CHAR(SUBMIT_TIME, 'yyyy-MM-dd') = TO_CHAR(SYSDATE, 'yyyy-MM-dd')\n" +
				"   AND TO_CHAR(SUBMIT_TIME, 'hh24') IN\n" +
				"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
				" GROUP BY TO_CHAR(SUBMIT_TIME, 'hh24')\n" +
				" ORDER BY TO_CHAR(SUBMIT_TIME, 'hh24')";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当日线上办结次数
	public List<Map<String,Object>> xsdrbjcs(){
		String sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('01', '04', '0401', '0701')\n" +
				"   and FINISH_TIME is not null\n" +
				"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
				"   and to_char(FINISH_TIME, 'hh24') in\n" +
				"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
				" group by to_char(FINISH_TIME, 'hh24')\n" +
				" order by to_char(FINISH_TIME, 'hh24')";
	    return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当月线上受理次数
	public List<Map<String,Object>> xsdyslcs(){
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('01', '04', '0401','0701')\n" +
				"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
				" group by to_char(SUBMIT_TIME, 'dd')\n" +
				" order by to_char(SUBMIT_TIME, 'dd')";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当月线上办结次数
	public List<Map<String,Object>> xsdybjcs(){
		String sql = "select count(1) sxsl, to_char(FINISH_TIME, 'dd') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('01', '04', '0401', '0701')\n" +
				"   and FINISH_TIME is not null\n" +
				"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
				" group by to_char(FINISH_TIME, 'dd')\n" +
				" order by to_char(FINISH_TIME, 'dd')";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当年线上受理次数
	public List<Map<String,Object>> xsdnslcs(){
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('01', '04', '0401', '0701')\n" +
				"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
				" group by to_char(SUBMIT_TIME, 'MM')\n" +
				" order by to_char(SUBMIT_TIME, 'MM')";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当年线上办结次数
	public List<Map<String,Object>> xsdnbjcs(){
		String sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('01', '04', '0401', '0701')\n" +
				"   and FINISH_TIME is not null\n" +
				"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
				" group by to_char(FINISH_TIME, 'MM')\n" +
				" order by to_char(FINISH_TIME, 'MM')";
	    return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当日线下收理次数
	public List<Map<String,Object>> xxdrslcs(){
		String sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('02', '03','05','06','08')\n" +
				"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
				"   and to_char(SUBMIT_TIME, 'hh24') in\n" +
				"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
				" group by to_char(SUBMIT_TIME, 'hh24')\n" +
				" order by to_char(SUBMIT_TIME, 'hh24')";
	    return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当日线下办结次数
	public List<Map<String,Object>> xxdrbjcs(){
		String sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('02', '03', '05', '06', '08')\n" +
				"   and FINISH_TIME is not null\n" +
				"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
				"   and to_char(FINISH_TIME, 'hh24') in\n" +
				"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
				" group by to_char(FINISH_TIME, 'hh24')\n" +
				" order by to_char(FINISH_TIME, 'hh24')";
        return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当月线下受理次数
	public List<Map<String,Object>> xxdyslcs(){
		String sql = "select count(1) sxsl, to_char(SUBMIT_TIME, 'dd') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('02', '03','05','06','08')\n" +
				"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
				" group by to_char(SUBMIT_TIME, 'dd')\n" +
				" order by to_char(SUBMIT_TIME, 'dd')";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当月线下办结次数
	public List<Map<String,Object>> xxdybjcs(){
		String sql = "select count(1) sxsl, to_char(FINISH_TIME, 'dd') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('02', '03', '05', '06', '08')\n" +
				"   and FINISH_TIME is not null\n" +
				"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
				" group by to_char(FINISH_TIME, 'dd')\n" +
				" order by to_char(FINISH_TIME, 'dd')";
	    return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当年线下受理次数
	public List<Map<String,Object>> xxdnslcs(){
		String sql = "select count(1) sxsl, to_char(SUBMIT_TIME, 'MM') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('02', '03','05','06','08')\n" +
				"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
				" group by to_char(SUBMIT_TIME, 'MM')\n" +
				" order by to_char(SUBMIT_TIME, 'MM')";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//业务办理变化趋势当年线下办结次数
	public List<Map<String,Object>> xxdnbjcs(){
		String sql = "select count(1) sxsl, to_char(FINISH_TIME, 'MM') sj\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where APPLY_FROM in ('02', '03', '05', '06', '08')\n" +
				"   and FINISH_TIME is not null\n" +
				"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
				" group by to_char(FINISH_TIME, 'MM')\n" +
				" order by to_char(FINISH_TIME, 'MM')";
	    return spyhJdbcTemplate.queryForList(sql);
	}


	//事项受理前十名
	public List<Map<String,Object>> sxslqsm(){
		String sql = "select rownum,t.sl sl,t.item_name name from "+
				     "(select count(*) sl,item_name from  APPROVE_BUSINESS_INDEX where SUBMIT_TIME is not null group by item_name order by sl desc) t where rownum<=13 ";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项办结前十名
	public List<Map<String,Object>> sxbjqsm(){
		String sql = "select rownum,t.sl sl,t.item_name name from "+
			         "(select count(*) sl,item_name from  APPROVE_BUSINESS_INDEX where FINISH_TIME is not null group by item_name order by sl desc) t where rownum<=13 ";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项受理本日	author zxp
	public List<Map<String, Object>> sxslbr(){
		String sql = "select rownum, aa.item_name, aa.total"+
					 " from (SELECT a.item_name, count(1) total"+
					         " FROM APPROVE_BUSINESS_INDEX a"+
					        " where a.submit_time is not null"+
					          " and to_char(a.submit_time, 'yyyy/mm/dd') ="+
					              " to_char(sysdate, 'yyyy/mm/dd')"+
					        " group by a.item_name"+
					        " order by total desc) aa"+
					" where rownum <= 10";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项办结本日	author zxp
	public List<Map<String, Object>> sxbjbr(){
		String sql = "select rownum, aa.item_name, aa.total"+
					 " from (SELECT a.item_name, count(1) total"+
					         " FROM APPROVE_BUSINESS_INDEX a"+
					        " where a.finish_time is not null"+
					          " and to_char(a.finish_time, 'yyyy/mm/dd') ="+
					              " to_char(sysdate, 'yyyy/mm/dd')"+
					        " group by a.item_name"+
					        " order by total desc) aa"+
					" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项受理本月	author zxp
	public List<Map<String, Object>> sxslby(){
		String sql = "select rownum, aa.item_name, aa.total"+
					 " from (SELECT a.item_name, count(1) total"+
					         " FROM APPROVE_BUSINESS_INDEX a"+
					        " where a.submit_time is not null"+
					          " and to_char(a.submit_time, 'yyyy/mm') ="+
					              " to_char(sysdate, 'yyyy/mm')"+
					        " group by a.item_name"+
					        " order by total desc) aa"+
					" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项办结本月	author zxp
	public List<Map<String, Object>> sxbjby(){
		String sql = "select rownum, aa.item_name, aa.total"+
					 " from (SELECT a.item_name, count(1) total"+
					         " FROM APPROVE_BUSINESS_INDEX a"+
					        " where a.finish_time is not null"+
					          " and to_char(a.finish_time, 'yyyy/mm') ="+
					              " to_char(sysdate, 'yyyy/mm')"+
					        " group by a.item_name"+
					        " order by total desc) aa"+
					" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项受理本年	author zxp
	public List<Map<String, Object>> sxslbn(){
		String sql = "select rownum, aa.item_name, aa.total"+
					 " from (SELECT a.item_name, count(1) total"+
					         " FROM APPROVE_BUSINESS_INDEX a"+
					        " where a.submit_time is not null"+
					          " and to_char(a.submit_time, 'yyyy') ="+
					              " to_char(sysdate, 'yyyy')"+
					        " group by a.item_name"+
					        " order by total desc) aa"+
					" where rownum <= 10";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项办结本年	author zxp
	public List<Map<String, Object>> sxbjbn(){
		String sql = "select rownum, aa.item_name, aa.total"+
					 " from (SELECT a.item_name, count(1) total"+
					         " FROM APPROVE_BUSINESS_INDEX a"+
					        " where a.finish_time is not null"+
					          " and to_char(a.finish_time, 'yyyy') ="+
					              " to_char(sysdate, 'yyyy')"+
					        " group by a.item_name"+
					        " order by total desc) aa"+
					" where rownum <= 10";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项受理全部	author zxp
	public List<Map<String, Object>> sxslqb(){
		String sql = "select rownum, aa.item_name, aa.total"+
					 " from (SELECT a.item_name, count(1) total"+
					         " FROM APPROVE_BUSINESS_INDEX a"+
					        " where a.submit_time is not null"+
					        " group by a.item_name"+
					       "  order by total desc) aa"+
					" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}
	//事项办结全部	author zxp
	public List<Map<String, Object>> sxbjqb(){
		String sql = "select rownum, aa.item_name, aa.total"+
					 " from (SELECT a.item_name, count(1) total"+
					         " FROM APPROVE_BUSINESS_INDEX a"+
					        " where a.finish_time is not null"+
					        " group by a.item_name"+
					        " order by total desc) aa"+
					" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//事项统计详细	author zxp
	public Map<String, Object> sxslbjTableData(Integer startRows,Integer endRows){
		//原始sql
		String sql = "select distinct org_name,\r\n" +
				"                ITEM_NAME,\r\n" +
				"                org_code,\r\n" +
				"                sum(case\r\n" +
				"                      when submit_time is not null and\r\n" +
				"                           to_char(submit_time, 'yyyy-mm-dd') =\r\n" +
				"                           to_char(sysdate, 'yyyy-mm-dd') then\r\n" +
				"                       1\r\n" +
				"                      else\r\n" +
				"                       0\r\n" +
				"                    end) jrsl,\r\n" +
				"                sum(case\r\n" +
				"                      when finish_time is not null and\r\n" +
				"                           to_char(finish_time, 'yyyy-mm-dd') =\r\n" +
				"                           to_char(sysdate, 'yyyy-mm-dd') then\r\n" +
				"                       1\r\n" +
				"                      else\r\n" +
				"                       0\r\n" +
				"                    end) jrbj,\r\n" +
				"                sum(case\r\n" +
				"                      when submit_time is not null and\r\n" +
				"                           to_char(submit_time, 'yyyy-mm') =\r\n" +
				"                           to_char(sysdate, 'yyyy-mm') then\r\n" +
				"                       1\r\n" +
				"                      else\r\n" +
				"                       0\r\n" +
				"                    end) bysl,\r\n" +
				"                sum(case\r\n" +
				"                      when finish_time is not null and\r\n" +
				"                           to_char(finish_time, 'yyyy-mm') =\r\n" +
				"                           to_char(sysdate, 'yyyy-mm') then\r\n" +
				"                       1\r\n" +
				"                      else\r\n" +
				"                       0\r\n" +
				"                    end) bybj,\r\n" +
				"                sum(case\r\n" +
				"                      when submit_time is not null and\r\n" +
				"                           to_char(submit_time, 'yyyy') =\r\n" +
				"                           to_char(sysdate, 'yyyy') then\r\n" +
				"                       1\r\n" +
				"                      else\r\n" +
				"                       0\r\n" +
				"                    end) bnsl,\r\n" +
				"                sum(case\r\n" +
				"                      when finish_time is not null and\r\n" +
				"                           to_char(finish_time, 'yyyy') =\r\n" +
				"                           to_char(sysdate, 'yyyy') then\r\n" +
				"                       1\r\n" +
				"                      else\r\n" +
				"                       0\r\n" +
				"                    end) bnbj,\r\n" +
				"                max(submit_time) submit_time\r\n" +
				"  from APPROVE_BUSINESS_INDEX\r\n" +
				" where 1 = 1\r\n" +
				" GROUP BY ITEM_NAME, org_name, org_code\r\n" +
				" order by org_code";
		//拼接查询所有条数的sql
		StringBuilder sb = new StringBuilder();
		String countSql = sb.append("select count(1) from (").append(sql).append(")").toString();
		//拼接分页查询的sql
		StringBuilder sb2 = new StringBuilder();
		String paginationSql = sb2.append("select * from (select rownum r1, aa.* from (")
		   .append(sql)
		   .append(") aa")
		   .append(" where rownum < ?) bb")
		   .append(" where r1 > ?").toString();
		//查询未分页的记录数
		String nums = spyhJdbcTemplate.queryForObject(countSql, String.class);
		//查询分页的数据
		List<Map<String, Object>> resultList = spyhJdbcTemplate.queryForList(paginationSql, endRows,startRows);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("nums", nums);
		resultMap.put("resultList", resultList);

		return resultMap;
	}

	//事项受理办结统计表格数据下载
	public List<Map<String,Object>> egovIdnexSXQSMDownload(){
		String sql = "select distinct org_code,\n" +
				"                org_name,\n" +
				"                ITEM_NAME,\n" +
				"                sum(case\n" +
				"                      when submit_time is not null and\n" +
				"                           to_char(submit_time, 'yyyy-mm-dd') =\n" +
				"                           to_char(sysdate, 'yyyy-mm-dd') then\n" +
				"                       1\n" +
				"                      else\n" +
				"                       0\n" +
				"                    end) jrsl,\n" +
				"                sum(case\n" +
				"                      when finish_time is not null and\n" +
				"                           to_char(finish_time, 'yyyy-mm-dd') =\n" +
				"                           to_char(sysdate, 'yyyy-mm-dd') then\n" +
				"                       1\n" +
				"                      else\n" +
				"                       0\n" +
				"                    end) jrbj,\n" +
				"                sum(case\n" +
				"                      when submit_time is not null and\n" +
				"                           to_char(submit_time, 'yyyy-mm') =\n" +
				"                           to_char(sysdate, 'yyyy-mm') then\n" +
				"                       1\n" +
				"                      else\n" +
				"                       0\n" +
				"                    end) bysl,\n" +
				"                sum(case\n" +
				"                      when finish_time is not null and\n" +
				"                           to_char(finish_time, 'yyyy-mm') =\n" +
				"                           to_char(sysdate, 'yyyy-mm') then\n" +
				"                       1\n" +
				"                      else\n" +
				"                       0\n" +
				"                    end) bybj,\n" +
				"                sum(case\n" +
				"                      when submit_time is not null and\n" +
				"                           to_char(submit_time, 'yyyy') =\n" +
				"                           to_char(sysdate, 'yyyy') then\n" +
				"                       1\n" +
				"                      else\n" +
				"                       0\n" +
				"                    end) bnsl,\n" +
				"                sum(case\n" +
				"                      when finish_time is not null and\n" +
				"                           to_char(finish_time, 'yyyy') =\n" +
				"                           to_char(sysdate, 'yyyy') then\n" +
				"                       1\n" +
				"                      else\n" +
				"                       0\n" +
				"                    end) bnbj,\n" +
				"                max(submit_time) submit_time\n" +
				"  from APPROVE_BUSINESS_INDEX\n" +
				" where 1 = 1\n" +
				" GROUP BY ITEM_NAME, org_name, org_code\n" +
				" order by org_code";
		return spyhJdbcTemplate.queryForList(sql);
	}

	public Map<String, Object> sxtjxxTableData(Integer startRows,Integer endRows,
			   String orgName, String itemName,String selectType){
		String sql = "";
		if(selectType.equals("JRSL")){
			//原始sql
			sql = "select org_name, item_name, apply_subject\r\n" +
			"  from APPROVE_BUSINESS_INDEX a\r\n" +
			" where submit_time is not null\r\n" +
			"   and to_char(submit_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd')\r\n" +
			"   and org_name = ?\r\n" +
			"   and item_name = ?\r\n" +
			"";
		}else if(selectType.equals("JRBJ")){
			//原始sql
			sql = " select org_name, item_name, apply_subject\r\n" +
			"   from APPROVE_BUSINESS_INDEX a\r\n" +
			"  where finish_time is not null\r\n" +
			"    and to_char(finish_time, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd')\r\n" +
			"    and org_name = ?\r\n" +
			"    and item_name = ?\r\n" +
			"";
		}else if(selectType.equals("BYSL")){
			//原始sql
			sql = "select org_name, item_name, apply_subject\r\n" +
			"  from APPROVE_BUSINESS_INDEX a\r\n" +
			" where submit_time is not null\r\n" +
			"   and to_char(submit_time, 'yyyy-mm') = to_char(sysdate, 'yyyy-mm')\r\n" +
			"   and org_name = ?\r\n" +
			"   and item_name = ?";
		}else if(selectType.equals("BYBJ")){
			//原始sql
			sql = " select org_name, item_name, apply_subject\r\n" +
			"   from APPROVE_BUSINESS_INDEX a\r\n" +
			"  where finish_time is not null\r\n" +
			"    and to_char(finish_time, 'yyyy-mm') = to_char(sysdate, 'yyyy-mm')\r\n" +
			"    and org_name = ?\r\n" +
			"    and item_name = ?";
		}else if(selectType.equals("BNSL")){
			//原始sql
			sql = "select org_name, item_name, apply_subject\r\n" +
			"  from APPROVE_BUSINESS_INDEX a\r\n" +
			" where submit_time is not null\r\n" +
			"   and to_char(submit_time, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" +
			"   and org_name = ?\r\n" +
			"   and item_name = ?";
		}else if(selectType.equals("BNBJ")){
			//原始sql
			sql = " select org_name, item_name, apply_subject\r\n" +
			"   from APPROVE_BUSINESS_INDEX a\r\n" +
			"  where finish_time is not null\r\n" +
			"    and to_char(finish_time, 'yyyy') = to_char(sysdate, 'yyyy')\r\n" +
			"    and org_name = ?\r\n" +
			"    and item_name = ?";
		}

		StringBuilder sb = new StringBuilder();
		//总条数
		String countSql = sb.append("select count(1) from (").append(sql).append(")").toString();
		//查询未分页的记录数
		Object [] obj = new Object[]{orgName,itemName};
		String nums = (String) spyhJdbcTemplate.queryForObject(countSql, obj, String.class);

		StringBuilder sb2 = new StringBuilder();
		String paginationSql = sb2.append("select * from (select rownum r1, aa.* from (")
		.append(sql)
		.append(") aa where rownum < ?) bb where bb.r1 > ? ")
		.toString();
		//查询分页的数据
		Object [] obj2 = new Object[]{orgName,itemName,endRows,startRows};
		List<Map<String, Object>> resultList = spyhJdbcTemplate.queryForList(paginationSql,obj2);

		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("nums", nums);
		resultMap.put("resultList", resultList);

		return resultMap;
	}

	//部门受理今日	author zxp
	public List<Map<String,Object>> bmsljr(){
		String sql = "select rownum, aa.org_name, aa.total\r\n" +
					"  from (SELECT a.org_name, count(1) total\r\n" +
					"          FROM APPROVE_BUSINESS_INDEX a\r\n" +
					"         where a.submit_time is not null\r\n" +
					"           and to_char(a.submit_time, 'yyyy/mm/dd') =\r\n" +
					"               to_char(sysdate, 'yyyy/mm/dd')\r\n" +
					"         group by a.org_name\r\n" +
					"         order by total desc) aa\r\n" +
					" where rownum <= 10";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门办结今日	author zxp
	public List<Map<String,Object>> bmbjjr(){
		String sql = "select rownum, aa.org_name, aa.total\r\n" +
					"  from (SELECT a.org_name, count(1) total\r\n" +
					"          FROM APPROVE_BUSINESS_INDEX a\r\n" +
					"         where a.finish_time is not null\r\n" +
					"           and to_char(a.finish_time, 'yyyy/mm/dd') =\r\n" +
					"               to_char(sysdate, 'yyyy/mm/dd')\r\n" +
					"         group by a.org_name\r\n" +
					"         order by total desc) aa\r\n" +
					" where rownum <= 10";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门受理本月
	public List<Map<String,Object>> bmslby(){
		String sql = "select rownum, aa.org_name, aa.total\r\n" +
				"  from (SELECT a.org_name, count(1) total\r\n" +
				"          FROM APPROVE_BUSINESS_INDEX a\r\n" +
				"         where a.submit_time is not null\r\n" +
				"           and to_char(a.submit_time, 'yyyy/mm') =\r\n" +
				"               to_char(sysdate, 'yyyy/mm')\r\n" +
				"         group by a.org_name\r\n" +
				"         order by total desc) aa\r\n" +
				" where rownum <= 10";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门办结本月
	public List<Map<String,Object>> bmbjby(){
		String sql = "select rownum, aa.org_name, aa.total\r\n" +
				"  from (SELECT a.org_name, count(1) total\r\n" +
				"          FROM APPROVE_BUSINESS_INDEX a\r\n" +
				"         where a.finish_time is not null\r\n" +
				"           and to_char(a.finish_time, 'yyyy/mm') =\r\n" +
				"               to_char(sysdate, 'yyyy/mm')\r\n" +
				"         group by a.org_name\r\n" +
				"         order by total desc) aa\r\n" +
				" where rownum <= 10";

		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门受理本年
	public List<Map<String,Object>> bmslbn(){
		String sql = "select rownum, aa.org_name, aa.total\r\n" +
				"  from (SELECT a.org_name, count(1) total\r\n" +
				"          FROM APPROVE_BUSINESS_INDEX a\r\n" +
				"         where a.submit_time is not null\r\n" +
				"           and to_char(a.submit_time, 'yyyy') =\r\n" +
				"               to_char(sysdate, 'yyyy')\r\n" +
				"         group by a.org_name\r\n" +
				"         order by total desc) aa\r\n" +
				" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门办结本年
	public List<Map<String,Object>> bmbjbn(){
		String sql = "select rownum, aa.org_name, aa.total\r\n" +
				"  from (SELECT a.org_name, count(1) total\r\n" +
				"          FROM APPROVE_BUSINESS_INDEX a\r\n" +
				"         where a.finish_time is not null\r\n" +
				"           and to_char(a.finish_time, 'yyyy') =\r\n" +
				"               to_char(sysdate, 'yyyy')\r\n" +
				"         group by a.org_name\r\n" +
				"         order by total desc) aa\r\n" +
				" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门受理全部
	public List<Map<String,Object>> bmslqb(){
		String sql = "select rownum, aa.org_name, aa.total\r\n" +
				"  from (SELECT a.org_name, count(1) total\r\n" +
				"          FROM APPROVE_BUSINESS_INDEX a\r\n" +
				"         where a.submit_time is not null\r\n" +
				"         group by a.org_name\r\n" +
				"         order by total desc) aa\r\n" +
				" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门办结全部
	public List<Map<String,Object>> bmbjqb(){
		String sql = "select rownum, aa.org_name, aa.total\r\n" +
				"  from (SELECT a.org_name, count(1) total\r\n" +
				"          FROM APPROVE_BUSINESS_INDEX a\r\n" +
				"         where a.finish_time is not null\r\n" +
				"         group by a.org_name\r\n" +
				"         order by total desc) aa\r\n" +
				" where rownum <= 10";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门受理排名
	public List<Map<String,Object>> bmslpm(){
		String sql = " select rownum,t.sl sl,t.org_name org_name from "+
				     " (select count(*) sl,org_name from APPROVE_BUSINESS_INDEX  where submit_time is not null group by org_name order by sl desc) t "+
				     " where rownum<=10 ";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门办结排名
	public List<Map<String,Object>> bmbjpm(){
		String sql = "select rownum,t.sl sl,t.org_name org_name from "+
			     "(select count(*) sl,org_name from APPROVE_BUSINESS_INDEX  where FINISH_TIME is not null group by org_name order by sl desc) t "+
			     "where rownum<=10 ";
		return spyhJdbcTemplate.queryForList(sql);
	}

	//部门预警红牌数量
	public List<Map<String,Object>> bmyjhongpaisl(){
		String sql = "select count(*) sl from EA_JC_BUSIINDEX where CUR_RESULT_TYPE=5 and DONETIME is not null";
		return dzjcJdbcTemplate.queryForList(sql);
	}

	//部门预警红牌明细
	public List<Map<String,Object>> bmyjhongpaimx(){
		String sql = "select  trim(a.name) name,max(a.csts) csts,count(trim(a.name)) sl from "+
				     "(select t.DEPARTMENTNAME name,t.csts csts,t.cnts cnts from "+
	                 "(select DEPARTMENTNAME,ROUND(TO_NUMBER(DONETIME - ACCTIME)) csts,ITEMTIMELIMIT cnts from EA_JC_BUSIINDEX "+
	                 "where CUR_RESULT_TYPE=5 and DONETIME is not null) t ) a group by trim(a.name) order by csts desc ";
		return dzjcJdbcTemplate.queryForList(sql);
	}

	//部门预警黄牌数量
	public List<Map<String,Object>> bmyjhuangpaisl(){
		String sql = "select count(*) sl from EA_JC_BUSIINDEX where CUR_RESULT_TYPE=2 and DONETIME is not null";
		return dzjcJdbcTemplate.queryForList(sql);
	}

	//部门预警黄牌明细
	public List<Map<String,Object>> bmyjhuangpaimx(){
		String sql = "select  trim(a.name) name,max(a.csts) csts,count(trim(a.name)) sl from "+
			     "(select t.DEPARTMENTNAME name,t.csts csts,t.cnts cnts from "+
                 "(select DEPARTMENTNAME,ROUND(TO_NUMBER(DONETIME - ACCTIME)) csts,ITEMTIMELIMIT cnts from EA_JC_BUSIINDEX "+
                 "where CUR_RESULT_TYPE=2 and DONETIME is not null) t ) a group by trim(a.name) order by csts desc ";
		return dzjcJdbcTemplate.queryForList(sql);
	}

	/**
	 * 市直部门柱状图
	 * @param sxlx 事项类型
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	public List<Map<String,Object>> szbmsxgszzt(String sxlx,String startTime,String endTime){

		List<Map<String, Object>> zztList = null;
		switch (sxlx) {
			case "qbsx":
				zztList = sxglMapper.szbmsxgszzt(qbsxType,startTime,endTime);
				break;
			case "zwfwsx":
				zztList = sxglMapper.szbmsxgszzt(zwfwsxType,startTime,endTime);
				break;
			case "ysqsx":
				zztList = sxglMapper.szbmsxgszzt(ysqsxType,startTime,endTime);
				break;
			case "sdsx":
				zztList = sxglMapper.szbmsxgszzt(sdsxType,startTime,endTime);
				break;
		}
		return zztList;

	}

	//市直部门柱状图详细表格
	public List<Map<String,Object>> szbmsxgszztxqbg(int page,int limit){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = "select t1.rn id,t1.* from "+
				     "(select rownum rn,t.* from "+
					 "(select i.ORG_NAME ORG_NAME, "+
					         "i.REGION_NAME REGION_NAME, "+
						     "f.NAME FNAME,i.NAME INAME, "+
						     "f.AUTH_LEVEL AUTH_LEVEL, "+
						     "i.IS_ONLINE IS_ONLINE, "+
						     "i.LAW_TIME LAW_TIME, "+
						     "i.AGREE_TIME AGREE_TIME "+
						     "from PROJECT_ITEM  i left join "+
						     "PROJECT_FOLDER  f  on i.FOLDER_CODE = f.code "+
					         "where  i.state='5' and i.status='5' and i.property = '0' and i.type in('XK','ZS','QR','JF','JL','CJ','QT','GG','JD') and i.region_name='济南市') t "+
					  "where rownum<=?) t1 where t1.rn>=? ";
		String sqlCount = "select i.ORG_NAME ORG_NAME, "+
				         "i.REGION_NAME REGION_NAME, "+
					     "f.NAME FNAME,i.NAME INAME, "+
					     "f.AUTH_LEVEL AUTH_LEVEL, "+
					     "i.IS_ONLINE IS_ONLINE, "+
					     "i.LAW_TIME LAW_TIME, "+
					     "i.AGREE_TIME AGREE_TIME "+
					     "from PROJECT_ITEM  i left join "+
					     "PROJECT_FOLDER  f  on i.FOLDER_CODE = f.code "+
				         "where  i.state='5' and i.status='5' and i.property = '0' and i.type in('XK','ZS','QR','JF','JL','CJ','QT','GG','JD') and i.region_name='济南市' ";
		if(page == 0){
			list = sxglJdbcTemplate.queryForList(sqlCount);
		}else{
			List<Integer> paramsList = new ArrayList<Integer>();
			paramsList.add(page*limit);
			paramsList.add((page-1)*limit + 1);
			list = sxglJdbcTemplate.queryForList(sql,paramsList.toArray());
		}
		return list;
    }

	//市直部门柱状图详细表格
	public List<Map<String,Object>> szbmsxgszztxqbg(String sxlx,String orgName,int pageNum,int pageSize,String startTime,String endTime){
		String queryType = "";
		if(sxlx.equals("qbsx")){
			queryType = qbsxType;
		}else if(sxlx.equals("zwfwsx")){
			queryType = zwfwsxType;
		}else if(sxlx.equals("ysqsx")){
			queryType = ysqsxType;
		}else if(sxlx.equals("sdsx")){
			queryType = sdsxType;
		}else {
			queryType = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.szbmsxgszztxqbg(queryType,orgName,pageNum,pageSize,startTime,endTime);

		return list;

	}

	//区县部门柱状图
	public List<Map<String,Object>> qxbmsxgszzt(String sxlx,String startTime,String endTime){

		List<Map<String, Object>> zztList = null;
		switch (sxlx) {
			case "qbsx":
				zztList = sxglMapper.qxbmsxgszzt(qbsxType,startTime,endTime);
				break;
			case "zwfwsx":
				zztList = sxglMapper.qxbmsxgszzt(zwfwsxType,startTime,endTime);
				break;
			case "ysqsx":
				zztList = sxglMapper.qxbmsxgszzt(ysqsxType,startTime,endTime);
				break;
			case "sdsx":
				zztList = sxglMapper.qxbmsxgszzt(sdsxType,startTime,endTime);
				break;
		}
		return zztList;

	}

	//区县部门柱状图详细表格
	public List<Map<String,Object>> qxbmsxgszztxqbg(String sxlx,String orgName,int page,int limit,String startTime,String endTime){
		String queryType = "";
		if(sxlx.equals("qbsx")){
			queryType = qbsxType;
		}else if(sxlx.equals("zwfwsx")){
			queryType = zwfwsxType;
		}else if(sxlx.equals("ysqsx")){
			queryType = ysqsxType;
		}else if(sxlx.equals("sdsx")){
			queryType = sdsxType;
		}else {
			queryType = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.qxbmsxgszztxqbg(queryType, orgName, page, limit,startTime,endTime);

		return list;
	}

	//市直部门饼状图
	public Integer szbmsxgsbzt(String sxlx,String startTime,String endTime,String isOnline){

		Integer sl = null;
		switch (sxlx) {
			case "qbsx":
				sl = sxglMapper.szbmsxgsbzt(qbsxType,startTime,endTime,isOnline);
				break;
			case "zwfwsx":
				sl = sxglMapper.szbmsxgsbzt(zwfwsxType,startTime,endTime,isOnline);
				break;
			case "ysqsx":
				sl = sxglMapper.szbmsxgsbzt(ysqsxType,startTime,endTime,isOnline);
				break;
			case "sdsx":
				sl = sxglMapper.szbmsxgsbzt(sdsxType,startTime,endTime,isOnline);
				break;

		}

		return sl;

	}


	//市直部门饼状图详情表格 是否可网上办理
	public List<Map<String,Object>> szbmsxgsbztxqbg(String sxlx,String isOnline,String orgName,int page,int limit,String startTime,String endTime){
		String sxType = "";
		if(sxlx.equals("qbsx")){
			sxType = qbsxType;
		}else if(sxlx.equals("zwfwsx")){
			sxType = zwfwsxType;
		}else if(sxlx.equals("ysqsx")){
			sxType = ysqsxType;
		}else if(sxlx.equals("sdsx")){
			sxType = sdsxType;
		}else {
			sxType = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.szbmsxgsbztxqbg(sxType,isOnline,orgName, page, limit,startTime,endTime);

		return list;
	}

	//区县部门饼状图
	public Integer qxbmsxgsbzt(String sxlx,String startTime,String endTime,String isOnline){
		Integer sl = null;
		switch (sxlx) {
			case "qbsx":
				sl = sxglMapper.qxbmsxgsbzt(qbsxType,startTime,endTime,isOnline);
				break;
			case "zwfwsx":
				sl = sxglMapper.qxbmsxgsbzt(zwfwsxType,startTime,endTime,isOnline);
				break;
			case "ysqsx":
				sl = sxglMapper.qxbmsxgsbzt(ysqsxType,startTime,endTime,isOnline);
				break;
			case "sdsx":
				sl = sxglMapper.qxbmsxgsbzt(sdsxType,startTime,endTime,isOnline);
				break;

		}

		return sl;
	}


	//区县部门饼状图 详情表格
	public List<Map<String,Object>> qxbmsxgsbztxqbg(String sxlx,String isOnline,String orgName,int page,int limit,String startTime,String endTime){
		String sxType = "";
		if(sxlx.equals("qbsx")){
			sxType = qbsxType;
		}else if(sxlx.equals("zwfwsx")){
			sxType = zwfwsxType;
		}else if(sxlx.equals("ysqsx")){
			sxType = ysqsxType;
		}else if(sxlx.equals("sdsx")){
			sxType = sdsxType;
		}else {
			sxType = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.qxbmsxgsbztxqbg(sxType,isOnline,orgName, page, limit,startTime,endTime);

		return list;
	}

	/**
	 * 事项总览页面新增事项性质柱形图
	 * @param sxlx
	 * @return
	 */
	public List<Map<String,Object>> sxxzChart(String sxlx,String startTime,String endTime){

		List<Map<String, Object>> list = null;
		switch (sxlx) {
			case "qbsx":
				list = sxglMapper.sxxzChart(qbsxType,startTime,endTime);
				break;
			case "zwfwsx":
				list = sxglMapper.sxxzChart(zwfwsxType,startTime,endTime);
				break;
			case "ysqsx":
				list = sxglMapper.sxxzChart(ysqsxType,startTime,endTime);
				break;
			case "sdsx":
				list = sxglMapper.sxxzChart(sdsxType,startTime,endTime);
				break;

		}

		return list;
	}

	/**
	 * 事项总览更多页面 新增 事项性质柱形图 详情表格
	 * @return
	 */
	public List<Map<String,Object>> sxxzchartxqbg(String sxlx,String orgName,int page,int limit,String startTime,String endTime){
		String sxType = "";
		if(sxlx.equals("qbsx")){
			sxType = qbsxType;
		}else if(sxlx.equals("zwfwsx")){
			sxType = zwfwsxType;
		}else if(sxlx.equals("ysqsx")){
			sxType = ysqsxType;
		}else if(sxlx.equals("sdsx")){
			sxType = sdsxType;
		}else {
			sxType = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.sxxzchartxqbg(sxType, orgName, page, limit,startTime,endTime);

		return list;
	}

	/* 业务办理变化趋势 start */
	//部门列表
	public List<Map<String, Object>> getOrgList(int page,int limit,String orgName) {
		List<Map<String, Object>> orgList = spyhMapper.getOrgList(page, limit,orgName);

		return orgList;
	}

	//当日线上 受理次数
	public List<Map<String, Object>> day_online_accept(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01','04','07','0401','0701')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
					"   and to_char(SUBMIT_TIME, 'hh24') in\n" +
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
					" and org_code = ?\n" +
					" group by to_char(SUBMIT_TIME, 'hh24')\n" +
					" order by to_char(SUBMIT_TIME, 'hh24')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "SELECT COUNT(*) SXSL, TO_CHAR(SUBMIT_TIME, 'hh24') SJ\n" +
					"  FROM APPROVE_BUSINESS_INDEX\n" +
					" WHERE APPLY_FROM IN ('01', '04', '07', '0401', '0701')\n" +
					"   AND TO_CHAR(SUBMIT_TIME, 'yyyy-MM-dd') = TO_CHAR(SYSDATE, 'yyyy-MM-dd')\n" +
					"   AND TO_CHAR(SUBMIT_TIME, 'hh24') IN\n" +
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
					" GROUP BY TO_CHAR(SUBMIT_TIME, 'hh24')\n" +
					" ORDER BY TO_CHAR(SUBMIT_TIME, 'hh24')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当日线上 办结次数
	public List<Map<String, Object>> day_online_finish(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where FINISH_TIME is not null\n" +
					"   and APPLY_FROM in ('01','04','07','0401','0701')\n" +
					"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
					"   and to_char(FINISH_TIME, 'hh24') in\n" +
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
					"   and org_code = ?\n" +
					" group by to_char(FINISH_TIME, 'hh24')\n" +
					" order by to_char(FINISH_TIME, 'hh24')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where FINISH_TIME is not null\n" +
					"   and APPLY_FROM in ('01','04','07','0401','0701')\n" +
					"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
					"   and to_char(FINISH_TIME, 'hh24') in\n" +
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
					" group by to_char(FINISH_TIME, 'hh24')\n" +
					" order by to_char(FINISH_TIME, 'hh24')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当月线上 办结次数
	public List<Map<String, Object>> month_online_finish(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01','04','07','0401','0701')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
					"and org_code = ?\n" +
					" group by to_char(FINISH_TIME, 'dd')\n" +
					" order by to_char(FINISH_TIME, 'dd')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01','04','07','0401','0701')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
					" group by to_char(FINISH_TIME, 'dd')\n" +
					" order by to_char(FINISH_TIME, 'dd')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当月线上 受理次数
	public List<Map<String, Object>> month_online_accept(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01', '04', '07', '0401', '0701')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
					" and org_code = ?\n" +
					" group by to_char(SUBMIT_TIME, 'dd')\n" +
					" order by to_char(SUBMIT_TIME, 'dd')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01', '04', '07', '0401', '0701')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
					" group by to_char(SUBMIT_TIME, 'dd')\n" +
					" order by to_char(SUBMIT_TIME, 'dd')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当年线上 受理次数
	public List<Map<String, Object>> year_online_accept(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01', '04', '07', '0401', '0701')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
					" and org_code = ?\n" +
					" group by to_char(SUBMIT_TIME, 'MM')\n" +
					" order by to_char(SUBMIT_TIME, 'MM')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01', '04', '07', '0401', '0701')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
					" group by to_char(SUBMIT_TIME, 'MM')\n" +
					" order by to_char(SUBMIT_TIME, 'MM')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当年线上 办结次数
	public List<Map<String, Object>> year_online_finish(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01', '04', '07', '0401', '0701')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
					" and org_code = ?\n" +
					" group by to_char(FINISH_TIME, 'MM')\n" +
					" order by to_char(FINISH_TIME, 'MM')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('01', '04', '07', '0401', '0701')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
					" group by to_char(FINISH_TIME, 'MM')\n" +
					" order by to_char(FINISH_TIME, 'MM')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当日线下 受理次数
	public List<Map<String, Object>> day_offline_accept(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
					"   and to_char(SUBMIT_TIME, 'hh24') in\n" +
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
					" and org_code = ?\n" +
					" group by to_char(SUBMIT_TIME, 'hh24')\n" +
					" order by to_char(SUBMIT_TIME, 'hh24')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'hh24') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
					"   and to_char(SUBMIT_TIME, 'hh24') in\n" +
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
					" group by to_char(SUBMIT_TIME, 'hh24')\n" +
					" order by to_char(SUBMIT_TIME, 'hh24')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当日线下 办结次数
	public List<Map<String, Object>> day_offline_finish(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
					"   and to_char(FINISH_TIME, 'hh24') in\n" +
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
					"   and org_code = ?\n" +
					" group by to_char(FINISH_TIME, 'hh24')\n" +
					" order by to_char(FINISH_TIME, 'hh24')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'hh24') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy-MM-dd') = to_char(sysdate, 'yyyy-MM-dd')\n" +
					"   and to_char(FINISH_TIME, 'hh24') in\n" +
					"       ('08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18')\n" +
					" group by to_char(FINISH_TIME, 'hh24')\n" +
					" order by to_char(FINISH_TIME, 'hh24')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当月线下 受理次数
	public List<Map<String, Object>> month_offline_accept(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
					"   and org_code = ?\n" +
					" group by to_char(SUBMIT_TIME, 'dd')\n" +
					" order by to_char(SUBMIT_TIME, 'dd')" ;
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'dd') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
					" group by to_char(SUBMIT_TIME, 'dd')\n" +
					" order by to_char(SUBMIT_TIME, 'dd')" ;
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当月线下 办结次数
	public List<Map<String, Object>> month_offline_finish(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
					"   and org_code = ?\n" +
					" group by to_char(FINISH_TIME, 'dd')\n" +
					" order by to_char(FINISH_TIME, 'dd')\n";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'dd') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy-MM') = to_char(sysdate, 'yyyy-MM')\n" +
					" group by to_char(FINISH_TIME, 'dd')\n" +
					" order by to_char(FINISH_TIME, 'dd')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当年线下 受理次数
	public List<Map<String, Object>> year_offline_accept(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
					"   and org_code = ?\n" +
					" group by to_char(SUBMIT_TIME, 'MM')\n" +
					" order by to_char(SUBMIT_TIME, 'MM')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(SUBMIT_TIME, 'MM') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and to_char(SUBMIT_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
					" group by to_char(SUBMIT_TIME, 'MM')\n" +
					" order by to_char(SUBMIT_TIME, 'MM')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}

	//当年线下 办结次数
	public List<Map<String, Object>> year_offline_finish(String org_code) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = null;
		List<String> paramsList = new ArrayList<String>();
		paramsList.add(org_code);
		if(org_code != null){
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
					"   and org_code = ?\n" +
					" group by to_char(FINISH_TIME, 'MM')\n" +
					" order by to_char(FINISH_TIME, 'MM')";
			list = spyhJdbcTemplate.queryForList(sql,paramsList.toArray());
		}else {
			sql = "select count(*) sxsl, to_char(FINISH_TIME, 'MM') sj\n" +
					"  from APPROVE_BUSINESS_INDEX\n" +
					" where APPLY_FROM in ('02', '05', '09')\n" +
					"   and FINISH_TIME is not null\n" +
					"   and to_char(FINISH_TIME, 'yyyy') = to_char(sysdate, 'yyyy')\n" +
					" group by to_char(FINISH_TIME, 'MM')\n" +
					" order by to_char(FINISH_TIME, 'MM')";
			list = spyhJdbcTemplate.queryForList(sql);
		}
		return list;
	}
	/* 业务办理变化趋势 end */

	//市直部门事项个数 柱状图 下载
	public List<Map<String,Object>> szbmsxgs(String sxType,String startTime,String endTime){
		String type = "";
		if(sxType.equals("qbsx")){
			type = qbsxType;
		}else if(sxType.equals("zwfwsx")){
			type = zwfwsxType;
		}else if(sxType.equals("ysqsx")){
			type = ysqsxType;
		}else if(sxType.equals("sdsx")){
			type = sdsxType;
		}else {
			type = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.szbmsxgs(type,startTime, endTime);

		return list;
	}


	//市直部门事项个数 饼状图 下载
	public List<Map<String,Object>> szbmsxgsbztDownload(String sxType,String isOnline,String startTime,String endTime){
		String type = "";
		if(sxType.equals("qbsx")){
			type = qbsxType;
		}else if(sxType.equals("zwfwsx")){
			type = zwfwsxType;
		}else if(sxType.equals("ysqsx")){
			type = ysqsxType;
		}else if(sxType.equals("sdsx")){
			type = sdsxType;
		}else {
			type = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.szbmsxgsbztDownload(type, isOnline, startTime, endTime);

		return list;
	}

	//区县部门事项个数 柱状图 下载
	public List<Map<String,Object>> qxbmsxgs(String sxType,String startTime,String endTime){
		String type = "";
		if(sxType.equals("qbsx")){
			type = qbsxType;
		}else if(sxType.equals("zwfwsx")){
			type = zwfwsxType;
		}else if(sxType.equals("ysqsx")){
			type = ysqsxType;
		}else if(sxType.equals("sdsx")){
			type = sdsxType;
		}else {
			type = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.qxbmsxgs(type,startTime, endTime);

		return list;
	}



	//区县部门事项个数 饼状图 下载
	public List<Map<String,Object>> qxbmsxgsbztDownload(String sxType,String isOnline,String startTime,String endTime){
		String type = "";
		if(sxType.equals("qbsx")){
			type = qbsxType;
		}else if(sxType.equals("zwfwsx")){
			type = zwfwsxType;
		}else if(sxType.equals("ysqsx")){
			type = ysqsxType;
		}else if(sxType.equals("sdsx")){
			type = sdsxType;
		}else {
			type = qbsxType;
		}
		List<Map<String, Object>> list = sxglMapper.qxbmsxgsbztDownload(type, isOnline, startTime, endTime);

		return list;
	}


}
