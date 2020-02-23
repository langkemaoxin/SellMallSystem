package com.imooc.sell.dataobject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName 类目
 * @Description TODO
 * @Author Administrator
 * @Date 2020/2/15 7:28
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@DynamicUpdate //如果数据库的字段中有自动更新的时间时，需要设置这个注解才能达到效果
@Entity //映射成数据库
//@Data //包含了Getter Setting ToString 方法
public class ProductCategory {

    /**类目id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    public ProductCategory() {
    }

    /**类目名字. */
    private String categoryName;

    /**类目类型. */
    private Integer categoryType;

    /**类目创建时间. */
    private Date CreateTime;

    /**类目更新时间. */
    private Date UpdateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
