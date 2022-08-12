package com.hucs.top.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: huchuansai
 * @time: 2021/6/7 5:01 下午
 */
@AllArgsConstructor
public enum WorkOrderStatusEnum {
    TO_BE_ASSIGNED("待分配"),
    IN_ORDER_POOL("工单池"),
    ORDER_RECEIVED("已接单"),
    ORDER_PROCESSING("处理中"),
    FINISHED("已完成"),
    BE_EVALUATED("已评价"),
    BE_REJECTED("已拒绝"),
    ;

    @Getter
    private final String desc;

}
