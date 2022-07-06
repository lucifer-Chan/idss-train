package com.idss.train.cp4;


import com.idss.train.cp4.support.ProtocolService;
import com.third.uti.dict.DataWrapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucifer.chan
 * @create 2022-07-04 1:34 PM
 **/
@Slf4j
@RestController
@RequestMapping("cp4")
public class Cp4Controller {

    /**
     * 前置条件: 1、Config中有@PropertySource
     *          2、spring.factories 有配置Config
     * 如果主工程有则取主工程，不然third.properties
     */
    @Value("${com.third.uti.dict.type:xxx}")
    private String dictType;

    @Autowired
    private Map<String, ProtocolService> protocolServiceMap;

    @Autowired
    private List<ProtocolService> servicesList;



    @GetMapping("dict-type")
    public String getDictType(){
        return dictType;
    }


    @GetMapping("dict-wrapper")
    public List<TestDictVo> wrapper(){

        List<TestDictVo> result = DataWrapper.wrapperList(vos);

        return result;
    }

    @PostMapping("protocol")
    public String protocol(@RequestBody DataParam param) {
        String code = param.getProtocol();
        ProtocolService service = protocolServiceMap.getOrDefault("protocol" + code, defaultProtocolService);
        return service.apply(param.getData());
    }


    @PostMapping("protocol2")
    public String protocol2(@RequestBody DataParam param) {
        String code = param.getProtocol();

        ProtocolService service = servicesList.stream()
                .filter(it -> code.equals(it.code()))
                .findAny()
                .orElse(defaultProtocolService);

        return service.apply(param.getData());
    }



    private static List<TestDictVo> vos = Arrays.asList(
            TestDictVo.builder().name("name1").intacPort("0101").result(200).build(),
            TestDictVo.builder().name("name2").intacPort("0102").result(500).build(),
            TestDictVo.builder().name("name3").intacPort("0201").result(300).build(),
            TestDictVo.builder().name("name4").intacPort("0301").result(200).build(),
            TestDictVo.builder().name("name5").intacPort("0000").result(400).build()
    );

    private static DefaultProtocolService defaultProtocolService = new DefaultProtocolService();


    private static class DefaultProtocolService implements ProtocolService {

        @Override
        public String code() {
            return null;
        }

        @Override
        public String apply(String s) {
            return s;
        }
    }
}
