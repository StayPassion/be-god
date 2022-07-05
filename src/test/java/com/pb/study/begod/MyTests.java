package com.pb.study.begod;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import com.pb.study.begod.entity.Article;
import com.pb.study.begod.kafka.CustomProducerListener;
import com.pb.study.begod.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
class MyTests {

    @Test
    public void redisDeleteNoKey() {
        NumberFormat numberFormat = new DecimalFormat("0.00");
        BigDecimal bigDecimal = new BigDecimal("3.435345");
        String format = numberFormat.format(bigDecimal);
        System.out.println(format);
    }

    @Test
    public void test2() {
        Article article = new Article();
        ;
        article.setTitle("-------");
        Article article1 = Optional.ofNullable(article).orElse(createArticle());
        Article article2 = Optional.ofNullable(article).orElseGet(() -> createArticle());
        log.info("article1:{}", article1);
        log.info("article2:{}", article2);
    }

    private Article createArticle() {
        Article article = new Article();
        article.setId(1L);
        return article;
    }

    @Test
    public void test3() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date dayStart = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = simpleDateFormat.format(dayStart);
        log.info("---->{}", startStr);

    }

    @Test
    public void test4() {

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(StringUtils.isNotBlank(stringBuilder));
    }

    @Test
    public void test5() {
        StringBuilder error = new StringBuilder();
        String decimal = "adcf";
        StringBuilder error2 = new StringBuilder();
        String decimal2 = "0";
        StringBuilder error3 = new StringBuilder();
        String decimal3 = "-1.012";
        StringBuilder error4 = new StringBuilder();
        String decimal4 = "-3.33";
        StringBuilder error5 = new StringBuilder();
        String decimal5 = "3.330";
        StringBuilder error6 = new StringBuilder();
        String decimal6 = "3";
        check(error, decimal);
        check(error2, decimal2);
        check(error3, decimal3);
        check(error4, decimal4);
        check(error5, decimal5);
        check(error6, decimal6);
        log.info("error------:{}", error.toString());
        log.info("error2------:{}", error2.toString());
        log.info("error3------:{}", error3.toString());
        log.info("error4------:{}", error4.toString());
        log.info("error5------:{}", error5.toString());
        log.info("error6------:{}", error6.toString());
    }

    private void check(StringBuilder error, String decimal) {
        if (StringUtils.isNotBlank(decimal)) {
            Pattern pattern = Pattern.compile("^([-+])?\\d+(\\.\\d+)?$");
            if (!pattern.matcher(decimal).matches()) {
                error.append("Invalid Original Amount;");
                return;
            }
            pattern = Pattern.compile("^([1-9][0-9]*)+(.[0-9]{1,2})?$");
            if (!pattern.matcher(decimal).matches()) {
                if (BigDecimal.ZERO.compareTo(new BigDecimal(decimal)) >= 0) {
                    error.append("Original Amount must be positive;");
                } else {
                    error.append("Original Amount supports up to two decimal places;");
                }
            }

        }


    }

    @Test
    public void test7() {
        Set<String> confirmed = Collections.singleton("Confirmed");
        List<String> frozen = confirmed.stream().filter(m -> !StringUtils.equals(m, "Frozen")).collect(Collectors.toList());
        log.info("{}", frozen);

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Collections.synchronizedCollection(new ArrayList<>());

        Map hashtable = new Hashtable();
        hashtable.put("2", 1);
        hashtable.get("2");

    }


    @Test
    public void test8() {
        String regEx = "^[A-Za-z0-9\\u4e00-\\u9fa5]+$";
        Pattern pattern = Pattern.compile(regEx);
        String sss = "中我饿违法水电费123123.12_3=0-0)“”988&！@#￥%……&*（）dladsfa!@#$%^&*()_sfdAFIUUNKK";
        char[] chars = sss.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            Matcher matcher = pattern.matcher(String.valueOf(aChar));
            // 字符串是否与正则表达式相匹配
            boolean rs = matcher.matches();
            if (rs) {
                stringBuilder.append(aChar);
            }
        }
        log.info("{}", stringBuilder);

    }

    @Test
    public void test9() {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(4444);
        list.add(33333);
        list.add(444444);
        lists.add(list);
        lists.stream().flatMap(Collection::stream).forEach(System.out::println);
        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1, 2, 3, 98),
                Arrays.asList(5, 6, 7, 998),
                null
        );

    }

    @Test
    public void test10() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            treeSet.add(RandomUtil.randomInt(0, 100));
        }
        System.out.println(treeSet);


        AtomicInteger orderNumber = new AtomicInteger(1);
        for (int i = 0; i < 5; i++) {
            String a = "Z" + i;
            String s = a + String.format(String.format("%02d", orderNumber.get()));
            orderNumber.getAndIncrement();
            System.out.println(s);
        }
    }

    @Test
    public void test11() {
        List<Article> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Article article = new Article();
            article.setId((long) i);
            article.setContent("aaa" + i);
            article.setTitle("12.4");
            list.add(article);
        }
//        log.info("before list is :{}",list);
//        List<Article> collect = list.stream().filter((u) -> u.getId() > 3).collect(Collectors.toList());
//        log.info("collect is :{}",collect);
//        list.removeAll(collect);
//        log.info("after list is :{}",list);

        list.removeIf((article -> 2 == article.getId()));
        log.info("after list is :{}", list);
    }

    @Test
    public void test12() {
        Assert.notNull("", "统一社会信用代码");
        Assert.notNull("   ", "统一社会信用代码");
        Assert.notNull(null, "统一社会信用代码");

    }
}
