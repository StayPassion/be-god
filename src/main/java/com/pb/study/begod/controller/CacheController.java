package com.pb.study.begod.controller;

import com.pb.study.begod.entity.Article;
import com.pb.study.begod.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TreeSet;

/**
 * @Description HelloController
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/03/23 19:02
 */

@RestController
public class CacheController {

    private static final Logger logger = LoggerFactory.getLogger(CacheController.class);

    @Autowired
   private ArticleService articleService;


    @GetMapping("/test/cache")
    @Cacheable(value = "user",key = "#id")
    public List<Article> test(@RequestParam("tableName") String id) {
        List<Article> list = articleService.lambdaQuery().eq(Article::getId,id).list();
        return list;
    }

    @CacheEvict(value = "user", key = "#id")
    @DeleteMapping("/test/{id}")
    public void delete(@PathVariable Long id) {
        articleService.removeById(id);

    }


}
