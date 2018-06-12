package com.wgs.eurekaprovider.service.member;

import com.google.common.collect.Lists;
import com.wgs.entity.MemberCoupon;
import com.wgs.entity.enums.EnumMemberCouponStatus;
import com.wgs.entity.enums.EnumMemberExpireType;
import com.wgs.eurekaprovider.service.utils.DateService;
import com.wgs.mapper.MemberCouponMapper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MemberCouponService {

    private static Logger logger = LoggerFactory.getLogger(MemberCouponService.class);

    @Resource
    private MemberCouponMapper memberCouponMapper;

    @Resource
    private DateService dateService;

    /**
     * 获取用户的优惠券
     * @param memberId
     * @return
     */
    @Transactional
    public List<MemberCoupon> findByMemberId(Integer memberId,Byte status){
        List<MemberCoupon> list = Lists.newArrayList();
        if(EnumMemberCouponStatus.getEnum(status)==null){
            return list;
        }
        Date now = dateService.getNow();
        logger.info("-------------now:"+now);

        List<MemberCoupon> coupons = memberCouponMapper.findByMemberId(1,(byte)0);
        List<Integer> ids = Lists.newArrayList();
        if(CollectionUtils.isEmpty(coupons)){
            return  list;
        }
        for(MemberCoupon c : coupons){
            if(c.getStatus().intValue()==EnumMemberCouponStatus.no_yet.value
            && c.getEndTime().before(now)){
                //获取已经过期的用户优惠券
                ids.add(c.getId());
            }else{
                list.add(c);
            }
        }
        if(CollectionUtils.isNotEmpty(ids)){
            memberCouponMapper.updateStatus(ids,EnumMemberCouponStatus.overdue.value);
        }
        return list;
    }

}
