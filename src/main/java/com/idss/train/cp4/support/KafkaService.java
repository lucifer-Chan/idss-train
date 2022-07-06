package com.idss.train.cp4.support;

import org.springframework.stereotype.Service;

/**
 * @author lucifer.chan
 * @create 2022-07-04 4:31 PM
 **/
@Service("protocol0201")
public class KafkaService implements ProtocolService {
    @Override
    public String apply(String s) {
        return "kafka => " + s;
    }


    @Override
    public String code() {
        return "0201";
    }
}
