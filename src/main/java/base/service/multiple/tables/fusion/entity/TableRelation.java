package base.service.multiple.tables.fusion.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 表间关系信息
 *
 * @author tyc
 * date 2019-11-07
 */
@Getter
@Setter
public class TableRelation {

    @ApiModelProperty(value = "id",dataType = "String")
    private String id;

    @ApiModelProperty(value = "表关系",dataType = "String")
    private String relation;

    @ApiModelProperty(value = "字段A",dataType = "String")
    private String fieldA;

    @ApiModelProperty(value = "字段B",dataType = "String")
    private String fieldB;

    @ApiModelProperty(value = "数据库id",dataType = "String")
    private String dataBaseId;

    @ApiModelProperty(value = "sql",dataType = "String")
    private String sql;
}
