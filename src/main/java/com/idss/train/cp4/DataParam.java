package com.idss.train.cp4;

import lombok.Data;

/**
 * 参数
 *
 * @author lucifer.chan
 * @create 2022-07-04 4:26 PM
 **/
@Data
public class DataParam {

    /**
     * 协议编码
     * 0101 : WEBSERVICE
     * 0102 : RESTFUL
     * 0201 : KAFKA
     * 0301 : OGG
     */
    private String protocol;

    private String data;
}
