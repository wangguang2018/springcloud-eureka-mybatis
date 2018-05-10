package com.wgs.api.controller;

import com.wgs.api.service.GoodsService;
import com.wgs.dto.goods.GoodsDTO;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseApiController{

    @Resource
    private GoodsService goodsService;

    /**
     * 商品详细
     * @param goodsId
     * @return
     */
    @RequestMapping("/info")
    public ResponseDTO findGoodsInfo(@RequestParam("goodsId") Integer goodsId){
        GoodsDTO goodsDTO = goodsService.findGoodsInfo(goodsId);
        return ResponseDTO.ok().addAttribute("data",goodsDTO);
    }

    /**
     * 获取商品的sku组合信息
     * @param goodsId
     * @return
     */
    @RequestMapping("/sku/info")
    public ResponseDTO findGoodsSkuInfo(@RequestParam("goodsId") Integer goodsId){
        return ResponseDTO.ok().addAttribute("data",goodsService.findGoodsGroupInfo(goodsId));
    }

    /**
     * 商品分类列表
     * @return
     */
    @RequestMapping("/categories")
    public ResponseDTO findGoodsCategories(){
        return ResponseDTO.ok().addAttribute("data",goodsService.findGoodsCategory());
    }

    /**
     * 获取分类下的商品
     * @param cateId
     * @param pagination
     * @return
     */
    @RequestMapping("/category/goods")
    public ResponseDTO findGoodsByCategory(@RequestParam("cateId") Integer cateId, Pagination pagination){
        Pagination data = goodsService.findGoodsByCategory(cateId,pagination);
        return ResponseDTO.ok().addAttribute("data",data);
    }

}
