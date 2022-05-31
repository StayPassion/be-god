package com.pb.study.begod.controller;

import com.alibaba.excel.EasyExcel;
import com.pb.study.begod.domain.dto.ArticleDto;
import com.pb.study.begod.entity.Article;
import org.apache.catalina.LifecycleState;
import org.checkerframework.checker.units.qual.A;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description EasyExcelController
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/04/21 11:05
 */
@RestController
public class EasyExcelController {
    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link Article}
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        List<ArticleDto> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArticleDto article = new ArticleDto();
            article.setId((long) (i + 1));
            article.setTitle("234234");
            article.setContent("z洪文");
            article.setCreateDate(new Date());
            BigDecimal bigDecimal = new BigDecimal("122.44");
            if (i != 5) {
                article.setMoney(bigDecimal.toString());
            }
            data.add(article);
        }

        EasyExcel.write(response.getOutputStream(), ArticleDto.class).sheet("模板").doWrite(data);
    }

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link UploadData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
     * <p>3. 直接读即可
     */
//    @PostMapping("upload")
//    @ResponseBody
//    public String upload(MultipartFile file) throws IOException {
//        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
//        return "success";
//    }
}
