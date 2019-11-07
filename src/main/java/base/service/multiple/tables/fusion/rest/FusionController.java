package base.service.multiple.tables.fusion.rest;

import base.service.multiple.tables.fusion.entity.SelectTable;
import base.service.multiple.tables.fusion.service.FusionService;
import base.service.multiple.tables.fusion.vo.Table;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制层
 *
 * @author tyc
 * date 2019-11-07
 */
@RestController
@RequestMapping("/fusion")
@Api("控制层")
public class FusionController {

    @Autowired
    private FusionService fusionService;

    /**
     * 获取数据库表字段信息
     *
     * @param selectTable
     * @return
     * @author tyc
     * date 2019-11-07
     **/
    @GetMapping("/selectTable")
    public List<String> selectTable(SelectTable selectTable) throws Exception {
        return fusionService.selectTable(selectTable);
    }


    /**
     * 根据字段及表关系生成sql查询数据
     *
     * @param map  map
     * @param relation list
     * @return 数据
     * @author tyc
     * date 2019-11-07
     **/
    @PostMapping("/getData")
    public List<LinkedHashMap<String, Object>> getData(@RequestBody Map<String, List<Table>> map,
                                                       @RequestParam String relation) {
        JSONArray jsonArray = JSONArray.fromObject(relation);
        List list = JSONArray.toList(jsonArray, relation, new JsonConfig());
        return fusionService.getData(map, list);
    }
}
