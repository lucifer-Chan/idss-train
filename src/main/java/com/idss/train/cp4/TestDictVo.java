package com.idss.train.cp4;

import com.third.uti.dict.annotation.Dict;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lucifer.chan
 * @create 2022-07-04 4:11 PM
 **/
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TestDictVo {

    private String name;

    @Dict(dictKey = "02_intacPort", dicField = "intacPortName")
    private String intacPort;

    @Dict(dictKey = "02_succFlag", dicField = "resultName")
    private Integer result;


    private String intacPortName;

    private String resultName;
}
