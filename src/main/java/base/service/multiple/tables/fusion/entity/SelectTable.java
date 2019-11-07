package base.service.multiple.tables.fusion.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询表信息
 *
 * @author tyc
 * date 2019-11-07
 */
@Getter
@Setter
public class SelectTable {

    @ApiModelProperty(value = "表名",dataType = "String")
    private String tableName;

    @ApiModelProperty(value = "数据库名称",dataType = "String")
    private String dataBaseName;

    @ApiModelProperty(value = "数据库id",dataType = "String")
    private String dataBaseId;


}
