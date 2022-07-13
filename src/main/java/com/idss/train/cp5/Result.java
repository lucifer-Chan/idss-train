package com.idss.train.cp5;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 能力执行结果
 * @author lucifer.chan
 * @create 2022-07-11 6:02 PM
 **/
@Data @Builder @ToString
public class Result {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 操作后的数据
     */
    private String data;

    /**
     * 耗时
     */
    private long cost;

    /**
     * 异常信息
     */
    private String exceptionMsg;
}
