package base.service.multiple.tables.fusion.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 数据库连接信息
 *
 * @author
 * date 2019-11-07
 */
@Getter
@Setter
@ApiModel("数据库连接信息")
public class DataBase {

    @ApiModelProperty(value = "id",dataType = "String")
    private String id;

    @ApiModelProperty(value = "连接驱动",dataType = "String")
    private String driverClassName;

    @ApiModelProperty(value = "连接url",dataType = "String")
    private String url;

    @ApiModelProperty(value = "用户名",dataType = "String")
    private String username;

    @ApiModelProperty(value = "密码",dataType = "String")
    private String password;

    @ApiModelProperty(value = "数据库名称",dataType = "String")
    private String dataBase;

    @ApiModelProperty(value = "数据库类型")
    private Integer dataBaseType;
}
