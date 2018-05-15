package com.wgs.api.service;


import com.wgs.dto.BaseResult;
import com.wgs.dto.goods.GoodsDTO;
import com.wgs.dto.goods.GoodsSkuGroupDTO;
import com.wgs.entity.GoodsCategory;
import com.ydd.framework.core.common.Pagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-api")
public interface GoodsService {


    /**
     * 获取商品主体信息
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/findGoodsInfo")
    BaseResult<GoodsDTO> findGoodsInfo(@RequestParam(value = "goodsId") Integer goodsId);

    /**
     * 获取商品sku属性的价格信息
     * @param goodsId
     * @return
     */
    @RequestMapping(value="/findGoodsGroupInfo")
    BaseResult<List<GoodsSkuGroupDTO>> findGoodsGroupInfo(@RequestParam("goodsId") Integer goodsId);

    /**
     * 获取所有商品分类
     * @return
     */
    @RequestMapping("/findGoodsCategory")
    BaseResult<List<GoodsCategory>> findGoodsCategory();


    /**
     * 根据分类查找商品
     * @param cateId
     * @return
     */
    @RequestMapping("/findGoodsByCategory")
    BaseResult<Pagination> findGoodsByCategory(@RequestParam("cateId") Integer cateId, @RequestBody Pagination pagination);

}
