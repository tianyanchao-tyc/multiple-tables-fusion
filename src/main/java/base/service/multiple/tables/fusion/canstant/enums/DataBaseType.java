package base.service.multiple.tables.fusion.canstant.enums;

/**
* 数据库类型
* @author tyc
* date 2019-11-07
**/
public enum DataBaseType {

    ORACLE(1,"ORACLE"),
    MYSQL(2,"MYSQL"),
    PG(3,"POSTGRES");

    private Integer type;

    private String value;

    DataBaseType(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
