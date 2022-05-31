package com.pb.study.begod.completable;

import java.util.concurrent.ExecutionException;

/**
 * @Description Calc
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/03/23 18:04
 */

public class Calc {
    public static Integer calc(Integer para) {
        try {
            //模拟一个长时间的执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para * para;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
//                .thenApply((i) -> Integer.toString(i))
//                .thenApply((str) -> "\"" + str + "\"")
//                .thenAccept(System.out::println);
//        future.get();
//    }

        int temp = 0;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 3; i++) {

                if (i == 2) {
                    continue;

                }
                System.out.println("i----" + i);
            }
            System.out.println("j====" + j);
        }
    }


}
