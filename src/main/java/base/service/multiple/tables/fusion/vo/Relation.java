package base.service.multiple.tables.fusion.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 关系描述
 *
 * @author tyc
 * date 2019-11-07
 */
@Getter
@Setter
public class Relation {

    @ApiModelProperty(value = "表1",dataType = "String")
    private String tableA;

    @ApiModelProperty(value = "表2",dataType = "String")
    private String tableB;

    @ApiModelProperty(value = "关系",dataType = "String")
    private String relation;
}
