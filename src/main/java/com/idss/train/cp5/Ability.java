package com.idss.train.cp5;

/**
 * 能力
 * @author lucifer.chan
 * @create 2022-07-11 6:03 PM
 **/
public interface Ability {

    /**
     * 执行能力
     * @param raw
     * @return
     */
    String execute(String raw);

    /**
     *
     * @param raw
     * @return
     */
    default Result handle(String raw) {
        long startTime = System.currentTimeMillis();
        try {
            String data = execute(raw);
            return Result.builder()
                    .success(true)
                    .data(data)
                    .cost(System.currentTimeMillis() - startTime)
                .build();
        } catch (Exception e) {
            return Result.builder()
                    .success(false)
                    .cost(System.currentTimeMillis() - startTime)
                    .exceptionMsg(e.getMessage())
                .build();
        }
    }
}
