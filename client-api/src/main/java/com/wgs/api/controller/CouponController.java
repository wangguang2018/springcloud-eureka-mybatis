package com.wgs.api.controller;

import com.wgs.api.service.MemberAddressService;
import com.wgs.api.service.MemberCouponService;
import com.wgs.api.service.MemberService;
import com.wgs.dto.BaseResult;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.entity.MemberAddress;
import com.wgs.entity.MemberCoupon;
import com.wgs.entity.MemberPrescription;
import com.wgs.entity.MemberToken;
import com.wgs.entity.enums.EnumMemberCouponStatus;
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
@RequestMapping("/coupon")
public class CouponController extends BaseApiController {

    @Resource
    private MemberService memberService;

    @Resource
    private MemberCouponService memberCouponService;


    /**
     * 获取用户待使用的优惠券
     * @return
     */
    @RequestMapping("/member")
    @AccessToken
    public ResponseDTO goodsCarList(){
        BaseResult<List<MemberCoupon>> result = memberCouponService.findMemberCoupon(getLoginMemberId(), EnumMemberCouponStatus.no_yet.value);
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }



}
