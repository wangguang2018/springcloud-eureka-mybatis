package com.wgs.api.service;

import com.wgs.dto.BaseResult;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.dto.member.MemberInfoDTO;
import com.wgs.entity.MemberPrescription;
import com.wgs.entity.MemberToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    BaseResult<MemberToken> login(@RequestParam("code") String code, @RequestParam("nickname") String nickname, @RequestParam("avatar") String avatar);


    /**
     *  购物车列表
     * @param memberId
     * @return
     */
    @RequestMapping("/findGoodsCarByMemberId")
    BaseResult<List<GoodsCarDTO>> findGoodsCar(@RequestParam("memberId") Integer memberId);

    /**
     * 添加到购物车
     * @param skuGroupId
     * @param memberId
     * @param goodsId
     * @param num
     */
    @RequestMapping("/addGoodsCar")
    BaseResult addGoodsCar(@RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("memberId") Integer memberId,
                            @RequestParam("goodsId") Integer goodsId, @RequestParam("num") Integer num);


    /**
     * 删除购物车
     * @param skuGroupId
     * @param memberId
     */
    @RequestMapping("/deleteGoodsCar")
    BaseResult deleteGoodsCar(@RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("memberId") Integer memberId);

    /**
     * 清空购物车
     * @param memberId
     * @return
     */
    @RequestMapping("/clearGoodsCar")
    BaseResult clearGoodsCar(@RequestParam("memberId") Integer memberId);


    /**
     * 通过token获取用户ID
     * @param accessToken
     */
    @RequestMapping("/getMemberIdByAccessToken")
    BaseResult<Integer> getMemberIdByAccessToken(@RequestParam("accessToken") String accessToken);

    /**
     * 获取用户信息
     * @param memberId
     * @return
     */
    @RequestMapping("/findMemberInfo")
    BaseResult<MemberInfoDTO> findMemberInfo(@RequestParam("memberId") Integer memberId);

    /**
     * 购物车数量
     * @param memberId
     * @return
     */
    @RequestMapping("/goodsCarCount")
    BaseResult<Integer> findGoodsCarCount(@RequestParam("memberId") Integer memberId);

    /**
     * 查询用户处方
     * @param memberId
     * @return
     */
    @RequestMapping("/findPrescription")
    BaseResult<List<MemberPrescription>> findPrescription(@RequestParam("memberId") Integer memberId);

    /**
     * 获取单个处方信息
     * @param memberId
     * @param id
     * @return
     */
    @RequestMapping("/findOnePrescription")
    BaseResult<MemberPrescription> findOnePrescription(@RequestParam("memberId")Integer memberId,@RequestParam("id") Integer id);

    /**
     * 保存处方
     *
     * @param memberPrescription
     */
    @RequestMapping(value = "/saveOnePrescription",method = RequestMethod.POST)
    BaseResult save(@RequestBody MemberPrescription memberPrescription);

    /**
     * 删除处方
     *
     * @param memberId
     * @param id
     */
    @RequestMapping("/deleteOnePrescription")
    BaseResult deletePrescription(@RequestParam("memberId") Integer memberId, @RequestParam("id") Integer id);
}
