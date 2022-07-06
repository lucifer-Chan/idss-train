package com.idss.train.cp4.support;

import org.springframework.stereotype.Service;

/**
 * @author lucifer.chan
 * @create 2022-07-04 4:31 PM
 **/
@Service("protocol0301")
public class OggService implements ProtocolService {
    @Override
    public String apply(String s) {
        return "OGG => " + s;
    }

    @Override
    public String code() {
        return "0301";
    }
}
