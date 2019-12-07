package com.inspur.dao.dzjc;

import java.util.List;
import java.util.Map;

public interface dzjcMapper {
    /**
     * 红牌数量
     * CUR_RESULT_TYPE=5
     *   @return
     */
    int hongpai();

    /**
     * 黄牌数量
     * CUR_RESULT_TYPE=2
     * @return
     */
    int huangpai();

    // 获取短信评价的信息
    List<Map<String, Object>> getwspjxx();

}
