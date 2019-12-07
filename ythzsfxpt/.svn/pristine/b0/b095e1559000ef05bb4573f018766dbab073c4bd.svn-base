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
public class LibLicenseService {

    @Resource
    @Qualifier("dzzz_jdbcTemplate")
    private JdbcTemplate dzzzJdbcTemplate;

    /**
     * 查询总数
     */
    public String szqxzs(){
        String sql = "select count(a.dept_organize_code) sl\n" +
                "  from LICENSE_CONTENTS a";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 市直占比
     */
    public String szzb(){
        String sql = "select count(a.dept_organize_code) sl\n" +
                "  from LICENSE_CONTENTS a\n" +
                " where instr(a.dept_organize_code, '370100') > 0";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);

    }

    /**
     * 区县占比
     */
    public String qxzb(){
        String sql = "select count(a.dept_organize_code) sl\n" +
                "  from LICENSE_CONTENTS a\n" +
                " where instr(a.dept_organize_code, '370100') = 0";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     *
     * 证照颁发情况柱形图
     *
     */
    public List<Map<String,Object>> zzbfqkzxt(){
        String sql = "select *\n" +
                "  from (select a.license_type_name, count(a.license_name) sl\n" +
                "          from LICENSE_CONTENTS a\n" +
                "         group by a.license_type_name\n" +
                "         order by count(a.license_type_name) desc)\n" +
                " where rownum < 11";

        return dzzzJdbcTemplate.queryForList(sql);
    }

    /**
     *
     * 颁发单位总数
     *
     */
    public String bfdwzs(){
        /*String sql = " SELECT COUNT(1)\n" +
                "   FROM (SELECT DEPT_ORGANIZE_CODE\n" +
                "           FROM LICENSE_CONTENTS A\n" +
                "          WHERE A.DEPT_ORGANIZE_CODE IS NOT NULL\n" +
                "          GROUP BY DEPT_ORGANIZE_CODE\n" +
                "          ORDER BY NULL)";*/

        String sql = "SELECT COUNT(1)\n" +
                "  FROM (SELECT DISTINCT ISSUING_ORGANIZATION\n" +
                "          FROM LICENSE_DIR_ORG\n" +
                "         WHERE ISSUING_ORGANIZATION IS NOT NULL)";


        return dzzzJdbcTemplate.queryForObject(sql,String.class);

    }

    /**
     * 个人证照总数
     */
    public String grzzzs(){
        String sql = "select count(holder_type) grzzzs from LICENSE_CONTENTS where holder_type = 'natural'";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 教师资格证
     */
    public String jszgz(){
        String sql = "select count(license_type_name) from LICENSE_CONTENTS a where a.license_type_name = '教师资格证'";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 旅行社经营许可证
     */
    public String lxsjyxk(){
        String sql = "select count(a.license_no)\n" +
                "  from LICENSE_CONTENTS a\n" +
                " where a.license_type_name = '旅行社业务经营许可证'";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }
    /**
     * 事业单位法人证书
     */
    public String sydwfrzs(){
        String sql = "select count(1)\n" +
                "  from LICENSE_CONTENTS a\n" +
                " where a.license_type_name like '%法人证书%'";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 残疾人证书
     */
    public String cjrzs(){
        String sql = "select count(1)\n" +
                "  from LICENSE_CONTENTS a\n" +
                " where a.license_type_name like '%残疾%'";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }
    /**
     * 法人证照数量
     */
    public String frzzsl(){
        String sql = "select count(1) from LICENSE_CONTENTS where holder_type = 'enterprises'";
        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }
    /**
     * 证照类型总数
     */
    public String zzlxzs(){
        /*String sql = "SELECT COUNT(1)\n" +
                "     FROM (SELECT A.LICENSE_TYPE_NAME\n" +
                "             FROM LICENSE_CONTENTS A\n" +
                "            WHERE A.LICENSE_TYPE_NAME IS NOT NULL\n" +
                "            GROUP BY A.LICENSE_TYPE_NAME\n" +
                "            ORDER BY NULL)";*/

        String sql = "select count(1) from LICENSE_TYPE where STATE = 'effective'";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);

    }

    /**
     * 证照状态 注销
     */
    public String zzztzxsl(){
        String sql = "SELECT COUNT(1) ZXSL FROM LICENSE_CONTENTS_INVALID";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 证照状态 废止
     */
    public String zzztfzsl(){
        String sql = "SELECT COUNT(1) FZSL FROM LICENSE_ABOLISH_RECORD";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 证照状态 签章
     */
    public String zzztqzsl(){
        String sql = "SELECT COUNT(1) QZSL\n" +
                "  FROM LICENSE_CONTENTS A\n" +
                " WHERE A.STATE = 'signed'\n" +
                " ORDER BY NULL ";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 证照状态 超期
     */
    public String zzztcqsl(){
        String sql = "SELECT COUNT(1) CQSL\n" +
                "  FROM LICENSE_CONTENTS\n" +
                " WHERE VALID_PERIOD_END IS NOT NULL\n" +
                "   AND SYSDATE > VALID_PERIOD_END\n" +
                " ORDER BY NULL ";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 建设工程规划许可证情况
     */
    public List<Map<String,Object>> jsgcghxkz(){
        String sql = "SELECT TO_CHAR(A.CERTIFICATE_DATE, 'yyyy') NF,\n" +
                "       COUNT(TO_CHAR(A.CERTIFICATE_DATE, 'yyyy')) SL\n" +
                "  FROM LICENSE_CONTENTS A\n" +
                " WHERE A.LICENSE_TYPE_NAME IS NOT NULL\n" +
                "   AND A.LICENSE_TYPE_NAME = '建设工程规划许可证'\n" +
                " GROUP BY TO_CHAR(A.CERTIFICATE_DATE, 'yyyy')\n" +
                " ORDER BY TO_CHAR(A.CERTIFICATE_DATE, 'yyyy') ASC";

        return dzzzJdbcTemplate.queryForList(sql);
    }


    /**
     *  企业、个人工商营业执照
     */
    public List<Map<String,Object>> qygrgsyyzz(){
        String sql = "SELECT TO_CHAR(A.CERTIFICATE_DATE, 'yyyy') NF,\n" +
                "       COUNT(TO_CHAR(A.CERTIFICATE_DATE, 'yyyy')) SL\n" +
                "  FROM LICENSE_CONTENTS A\n" +
                " WHERE A.LICENSE_TYPE_NAME IS NOT NULL\n" +
                "   AND A.LICENSE_TYPE_NAME = '营业执照'\n" +
                "   AND TO_CHAR(A.CERTIFICATE_DATE, 'yyyy') IN\n" +
                "       (SELECT TO_CHAR(SYSDATE, 'YYYY') - LEVEL + 1\n" +
                "          FROM DUAL\n" +
                "        CONNECT BY LEVEL <= 10)\n" +
                " GROUP BY TO_CHAR(A.CERTIFICATE_DATE, 'yyyy')\n" +
                " ORDER BY TO_CHAR(A.CERTIFICATE_DATE, 'yyyy') asc";

        return dzzzJdbcTemplate.queryForList(sql);

    }

    /**
     * 部门证照数量
     */
    public List<Map<String,Object>> bmzzsl(){
        String sql = "SELECT * FROM (SELECT A.DEPT_NAME, COUNT(A.DEPT_NAME) SL\n" +
                "  FROM LICENSE_CONTENTS A\n" +
                "  WHERE A.STATE = 'valid'\n" +
                " GROUP BY A.DEPT_NAME\n" +
                " ORDER BY COUNT(A.DEPT_NAME) DESC)\n" +
                " WHERE ROWNUM < 11";

        return  dzzzJdbcTemplate.queryForList(sql);


    }

    /**
     * 济南市颁发电子证照总数
     */
    public String jnsdzzz(){
        //String sql = "select count(1) from LICENSE_CONTENTS a where a.state = 'valid'";
        String sql = "select COUNT(1) from  license_contents";

        return dzzzJdbcTemplate.queryForObject(sql,String.class);
    }

    /**
     * 市区证照情况
     */
    public List<Map<String,Object>> sqzzqk(){
        String sql = "SELECT DISTRICTS_NAME DEPT_NAME, COUNT(DISTRICTS_NAME) SL\n" +
                "  FROM LICENSE_CONTENTS\n" +
                "  WHERE DISTRICTS_NAME IS NOT NULL\n" +
                " GROUP BY DISTRICTS_NAME\n" +
                " ORDER BY COUNT(DISTRICTS_NAME) DESC";

        return dzzzJdbcTemplate.queryForList(sql);

    }



}
