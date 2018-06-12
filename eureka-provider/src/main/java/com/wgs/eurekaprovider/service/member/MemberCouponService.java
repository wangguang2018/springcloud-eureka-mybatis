package com.wgs.eurekaprovider.service.member;

import com.wgs.entity.MemberCoupon;
import com.wgs.mapper.MemberCouponMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberCouponService {


    @Resource
    private MemberCouponMapper memberCouponMapper;

    /**
     * 获取用户未使用的优惠券
     * @param memberId
     * @return
     */
    public List<MemberCoupon> findByMemberId(Integer memberId){
        return null;
    }

}
