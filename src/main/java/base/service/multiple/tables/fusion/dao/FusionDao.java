package base.service.multiple.tables.fusion.dao;

import base.service.multiple.tables.fusion.entity.DataBase;
import base.service.multiple.tables.fusion.entity.TableRelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据层
 *
 * @author tyc
 * date 2019-11-07
 */
@Mapper
@Repository
public interface FusionDao {
    /**
     * 根据数据库id查询数据库信息
     *
     * @param dataBaseId 数据库id
     * @return 数据信息
     * @author tyc
     * date 2019-11-07
     **/
    DataBase getDataBase(String dataBaseId);

    /**
     * 新增表关系
     *
     * @param tableRelationList 表关系
     * @author tyc
     * date 2019-11-07
     **/
    void insertRelation(List<TableRelation> tableRelationList);

}
