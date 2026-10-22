package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
/**加了这个注解可以不用写get,set方法**/
@TableName("`admin`")
/**指定表名**/
public class Admin {
    /**告诉它这是主键，并且是自动递增的**/
    @TableId(type= IdType.AUTO)
    private Long id;//主键ID
    private String username;//用户名
    private String userpwd;//密码
    private String name;//姓名
    private String sex;//性别
    private String tel;//电话
    private String headurl;//头像
}
