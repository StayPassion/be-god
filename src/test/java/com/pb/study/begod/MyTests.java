package com.pb.study.begod;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pb.study.begod.domain.dto.BpmNodeConfigDto;
import com.pb.study.begod.entity.Article;
import com.pb.study.begod.entity.Employee;
import com.pb.study.begod.entity.Student;
import com.pb.study.begod.enums.DepartmentEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

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

    @Test
    public void test13() {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        jsonObject2.put("code", "123123");
        jsonObject2.put("message", "zzzzzzzzzzzz");

        jsonObject.put("result", jsonObject2);
        jsonObject.put("id", 1);

        String s = Optional.ofNullable(jsonObject3)
                .map((u) -> u.getJSONObject("result"))
                .map((u) -> u.getString("message2"))
                .orElseThrow(() -> new RuntimeException("baocuo"));
        System.out.println(s);
    }

    @Test
    public void test14() {
        List list = new ArrayList();
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        jsonObject2.put("code", "123123");
        jsonObject2.put("message", "zzzzzzzzzzzz");

        jsonObject.put("result", jsonObject2);
        jsonObject.put("id", 1);

//        String s = Optional.ofNullable(jsonObject3)
//                .map((u) -> u.getJSONObject("result"))
//                .map((u) -> u.getString("message2"))
//                .orElseThrow(() -> new RuntimeException("baocuo"));
//        System.out.println(s);

        Optional.ofNullable(jsonObject).ifPresent((u) -> {
            log.info("{}", u);
        });
    }

    @Test
    public void test17() {
        EnumSet<DepartmentEnum> departmentEnums = EnumSet.allOf(DepartmentEnum.class);
        boolean indirect_indirect = departmentEnums.contains(DepartmentEnum.Indirect_Indirect);
        System.out.println(indirect_indirect);
    }

    @Test
    public void test18() {
        ArrayList<BpmNodeConfigDto> list = Lists.newArrayList();

        BpmNodeConfigDto bpmNodeConfigDto1 = new BpmNodeConfigDto();
        BpmNodeConfigDto bpmNodeConfigDto2 = new BpmNodeConfigDto();
        BpmNodeConfigDto bpmNodeConfigDto3 = new BpmNodeConfigDto();
        BpmNodeConfigDto bpmNodeConfigDto4 = new BpmNodeConfigDto();
        bpmNodeConfigDto1.setSecondCondition(new BigDecimal("1000"));
        bpmNodeConfigDto2.setSecondCondition(new BigDecimal("500"));
        bpmNodeConfigDto3.setSecondCondition(new BigDecimal("1500"));
        bpmNodeConfigDto4.setSecondCondition(new BigDecimal("2000"));

        list.add(bpmNodeConfigDto1);
        list.add(bpmNodeConfigDto2);
        list.add(bpmNodeConfigDto3);
        list.add(bpmNodeConfigDto4);
        BigDecimal money = new BigDecimal("2000.00001");

        List<BpmNodeConfigDto> collect = list.stream()
                .filter((bpmNodeConfigDto -> 0 < bpmNodeConfigDto.getSecondCondition().compareTo(money)))
                .sorted(Comparator.comparing(BpmNodeConfigDto::getSecondCondition))
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(collect.isEmpty());

    }

    @Test
    public void test19() {
        double aDouble1 = 1500D;
        double aDouble2 = 1500.0000;
        System.out.println(aDouble1 == aDouble2);


        BigDecimal bigDecimal1 = new BigDecimal(aDouble1);
        BigDecimal bigDecimal2 = new BigDecimal(aDouble2);

        double v1 = bigDecimal1.doubleValue();
        double v2 = bigDecimal2.doubleValue();
        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        System.out.println(v1 == v2);

        BigDecimal bigDecimal3 = new BigDecimal("0.1");
        BigDecimal bigDecimal4 = new BigDecimal(0.1F);

        System.out.println(bigDecimal3);
        System.out.println(bigDecimal4);


    }

    @Test
    public void test20() {
        List<BpmNodeConfigDto> list = Lists.newArrayList();

        BpmNodeConfigDto bpmNodeConfigDto1 = new BpmNodeConfigDto();
        BpmNodeConfigDto bpmNodeConfigDto2 = new BpmNodeConfigDto();
        BpmNodeConfigDto bpmNodeConfigDto3 = new BpmNodeConfigDto();
        BpmNodeConfigDto bpmNodeConfigDto4 = new BpmNodeConfigDto();
        bpmNodeConfigDto1.setSecondCondition(new BigDecimal("1500"));
        bpmNodeConfigDto2.setSecondCondition(new BigDecimal("500"));
        bpmNodeConfigDto3.setSecondCondition(new BigDecimal("1800"));
        bpmNodeConfigDto4.setSecondCondition(new BigDecimal("2000"));

        bpmNodeConfigDto1.setFirstCondition("1500");
        bpmNodeConfigDto2.setFirstCondition("500");
        bpmNodeConfigDto3.setFirstCondition("1500");
        bpmNodeConfigDto4.setFirstCondition("2000");

        list.add(bpmNodeConfigDto1);
        list.add(bpmNodeConfigDto2);
        list.add(bpmNodeConfigDto3);
        list.add(bpmNodeConfigDto4);

        list = list.stream()
                .sorted(Comparator.comparing(BpmNodeConfigDto::getSecondCondition).reversed())
                .collect(Collectors.toList());

        Map<String, List<BpmNodeConfigDto>> collect = list.stream()
                .collect(Collectors.groupingBy(BpmNodeConfigDto::getFirstCondition));
        System.out.println(collect);

    }

    @Test
    public void test21() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 8);
        int index = list.indexOf(4);
        System.out.println(index);
        System.out.println(list.subList(0, index));
        System.out.println(list.subList(index, index + 1));
        System.out.println(list.subList(index + 1, list.size()));
        System.out.println();
    }

    @Test
    public void test22() {

        Map<String, Employee> map1 = new HashMap<>();
        Map<String, Employee> map2 = new HashMap<>();

        Employee employee1 = new Employee(1L, "Henry");
        map1.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map1.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map1.put(employee3.getName(), employee3);

        Employee employee4 = new Employee(2L, "George");
        map2.put(employee4.getName(), employee4);
        Employee employee5 = new Employee(3L, "Henry");
        map2.put(employee5.getName(), employee5);

        Employee employee6 = new Employee(6L, "John");

        Map<String, Employee> map3 = new HashMap<>(map1);
//        map3.merge(employee6.getName(), employee6, (k, v) -> employee6);
//        System.out.println();

//        map3.merge(key, value, (v1, v2) -> new Employee(v1.getId(), v2.getName()));

        map2.forEach(
                (key, value) -> map3.merge(key, value, (v1, v2) -> {

                    System.out.println("key:" + key);
                    System.out.println("value:" + value);
                    System.out.println("v1:" + v1);
                    System.out.println("v2:" + v2);

                    return new Employee(v1.getId(), v2.getName());
                }));
        System.out.println();

    }


    @Test
    public void test23() {
        int[] nums = new int[]{10,1,3,-1,-3,5,3,6,7};
//        int[] nums = new int[]{1};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(ints);

    }


