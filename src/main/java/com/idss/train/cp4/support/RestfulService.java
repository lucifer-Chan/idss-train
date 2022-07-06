package com.idss.train.cp4.support;

import org.springframework.stereotype.Service;

/**
 * @author lucifer.chan
 * @create 2022-07-04 4:31 PM
 **/
@Service("protocol0102")
public class RestfulService implements ProtocolService {
    @Override
    public String apply(String s) {
        return "restful => " + s;
    }

    @Override
    public String code() {
        return "0102";
    }
}
