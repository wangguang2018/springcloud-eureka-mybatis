package com.wgs.api.service;

import com.wgs.dto.BaseResult;
import com.wgs.entity.MemberAddress;
import com.wgs.entity.MemberCoupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-api")
public interface MemberCouponService {


    /**
     * 获取用户优惠券
     * @param memberId
     * @param status
     * @return
     */
    @RequestMapping("/member/coupon/list")
    BaseResult<List<MemberCoupon>> findMemberCoupon(@RequestParam("memberId") Integer memberId,@RequestParam("status") Byte status);







}
