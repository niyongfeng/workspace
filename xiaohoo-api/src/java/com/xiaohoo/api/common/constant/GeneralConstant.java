package com.xiaohoo.api.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用常量类
 */
public class GeneralConstant {

    public final static Map<Integer, Integer> P2PTAG = new HashMap<Integer, Integer>() {
        {
            put(1, 14); // 国资系
            put(2, 15); // 上市公司系
            put(3, 20); // 创业平台
        }
    };

    // 风险等级(1 2 3 4 5)  谨慎型产品(R1)、稳健型产品(R2)、平衡型产品(R3)、进取型产品(R4)、激进型产品(R5)
    public final static Map<Integer, String> RISKRANK = new HashMap<Integer, String>() {
        {
            put(1, "谨慎型产品"); // 谨慎型产品
            put(2, "稳健型产品"); // 稳健型产品
            put(3, "平衡型产品"); // 平衡型产品
            put(4, "进取型产品"); // 进取型产品
            put(5, "激进型产品"); // 激进型产品
        }
    };
}
