package com.idss.train.cp5;

import java.util.EnumSet;

import static com.idss.train.cp5.DataEncoder.ENCRYPT;
import static com.idss.train.cp5.DataEncoder.WATERMARK;

/**
 * @author lucifer.chan
 * @create 2022-07-11 5:24 PM
 **/
public class EnumTest {

    public static void main(String[] args) {


        System.out.println(Color.resolve(3).description);

    }


    private static void encode1(int code, String data) {
        DataEncoder encoder = DataEncoder.valueOf(code);

        switch (encoder) {
            case ENCRYPT:
                //... handle data
                break;
            case WATERMARK:
                //...
                break;
            case SIGN:
                //...
                break;
            default:
                System.out.println("xxxx");
        }
    }

    private static void encode2(int code, String data) {
        DataEncoder encoder = DataEncoder.valueOf(code);

        encoder.handle(data);
    }





    private static void testEncode() {
        System.out.println(encode(1, "hello"));
        System.out.println(encode(2, "hello"));
        System.out.println(encode(3, "hello"));
        System.out.println(encode(4, "hello"));
    }

    private static void testResult(){
        System.out.println(result(DataEncoder.SIGN, "sssss"));
        System.out.println(result(DataDecoder.DECRYPT, "fail"));
    }

    private static void testEnumSet() {
        //1 - ordinal()
        System.out.println(EnumSet.range(WATERMARK, ENCRYPT));
    }

    /**
     * 编码
     * @param code
     * @param data
     * @return
     */
    private static String encode(int code, String data){
        DataEncoder encoder = DataEncoder.valueOf(code);
        return encoder.encode(data);
    }

    /**
     * 处理
     * @param ability
     * @param data
     * @return
     */
    private static Result result(Ability ability, String data) {
        return ability.handle(data);
    }


}
