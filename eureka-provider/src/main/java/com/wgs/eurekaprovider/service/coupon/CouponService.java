package com.wgs.eurekaprovider.service.coupon;

import com.wgs.entity.Coupon;
import com.wgs.mapper.CouponMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠券
 */
@Service
@Transactional(readOnly = true)
public class CouponService {

    @Resource
    private CouponMapper couponMapper;

    public List<Coupon> findAllCoupon(){
        List<Coupon> coupons = couponMapper.findAll();
        return coupons;
    }


    public Coupon findById(Integer id){
        return couponMapper.findById(id);
    }
}
