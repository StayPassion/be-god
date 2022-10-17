//package com.pb.study.begod;
//
//import cn.hutool.core.convert.Convert;
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.pb.study.begod.config.ArticleDtoTest;
//import com.pb.study.begod.constants.KafkaConsts;
//import com.pb.study.begod.entity.Article;
//import com.pb.study.begod.kafka.CustomProducerListener;
//import com.pb.study.begod.service.ArticleService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.TimeUnit;
//
//@SpringBootTest
//@Slf4j
//class BeGodApplicationTests {
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    @Autowired
//    private CustomProducerListener customProducerListener;
//
//    @Autowired
//    ArticleService articleService;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    /**
//     * 测试发送消息
//     */
//    @Test
//    public void testSend() {
//        kafkaTemplate.setProducerListener(customProducerListener);
//        kafkaTemplate.send(KafkaConsts.TOPIC_TEST, "hello,kafka...");
//
//    }
//
//    @Test
//    public void mybatisPlusTest() {
//        Article article = new Article();
//        article.setContent("法国作家写");
//        article.setTitle("巴黎圣母院");
//        article.setMoney(new BigDecimal("12.5"));
//        boolean save = articleService.save(article);
//        log.info("save result is " + save);
//
//    }
//
//    @Test
//    public void mybatisPlusUpdateTest() {
//        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", 3);
//        Article one = articleService.getOne(queryWrapper);
//        one.setTitle("巴黎圣母院2");
//        one.setContent(null);
//        LambdaQueryWrapper<Article> rjQuery = new LambdaQueryWrapper<>();
//        rjQuery.eq(Article::getId, "3");
//
//        articleService.update(one, rjQuery);
//    }
//
//    @Test
//    public void mybatisPlusQueryTest() {
//        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.select(Article::getContent, Article::getTitle);
//        queryWrapper.eq(Article::getId, 3);
//        List<Article> list = articleService.list(queryWrapper);
//        log.info("{}", list);
//
//    }
//
//    @Test
//    public void mybatisPlusDeleteTest() {
//        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Article::getId, 2);
//        List<Article> list = articleService.list(queryWrapper);
//        log.info("-------------------->{}", list);
//        boolean remove = articleService.remove(queryWrapper);
//        log.info("---------------{}", remove);
//
//    }
//
//    @Test
//    public void test3() {
//        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.select(Article::getMoney);
//        List<String> list = articleService.listObjs(queryWrapper, (u) -> String.valueOf(u));
//        log.info("-------------------->{}", list);
//        Object o = "ssss";
//        String s = Convert.toStr(o);
//        System.out.println(s);
//    }
//
//    @Test
//    public void test4() {
//        for (int i = 0; i < 6; i++) {
//            Object bean = applicationContext.getBean(ArticleDtoTest.class);
//            System.out.println(bean);
//        }
//
//    }
//
//    @Test
//    public void test5() {
//        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Article::getId, 6);
//      Article article = articleService.getOne(queryWrapper);
//        article.setContent("xxxxxx");
//        List<Article> list = new ArrayList<>();
//        list.add(article);
//        Article article1 = new Article();
//        article1.setTitle("oooo");
//        list.add(article1);
//        articleService.saveOrUpdateBatch(list);
//
//    }
//
//    @Autowired
//    private ThreadPoolTaskExecutor executor;
//
//    @Test
//    public void test6() throws InterruptedException {
//        CompletableFuture<Integer> voidCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.info("222");
//            return 222;
//        }, executor);
//        voidCompletableFuture2.whenComplete((v1,v2)->{
//            log.info("v1----{}",v1);
//            log.info("v2----{}",v2);
//        });
//        TimeUnit.SECONDS.sleep(10);
//    }
//
//
//}
