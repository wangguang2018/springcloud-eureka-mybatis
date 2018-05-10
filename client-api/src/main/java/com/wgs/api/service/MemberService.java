package com.wgs.api.service;

import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.entity.MemberToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-api")
public interface MemberService {

    /**
     * 小程序登录
     * @param code
     * @param nickname
     * @param avatar
     * @return
     */
    @RequestMapping("/login")
    MemberToken login(@RequestParam("code") String code, @RequestParam("nickname") String nickname, @RequestParam("avatar") String avatar);


    /**
     *  购物车列表
     * @param memberId
     * @return
     */
    @RequestMapping("/findGoodsCarByMemberId")
    List<GoodsCarDTO> findByMemberId(@RequestParam("memberId") Integer memberId);

    /**
     * 添加到购物车
     * @param skuGroupId
     * @param memberId
     * @param goodsId
     * @param num
     */
    @RequestMapping("/addGoodsCar")
    void addGoodsCar(@RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("memberId") Integer memberId,
                            @RequestParam("goodsId") Integer goodsId, @RequestParam("num") Integer num);


    /**
     * 删除购物车
     * @param skuGroupId
     * @param memberId
     */
    @RequestMapping("/deleteGoodsCar")
    void deleteGoodsCar(@RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("memberId") Integer memberId);
}
