package cn.wqy.eureka.provider.controller;

import cn.wqy.eureka.provider.entity.PlanNode;
import cn.wqy.eureka.provider.service.PlanNodeService;
import cn.wqy.eureka.provider.util.Stringer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/node")//swagger2 只认  @RequestMapping 注解！ 不认@RestController  注解
@Api(value = "eureka-provider-node", description = "计划节点crud接口")
public class NodeController {

    @Autowired
    private PlanNodeService nodeService;

    /**
     * 新增节点
     * @param node
     * @return
     */
    @PostMapping(value = "/add")
    public int addNode(@ApiParam(value = "节点名称") @RequestParam(value = "nodeName",required = false) String nodeName,
                        @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
                        @ApiParam(value = "父节点ID") @RequestParam(value = "parentId",required = false) String parentId,
                        PlanNode node){
        node.setNodeId(UUID.randomUUID().toString());
        return nodeService.insertSelective(node);
    }

    @PostMapping(value = "/update")
    public int updateNode(
            @ApiParam(value = "节点名称") @RequestParam(value = "nodeName",required = false) String nodeName,
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
            @ApiParam(value = "节点ID") @RequestParam(value = "nodeId",required = false) String nodeId,
            @ApiParam(value = "父节点ID") @RequestParam(value = "parentId",required = false) String parentId,
            PlanNode node){
        return nodeService.updateByPrimaryKeySelective(node);
    }

    @GetMapping(value = "/delete")
    public int deleteNode(
            @ApiParam(value = "节点ID") @RequestParam(value = "nodeId",required = false) String nodeId,
            PlanNode node){
        return nodeService.deleteByPrimaryKey(node);
    }

    @RequestMapping(value = "/query")
    @ApiOperation(value = "node query")
    public List<PlanNode> queryNode(
            @ApiParam(value = "节点名称") @RequestParam(value = "nodeName",required = false) String nodeName,
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
            @ApiParam(value = "父节点ID") @RequestParam(value = "parentId",required = false) String parentId,
            Map<String,Object> params){

        if(!Stringer.isNullOrEmpty(nodeName)){
            params.put("nodeName",nodeName);
        }
        if(!Stringer.isNullOrEmpty(habitId)){
            params.put("habitId",habitId);
        }
        if(!Stringer.isNullOrEmpty(parentId)){
            params.put("parentId",parentId);
        }


        return nodeService.select(params);
    }
}
