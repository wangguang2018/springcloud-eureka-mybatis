package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.dto.member.MemberInfoDTO;
import com.wgs.entity.MemberPrescription;
import com.wgs.entity.MemberToken;
import com.wgs.eurekaprovider.service.goods.GoodsCarService;
import com.wgs.eurekaprovider.service.member.MemberService;
import com.ydd.framework.core.exception.ServiceException;
import org.springframework.web.bind.annotation.*;

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
        return new BaseResult(memberService.loginWithXcx(code,nickname,avatar));
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
     * 清空购物车
     * @param memberId
     * @return
     */
    @RequestMapping("/clearGoodsCar")
    public BaseResult clearGoodsCar( @RequestParam("memberId") Integer memberId){
        goodsCarService.clearGoodsCar(memberId);
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

    /**
     * 获取用户信息
     * @param memberId
     * @return
     */
    @RequestMapping("/findMemberInfo")
    public BaseResult<MemberInfoDTO> findMemberInfo(@RequestParam("memberId") Integer memberId){
        return new BaseResult<>(memberService.findMemberInfo(memberId));
    }

    /**
     * 购物车数量
     * @param memberId
     * @return
     */
    @RequestMapping("/goodsCarCount")
    public BaseResult<Integer> goodsCarCount(@RequestParam("memberId") Integer memberId){
        return new BaseResult<>(goodsCarService.findGoodsCarCount(memberId));
    }

    /**
     * 查询用户处方
     * @param memberId
     * @return
     */
    @RequestMapping("/findPrescription")
    public BaseResult<List<MemberPrescription>> findPrescription(@RequestParam("memberId") Integer memberId){

        return new BaseResult(memberService.findPrescription(memberId));
    }

    /**
     * 查询用户单个处方
     * @param memberId
     * @return
     */
    @RequestMapping("/findOnePrescription")
    public BaseResult<MemberPrescription> findOnePrescription(@RequestParam("memberId") Integer memberId,@RequestParam("id") Integer id){
        return new BaseResult(memberService.findOnePrescription(memberId,id));
    }

    /**
     * 保存处方
     * @param memberPrescription
     * @return
     */
    @RequestMapping(value = "/saveOnePrescription",method = RequestMethod.POST)
    public BaseResult save(@RequestBody MemberPrescription memberPrescription){
        memberService.save(memberPrescription);
        return new BaseResult();
    }

    /**
     * 删除处方
     * @param memberId
     * @param id
     */
    @RequestMapping("/deleteOnePrescription")
    public BaseResult deleteOnePrescription(@RequestParam("memberId") Integer memberId,@RequestParam("id") Integer id){
        memberService.deleteOnePrescription(memberId,id);
        return new BaseResult();
    }

}
