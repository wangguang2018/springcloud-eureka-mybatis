package com.wgs.eurekaprovider.controller;

import com.wgs.dto.goods.GoodsDTO;
import com.wgs.entity.Goods;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wgs.eurekaprovider.service.GoodsService;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class MainController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/test")
    public GoodsDTO test(){
        return goodsService.findGoodsInfo(1);
    }
}
