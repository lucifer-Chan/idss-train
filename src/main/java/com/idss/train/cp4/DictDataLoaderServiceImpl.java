package com.idss.train.cp4;

import com.third.uti.dict.service.DictDataLoaderService;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @author lucifer.chan
 * @create 2022-07-04 4:12 PM
 **/
@Service
public class DictDataLoaderServiceImpl implements DictDataLoaderService {
    @Override
    public Map<String, String> read() {
        return new HashMap<String, String>(){
            {
                put("02_intacPort_0101", "WEBSERVICE");
                put("02_intacPort_0102", "RESTFUL");
                put("02_intacPort_0201", "KAFKA");
                put("02_intacPort_0301", "OGG");
                put("02_succFlag_200", "成功");
                put("02_succFlag_500", "失败");
            }
        };
    }

    /**
     * 刷新周期, 默认10分种刷一次
     * @return
     */
    @Override
    public Duration period(){
        //1小时刷新一次
        return Duration.ofHours(1L);
    }
}
