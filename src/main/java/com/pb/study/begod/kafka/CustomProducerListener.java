package com.pb.study.begod.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @Description CustomProducerListener
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/04/14 19:44
 */


@Component
@Slf4j
public class CustomProducerListener implements ProducerListener<String, String> {

    /**
     * 成功回调
     */
    @Override
    public void onSuccess(ProducerRecord<String, String> producerRecord,
                          RecordMetadata recordMetadata) {
       log.info("推送成功，推送数据：" + producerRecord);
    }

    /**
     * 失败回调
     */
    public void onError(ProducerRecord<String, String> producerRecord, Exception exception) {
        System.out.println("推送失败，推送数据：" + producerRecord.value() + "，失败原因：" + exception.getMessage());
    }
}

