package com.wgs.eurekaprovider.controller;

import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.entity.MemberToken;
import com.wgs.eurekaprovider.service.goods.GoodsCarService;
import com.wgs.eurekaprovider.service.member.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MemberController{

    @Resource
    private MemberService memberService;

    @Resource
    private GoodsCarService goodsCarService;

    @RequestMapping("/login")
    public MemberToken login(@RequestParam("code") String code, @RequestParam("nickname") String nickname, @RequestParam("avatar") String avatar){
        return memberService.loginWithXcx(code,nickname,avatar);
    }

    /**
     *  购物车列表
     * @param memberId
     * @return
     */
    @RequestMapping("/findGoodsCarByMemberId")
    public List<GoodsCarDTO> findByMemberId(@RequestParam("memberId") Integer memberId){
        return goodsCarService.findGoodsCarByMember(memberId);
    }

    /**
     * 添加到购物车
     * @param skuGroupId
     * @param memberId
     * @param goodsId
     * @param num
     */
    @RequestMapping("/addGoodsCar")
    public void addGoodsCar(@RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("memberId") Integer memberId,
                            @RequestParam("goodsId") Integer goodsId, @RequestParam("num") Integer num) {
        goodsCarService.addGoodsCar(skuGroupId,memberId,goodsId,num);
    }

    /**
     * 删除购物车
     * @param skuGroupId
     * @param memberId
     */
    @RequestMapping("/deleteGoodsCar")
    public void deleteGoodsCar(@RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("memberId") Integer memberId){
        goodsCarService.delete(skuGroupId,memberId);
    }

}
