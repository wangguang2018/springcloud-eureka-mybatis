package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.entity.MemberAddress;
import com.wgs.entity.MemberCoupon;
import com.wgs.eurekaprovider.service.member.MemberAddressService;
import com.wgs.eurekaprovider.service.member.MemberCouponService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/member/coupon")
public class MemberCouponController {

    @Resource
    private MemberCouponService memberCouponService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public BaseResult save(@RequestBody MemberCoupon memberCoupon){
        return new BaseResult();
    }

    /**
     * 获取用户待使用优惠券
     *
     * @param memberId
     * @return
     */
    @RequestMapping("/list")
    public BaseResult<List<MemberCoupon>> findByMemberId(@RequestParam("memberId")Integer memberId,
                                                          @RequestParam("status") Byte status) {
        return new BaseResult(memberCouponService.findByMemberId(memberId,status));
    }


}
