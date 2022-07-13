package com.idss.train.cp5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucifer.chan
 * @create 2022-07-12 10:25 AM
 **/
@Slf4j
@RestController
@RequestMapping("cp5")
public class Cp5Controller {

    /**
     *
     * @param param
       {
         "encoder" : "SIGN",
         "data" : "hello world"
       }
     * @return
     */
    @PostMapping("test")
    public Result test(@RequestBody Param param){
        return param.getEncoder().handle(param.getData());
    }

    @GetMapping("test")
    public String test(DataEncoder encoder, String data){
        return encoder.execute(data);
    }
}
