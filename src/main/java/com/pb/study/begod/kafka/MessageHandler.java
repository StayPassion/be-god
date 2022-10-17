//package com.pb.study.begod.kafka;
//
//import com.pb.study.begod.constants.KafkaConsts;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Component;
//
///**
// * @Description MessageHandler
// * @Author bopeng@deloitte.com.cn
// * @Date 2022/04/02 0:04
// */
//
//@Component
//@Slf4j
//public class MessageHandler {
//
//    @KafkaListener(topics = KafkaConsts.TOPIC_TEST, containerFactory = "ackContainerFactory")
//    public void handleMessage(ConsumerRecord record, Acknowledgment acknowledgment) {
////        try {
////            String message = (String) record.value();
////            log.info("收到消息: {}", message);
////        } catch (Exception e) {
////            log.error(e.getMessage(), e);
////        } finally {
////            // 手动提交 offset
////            acknowledgment.acknowledge();
////        }
//
//        String message = (String) record.value();
////
////        log.info("收到消息: {}", message);
////        throw new NullPointerException("test");
//
//    }
//}