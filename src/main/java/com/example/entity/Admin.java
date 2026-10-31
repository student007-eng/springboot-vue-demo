package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
/**加了这个注解可以不用写get,set方法**/
@TableName("`admin`")
/**指定表名**/
@Schema(description = "管理员信息实体类")
public class Admin {
    /**告诉它这是主键，并且是自动递增的**/
    @TableId(type= IdType.AUTO)
    @Schema(description = "id")
    private Long id;//主键ID
    @Schema(description = "用户名")
    private String username;//用户名
    @Schema(description = "密码")
    private String userpwd;//密码
    @Schema(description = "姓名")
    private String name;//姓名
    @Schema(description = "性别")
    private String sex;//性别
    @Schema(description = "电话")
    private String tel;//电话
    @Schema(description = "头像")
    private String headurl;//头像
}
