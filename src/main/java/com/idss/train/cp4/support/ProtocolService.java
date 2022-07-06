package com.idss.train.cp4.support;

import java.util.function.UnaryOperator;

/**
 * 协议服务
 *
 * @author lucifer.chan
 * @create 2022-07-04 4:29 PM
 **/
public interface ProtocolService extends UnaryOperator<String> {

    String code();

}

