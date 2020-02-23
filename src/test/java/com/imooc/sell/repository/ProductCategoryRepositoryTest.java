package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        Optional<ProductCategory> byId = repository.findById(1);
        ProductCategory productCategory = byId.get();
        System.out.println(productCategory);
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void upateTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }


    @Test
    public void upateTestWithUpdateTime(){
        Optional<ProductCategory> byId = repository.findById(1);
        ProductCategory productCategory = byId.get();
        productCategory.setCategoryType(120);

        repository.save(productCategory);
    }


    @Test
    @Transactional //数据库不会插入数据，做完之后完全回滚
    public void saveTest002(){
        ProductCategory productCategory = new ProductCategory("女生最大", 2);
        ProductCategory save = repository.save(productCategory);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> byCategoryTypeIn = repository.findByCategoryTypeIn(list);
        for (ProductCategory item :
                byCategoryTypeIn) {
            System.out.println(item);

        }
        Assert.assertNotEquals(0,byCategoryTypeIn.size());
    }

}