package com.pb.study.begod;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pb.study.begod.constants.KafkaConsts;
import com.pb.study.begod.entity.Article;
import com.pb.study.begod.kafka.CustomProducerListener;
import com.pb.study.begod.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
class RedisTests {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private CustomProducerListener customProducerListener;

    @Autowired
    ArticleService articleService;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    /**
     * 测试 Redis 操作
     */
    @Test
    public void get() {
        // 测试线程安全，程序结束查看redis中count的值是否为1000
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> stringRedisTemplate.opsForValue().increment("count", 1)));
//
//        stringRedisTemplate.opsForValue().set("k1", "v1");
//        String k1 = stringRedisTemplate.opsForValue().get("k1");
//        log.debug("【k1】= {}", k1);
//
//        // 以下演示整合，具体Redis命令可以参考官方文档
        String key = "xkcoding:user:1";
        redisCacheTemplate.opsForValue().set(key, new Article(1L, "user1", "were", new BigDecimal("123.2")));
        // 对应 String（字符串）
        Article article = (Article) redisCacheTemplate.opsForValue().get(key);
        log.info("【article】= {}", article);
        log.debug("【k1】====================================");
    }

    @Test
    public void mybatisPlusTest() {
        stringRedisTemplate.opsForValue().set("test:data:id", "123123");
        String o = stringRedisTemplate.opsForValue().get("test:data:id");

        Map<String, String> map = new HashMap();
        map.put("test:data:id:1", "wo1");
        map.put("test:data:id:2", "wo2");
        map.put("test:data:id:3", "wo3");
        map.put("test:data:id:4", "wo4");
        map.put("test:data:id:5", "wo5");
        stringRedisTemplate.opsForValue().multiSet(map);

        log.info(o);


    }

    @Test
    public void redisDelete() {

        Map<String, String> map = new HashMap();
        map.put("test:data:id:1", "wo1");
        map.put("test:data:id:2", "wo2");
        map.put("test:data:id:3", "wo3");
        map.put("test:data:id:4", "wo4");
        map.put("test:data:id:5", "wo5");
        stringRedisTemplate.opsForHash().putAll("map",map);
        stringRedisTemplate.opsForHash().put("key","map","1");

        Object map1 = stringRedisTemplate.opsForHash().get("map", "test:data:id:5");
        log.info(""+map1);
        Object map2 = stringRedisTemplate.opsForHash().get("key", "map");
        log.info(""+map2);



//        try {
//            Thread.sleep(10*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        stringRedisTemplate.delete(map.keySet());


    }

    @Test
    public void redisDeleteNoKey() {
        Boolean delete = stringRedisTemplate.delete("ra:s:1");
        System.out.println(delete);
    }



}
