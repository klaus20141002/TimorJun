package com.timorjun.solr.webmagic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.timorjun.solr.domain.Product;
import com.timorjun.solr.service.ProductService;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component("jdPipeline")
public class JDPipeline implements Pipeline {

    @Autowired
    ProductService productService;

    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> items = resultItems.getAll();
        if (resultItems != null && resultItems.getAll().size() > 0) {
            List<String> names = (List<String>) items.get("names");
            List<String> prices = (List<String>) items.get("prices");
            List<String> comments = (List<String>) items.get("comments");
            List<String> links = (List<String>) items.get("links");
            List<String> pics = (List<String>) items.get("pics");
            String category = (String) items.get("category");
            int count = 1;// 抓取的价格数据有重复，去重
            int size = names.size();
            if(prices.size() == size * 2){
                count = 2;
            }
            for (int i = 0; i < size; i++) {
                Product p = new Product();
                p.setName(names.get(i));
                p.setPic(pics.get(i));
                try{
                    double price = Double.parseDouble(prices.get(i * 2));
                    p.setPrice(price);
                }catch (Exception e){
                }
                try{
                    long comment = Long.parseLong(comments.get(i));
                    p.setComment(comment);
                }catch (Exception e){
                }
                p.setId(links.get(i));
                List<String> categorys = new ArrayList<String>();
                categorys.add(category);
                p.setCategory(categorys);
                p.setCreate(new Date());
                p.setUpdate(new Date());
                productService.save(p);
            }
        }
    }

}
