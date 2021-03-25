package cn.tedu.travel.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("banner")
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("url")
    private String url;

    @TableField("sort_num")
    private Integer sortNum;
}
