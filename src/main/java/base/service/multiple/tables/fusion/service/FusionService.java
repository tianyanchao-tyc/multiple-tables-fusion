package base.service.multiple.tables.fusion.service;

import base.service.multiple.tables.fusion.dao.FusionDao;
import base.service.multiple.tables.fusion.entity.DataBase;
import base.service.multiple.tables.fusion.entity.SelectTable;
import base.service.multiple.tables.fusion.entity.TableRelation;
import base.service.multiple.tables.fusion.util.JDBCUtils;
import base.service.multiple.tables.fusion.vo.Relation;
import base.service.multiple.tables.fusion.vo.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 服务层
 *
 * @author tyc
 * date 2019-11-07
 */
@Service
public class FusionService {
    @Autowired
    private FusionDao fusionDao;

    /**
     * 获取表字段信息
     *
     * @param selectTable
     * @return
     * @author tyc
     * date 2019-11-07
     **/
    public List<String> selectTable(SelectTable selectTable) throws SQLException {
        List<String> tableList = new ArrayList<>();
        DataBase dataBase = fusionDao.getDataBase(selectTable.getDataBaseId());
        Connection connection = JDBCUtils.getConnection(dataBase.getDriverClassName(),
                dataBase.getUrl(), dataBase.getPassword(), dataBase.getUsername());
        ResultSetMetaData resultSet = JDBCUtils.getResultSet(connection, selectTable.getTableName());
        int columnCount = resultSet.getColumnCount();
        for (int i = 1; i < columnCount; i++) {
            tableList.add(resultSet.getColumnName(i));
        }
        return tableList;
    }

    /**
     * 根据字段及表关系生成sql查询数据
     *
     * @param map  map
     * @param list list
     * @return List<LinkedHashMap < String, Object>>
     * @author tyc
     * date 2019-11-07
     **/
    public List<LinkedHashMap<String, Object>> getData(Map<String, List<Table>> map, List<String> list) {
        Set<String> strings = map.keySet();
        StringBuilder fields = new StringBuilder();
        StringBuilder tables = new StringBuilder();
        List<TableRelation> tableRelationList = new ArrayList<>();
        for (String dataBaseId : strings) {
            List<Table> tableList = map.get(dataBaseId);
            List<Relation> relationList = relation(list);
            setRelation(relationList, tableRelationList, dataBaseId, tableList);
        }
        fusionDao.insertRelation(tableRelationList);
        return null;
    }

    /**
     * 将表信息及表关系进行处理
     *
     * @param relationList      关系描述
     * @param tableRelationList 表关系及表信息
     * @param dataBaseId        数据库id
     * @param tableList         表信息
     * @author tyc
     * date 2019-11-07
     **/
    private void setRelation(List<Relation> relationList,
                             List<TableRelation> tableRelationList,
                             String dataBaseId,
                             List<Table> tableList) {
        for (Relation relation : relationList) {
            TableRelation tableRelation = new TableRelation();
            tableRelation.setDataBaseId(dataBaseId);
            for (Table table : tableList) {
                if (table.getTableName().equals(relation.getTableA())) {
                    tableRelation.setFieldA(table.getField());
                } else if (table.getTableName().equals(relation.getTableB())) {
                    tableRelation.setFieldB(table.getField());
                }
            }
            tableRelationList.add(tableRelation);
        }
    }

    /**
     * 转换表关系
     *
     * @param list 表关系list
     * @return List<Relation>
     * @author tyc
     * date 2019-11-07
     **/
    private List<Relation> relation(List<String> list) {
        List<Relation> relationList = new ArrayList<>();
        for (String tableRelation : list) {
            Relation relation = new Relation();
            String[] strings = tableRelation.split(".");
            relation.setTableA(strings[0]);
            relation.setTableB(strings[2]);
            relation.setRelation(tableRelation);
            relationList.add(relation);
        }
        return relationList;
    }
}
