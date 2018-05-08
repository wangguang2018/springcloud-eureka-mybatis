package com.wgs.eurekaprovider.controller;

import com.wgs.dto.goods.GoodsDTO;
import com.wgs.dto.goods.GoodsSkuGroupDTO;
import com.wgs.entity.GoodsCategory;
import com.wgs.eurekaprovider.service.GoodsCategoryService;
import com.ydd.framework.core.common.Pagination;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wgs.eurekaprovider.service.GoodsService;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsCategoryService goodsCategoryService;

    @RequestMapping("/findGoodsInfo")
    public GoodsDTO findGoodsInfo(@RequestParam("goodsId") Integer goodsId){
        return goodsService.findGoodsInfo(goodsId);
    }

    @RequestMapping("/findGoodsGroupInfo")
    public List<GoodsSkuGroupDTO> findGoodsGroupInfo(@RequestParam("goodsId") Integer goodsId){
        return goodsService.findGoodsGroupInfo(goodsId);
    }

    @RequestMapping("/findGoodsCategory")
    public List<GoodsCategory> findGoodsCategory(){
        return goodsCategoryService.findGoodsCategory();
    }

    @RequestMapping("/findGoodsByCategory")
    public Pagination findGoodsByCategory(@RequestParam("cateId") Integer cateId, Pagination pagination){
        return goodsService.findGoodsByCategory(cateId,pagination);
    }
}
