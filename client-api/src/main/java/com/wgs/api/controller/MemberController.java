package com.wgs.api.controller;

import com.wgs.api.service.MemberAddressService;
import com.wgs.api.service.MemberService;
import com.wgs.dto.BaseResult;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.dto.member.MemberInfoDTO;
import com.wgs.entity.MemberAddress;
import com.wgs.entity.MemberToken;
import com.ydd.framework.core.annotation.AccessToken;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController extends BaseApiController {

    @Resource
    private MemberService memberService;

    @Resource
    private MemberAddressService memberAddressService;

    /**
     * 小程序登录
     * @param code
     * @param nickname
     * @param avatar
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseDTO login(@RequestParam("code") String code, @RequestParam("nickname") String nickname, @RequestParam("avatar") String avatar){
        BaseResult<MemberToken> memberToken = memberService.login(code,nickname,avatar);
        return ResponseDTO.ok().addAttribute("data",memberToken.getContent());
    }

    /**
     * 获取用户购物车
     * @return
     */
    @RequestMapping("/goods/car")
    @AccessToken
    public ResponseDTO goodsCarList(){
        BaseResult<List<GoodsCarDTO>> result = memberService.findGoodsCar(getLoginMemberId());
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }

    /**
     *
     * @param skuGroupId 商品sku组合ID
     * @return
     */
    @RequestMapping(value = "/goods/car/add",method = RequestMethod.POST)
    @AccessToken
    public ResponseDTO addGoodsToCar(@RequestParam("skuGroupId") Integer skuGroupId,@RequestParam("goodsId") Integer goodsId,@RequestParam("num") Integer num){
        memberService.addGoodsCar(skuGroupId,getLoginMemberId(),goodsId,num);
        return ResponseDTO.ok();
    }

    /**
     * 购物车删除产品
     * @param skuGroupId
     * @return
     */
    @RequestMapping(value = "/goods/car/delete",method = RequestMethod.POST)
    @AccessToken
    public ResponseDTO deleteGoodsFromCar(@RequestParam("skuGroupId") Integer skuGroupId){
        memberService.deleteGoodsCar(skuGroupId,getLoginMemberId());
        return ResponseDTO.ok();
    }

    /**
     * 保存收货地址
     * @param memberAddress
     * @return
     */
    @AccessToken
    @RequestMapping(value = "/address/save",method = RequestMethod.POST)
    public ResponseDTO saveMemberAddress(MemberAddress memberAddress){
        memberAddressService.save(memberAddress,getLoginMemberId());
        return ResponseDTO.ok();
    }

    /**
     * 用户收货地址列表
     * @return
     */
    @AccessToken
    @RequestMapping(value = "/address/list",method = RequestMethod.GET)
    public ResponseDTO memberAddressList(){
        BaseResult<List<MemberAddress>> result = memberAddressService.findMemberAddress(getLoginMemberId());
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    @AccessToken
    @RequestMapping(value = "/address/delete",method = RequestMethod.POST)
    public ResponseDTO deleteMemberAddress(@RequestParam("addressId") Integer addressId){
        memberAddressService.deleteAddress(getLoginMemberId(),addressId);
        return ResponseDTO.ok();
    }

    /**
     * 将地址设为默认
     * @param addressId
     * @return
     */
    @AccessToken
    @RequestMapping(value = "/address/default",method = RequestMethod.POST)
    public ResponseDTO defaultMemberAddress(@RequestParam("addressId") Integer addressId){
        memberAddressService.setAddressDefault(getLoginMemberId(),addressId);
        return ResponseDTO.ok();
    }

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping("/info")
    @AccessToken
    public ResponseDTO findMemberInfo(){
        BaseResult result = memberService.findMemberInfo(getLoginMemberId());
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping("/goodscar/count")
    @AccessToken
    public ResponseDTO findGoodsCarCount(){
        BaseResult result = memberService.findGoodsCarCount(getLoginMemberId());
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }

}