//    public int[] maxSlidingWindow(int[] nums, int k) {
//        List<Integer> data = new ArrayList<>();
//
//        if (nums.length <= k) {
//            int maxValue = getMaxValue(nums);
//            data.add(maxValue);
//            return data.stream().mapToInt(Integer::valueOf).toArray();
//        }
//
//        Queue<Integer> queue = initQueue(nums, k);
//
//        for (int i = k; i <= nums.length; i++) {
//            data.add(getMaxValue(queue));
//            queue.poll();
//            queue.add(nums[i]);
//        }
//        return data.stream().mapToInt(Integer::valueOf).toArray();
//    }

    public int getMaxValue(int[] nums) {
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > value) {
                value = nums[i];
            }
        }
        return value;
    }

    public int getMaxValue(Queue<Integer> queue) {

        int size = queue.size();
        Queue<Integer> temp = new ArrayDeque<>();
        int first = queue.peek();
        for (int i = 0; i < size; i++) {
            int value = queue.poll();
            temp.add(value);
            if (value > first) {
                first = value;
            }
        }
        for (int i = 0; i < size; i++) {
            queue.add(temp.poll());
        }
        return first;
    }

    public Queue<Integer> initQueue(int[] nums, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        return queue;
    }

    @Test
    public void test24() {
        int arr1[] = new int[]{1, 2, 3, 4, 5};
        int arr2[] = new int[]{7, 8, 9, 10, 11};
        int arr3[] = new int[10];
//        System.arraycopy(arr2, 0, arr3, 0, 3);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr2.length; i++) {

            queue.offer(arr2[i]);
        }

        System.out.println(queue);
        int maxValue = getMaxValue(queue);
        System.out.println();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    /*
    class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> data = new ArrayList<>();

        if (nums.length <= k) {
            int maxValue = getMaxValue(nums);
            data.add(maxValue);
            return data.stream().mapToInt(Integer::valueOf).toArray();
        }
        int[] temp = new int[k];
        for (int i = 0; i <= nums.length-k; i++) {
            System.arraycopy(nums, i, temp, 0, k);
            data.add(getMaxValue(temp));
        }
        return data.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int getMaxValue(int[] nums) {
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > value) {
                value = nums[i];
            }
        }
        return value;
    }
}
     */

    @Test
    public void test25(){
        PriorityQueue<Article> queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1.getMoney().compareTo(o2.getMoney()) == 0) {
                return ((int) (o2.getId() - o1.getId()));
            }
            return o2.getMoney().compareTo(o1.getMoney());
        }));

        Article article1 = new Article();
        Article article2 = new Article();
        Article article3 = new Article();
        Article article4 = new Article();
        article1.setMoney(new BigDecimal("15.5"));
        article2.setMoney(new BigDecimal("10.5"));
        article3.setMoney(new BigDecimal("11.5"));
        article4.setMoney(new BigDecimal("15.5"));
        article1.setId(1L);
        article2.setId(3L);
        article3.setId(2L);
        article4.setId(4L);
        queue.add(article1);
        queue.add(article2);
        queue.add(article3);
        queue.add(article4);


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
    @Test
    public void test26(){
        PriorityQueue<Student> q = new PriorityQueue<Student>(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                //按照分数低到高，分数相等按名字
                if(o1.getScore() == o2.getScore()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getScore() - o2.getScore();
            }
        });
        //入列
        q.offer(new Student("dafei", 20));
        q.offer(new Student("will", 17));
        q.offer(new Student("setf", 30));
        q.offer(new Student("bunny", 20));

        //出列
        System.out.println(q.poll());  //Student{name='will', score=17}
        System.out.println(q.poll());  //Student{name='bunny', score=20}
        System.out.println(q.poll());  //Student{name='dafei', score=20}
        System.out.println(q.poll());  //Student{name='setf', score=30}
    }

    @Test
    public void test27(){
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offer(1);
        deque.offer(10);
        deque.offer(7);
        deque.offer(10);
        deque.offer(12);
        deque.offer(19);
        deque.offer(16);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
    }
}
