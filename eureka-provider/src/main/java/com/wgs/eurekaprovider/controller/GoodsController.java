package com.wgs.eurekaprovider.controller;

import com.wgs.dto.goods.GoodsDTO;
import com.wgs.dto.goods.GoodsSkuGroupDTO;
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

    @RequestMapping("/findGoodsInfo")
    public GoodsDTO findGoodsInfo(@RequestParam("goodsId") Integer goodsId){
        return goodsService.findGoodsInfo(goodsId);
    }

    @RequestMapping("/findGoodsGroupInfo")
    public List<GoodsSkuGroupDTO> findGoodsGroupInfo(@RequestParam("goodsId") Integer goodsId){
        return goodsService.findGoodsGroupInfo(goodsId);
    }
}
