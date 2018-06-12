package com.wgs.api.controller;

import com.cloopen.rest.sdk.utils.DateUtil;
import com.google.common.collect.Lists;
import com.wgs.api.service.MemberAddressService;
import com.wgs.api.service.MemberCouponService;
import com.wgs.api.service.MemberService;
import com.wgs.dto.BaseResult;
import com.wgs.dto.coupon.MemberCouponDto;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.entity.MemberAddress;
import com.wgs.entity.MemberCoupon;
import com.wgs.entity.MemberPrescription;
import com.wgs.entity.MemberToken;
import com.wgs.entity.enums.EnumMemberCouponStatus;
import com.wgs.utils.mapper.BeanMapper;
import com.ydd.framework.core.annotation.AccessToken;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.common.utils.CommonDateUtils;
import com.ydd.framework.core.controller.BaseApiController;
import org.apache.commons.collections.CollectionUtils;
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
        List<MemberCouponDto> list = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(result.getContent())){
            for(MemberCoupon coupon : result.getContent()){
                MemberCouponDto dto = new MemberCouponDto();
                BeanMapper.copy(coupon,dto);
                dto.setStartDateStr(CommonDateUtils.formatDate(coupon.getStartTime(),CommonDateUtils.DATE_FROMAT));
                dto.setEndDateStr(CommonDateUtils.formatDate(coupon.getEndTime(),CommonDateUtils.DATE_FROMAT));
                list.add(dto);
            }
        }
        return ResponseDTO.ok().addAttribute("data",list);
    }



}
