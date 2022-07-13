package com.idss.train.cp5;

/**
 * @author lucifer.chan
 * @create 2022-07-11 6:10 PM
 **/
public enum DataDecoder implements Ability {

    DECRYPT("解密", 11) {
        @Override
        public String decode(String data) {
            try {
                Thread.sleep(1234);
            } catch (InterruptedException ignored) {

            }

            if("fail".equalsIgnoreCase(data)){
                throw new IllegalArgumentException("参数错误");
            }

            return data + "已解密";
        }
    },

    VERIFY("验签", 12) {
        @Override
        public String decode(String data) {
            return data + "已验签";
        }
    };


    DataDecoder(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public final String description;

    public final int code;

    /**
     * decode
     * @param data
     * @return
     */
    protected abstract String decode(String data);

    @Override
    public String execute(String data) {
        return decode(data);
    }


}
