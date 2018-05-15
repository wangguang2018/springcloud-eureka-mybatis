package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.dto.goods.GoodsDTO;
import com.wgs.dto.goods.GoodsSkuGroupDTO;
import com.wgs.entity.GoodsCategory;
import com.wgs.eurekaprovider.service.goods.GoodsCategoryService;
import com.ydd.framework.core.common.Pagination;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wgs.eurekaprovider.service.goods.GoodsService;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsCategoryService goodsCategoryService;

    @RequestMapping("/findGoodsInfo")
    public BaseResult<GoodsDTO> findGoodsInfo(@RequestParam("goodsId") Integer goodsId){
        return new BaseResult(goodsService.findGoodsInfo(goodsId));
    }

    @RequestMapping("/findGoodsGroupInfo")
    public BaseResult<List<GoodsSkuGroupDTO>> findGoodsGroupInfo(@RequestParam("goodsId") Integer goodsId){
        return new BaseResult(goodsService.findGoodsGroupInfo(goodsId));
    }

    @RequestMapping("/findGoodsCategory")
    public BaseResult<List<GoodsCategory>> findGoodsCategory(){
        return new BaseResult(goodsCategoryService.findGoodsCategory());
    }

    @RequestMapping("/findGoodsByCategory")
    public BaseResult<Pagination> findGoodsByCategory(@RequestParam("cateId") Integer cateId,@RequestBody Pagination pagination){
        return new BaseResult(goodsService.findGoodsByCategory(cateId, pagination));
    }
}
