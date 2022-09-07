package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//商品类
@Data
@TableName("tb_prod")
public class Prod {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String type;
    private String mark;
    private String spec;
    @TableField(exist = false)
    private Integer version;
    @TableField(exist = false)
    private Integer deleted;

}
