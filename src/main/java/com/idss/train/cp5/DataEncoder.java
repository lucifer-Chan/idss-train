package com.idss.train.cp5;

/**
 * @author lucifer.chan
 * @create 2022-07-11 4:55 PM
 **/
public enum DataEncoder implements Ability{

    WATERMARK("水印", 1) {

        @Override
        public String encode(String raw) {
            return "水印" + raw;
        }
    },

    SIGN("签名", 2){

        @Override
        public String encode(String raw) {
            return "签名" + raw;
        }
    },

    ENCRYPT("加密", 3){
        @Override
        public String encode(String raw) {
            return "加密" + raw;
        }
    };

    public static DataEncoder valueOf(int code) {
        DataEncoder encoder = resolve(code);
        if (encoder == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        } else {
            return encoder;
        }
    }

    public static DataEncoder resolve(int code) {
        for (DataEncoder encoder : values()) {
            if(encoder.code == code){
                return encoder;
            }
        }

        return null;
    }

    DataEncoder(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public final String description;

    public final int code;

    /**
     * encode
     * @param raw
     * @return
     */
    protected abstract String encode(String raw);

    @Override
    public String execute(String raw){
        return encode(raw);
    }
}
