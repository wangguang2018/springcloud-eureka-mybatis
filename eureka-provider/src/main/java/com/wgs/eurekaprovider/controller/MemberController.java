package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.entity.MemberToken;
import com.wgs.eurekaprovider.service.goods.GoodsCarService;
import com.wgs.eurekaprovider.service.member.MemberService;
import com.ydd.framework.core.exception.ServiceException;
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
    public BaseResult<MemberToken> login(@RequestParam("code") String code, @RequestParam("nickname") String nickname, @RequestParam("avatar") String avatar) throws ServiceException{
        return memberService.loginWithXcx(code,nickname,avatar);
    }

    /**
     *  购物车列表
     * @param memberId
     * @return
     */
    @RequestMapping("/findGoodsCarByMemberId")
    public BaseResult<List<GoodsCarDTO>> findByMemberId(@RequestParam("memberId") Integer memberId){
        return new BaseResult(goodsCarService.findGoodsCarByMember(memberId));
    }

    /**
     * 添加到购物车
     * @param skuGroupId
     * @param memberId
     * @param goodsId
     * @param num
     */
    @RequestMapping("/addGoodsCar")
    public BaseResult addGoodsCar(@RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("memberId") Integer memberId,
                            @RequestParam("goodsId") Integer goodsId, @RequestParam("num") Integer num) {
        goodsCarService.addGoodsCar(skuGroupId,memberId,goodsId,num);
        return new BaseResult();
    }

    /**
     * 删除购物车
     * @param skuGroupId
     * @param memberId
     */
    @RequestMapping("/deleteGoodsCar")
    public BaseResult deleteGoodsCar(@RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("memberId") Integer memberId){
        goodsCarService.delete(skuGroupId,memberId);
        return new BaseResult();
    }

    /**
     * 通过accessToken获取用户ID
     * @param accessToken
     * @return
     */
    @RequestMapping("/getMemberIdByAccessToken")
    public BaseResult<Integer> getMemberIdByAccessToken(@RequestParam("accessToken") String accessToken){
        return new BaseResult(memberService.getMemberIdByAccessToken(accessToken));
    }

}
