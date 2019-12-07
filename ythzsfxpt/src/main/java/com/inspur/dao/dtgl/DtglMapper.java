package com.inspur.dao.dtgl;

import java.util.List;
import java.util.Map;

public interface DtglMapper {

    // 获取短信评价 当月
    List<Map<String, Object>> getdxpjxx(String Cdate);

    // 获取短信评价各业务处室
    List<Map<String, Object>> getmsgxx(String Cdate);

}
