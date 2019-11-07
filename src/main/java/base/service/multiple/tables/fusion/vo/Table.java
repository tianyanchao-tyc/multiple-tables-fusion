package base.service.multiple.tables.fusion.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 表信息
 *
 * @author tyc
 * date 2019-11-07
 */
@Getter
@Setter
public class Table {

    @ApiModelProperty(value = "表名",dataType = "String")
    private String tableName;

    @ApiModelProperty(value = "字段名",dataType = "String")
    private String field;

    @ApiModelProperty(value = "长度",dataType = "Integer")
    private Integer length;

    @ApiModelProperty(value = "备注",dataType = "String")
    private String remark;
}
