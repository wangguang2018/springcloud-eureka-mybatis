package com.wgs.eurekaprovider.service.member;

import com.wgs.entity.MemberAddress;
import com.wgs.mapper.MemberAddressMapper;
import com.wgs.mapper.MemberMapper;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收货地址
 */
@Service
public class MemberAddressService extends BaseServiceImpl {

    @Resource
    private MemberAddressMapper memberAddressMapper;

    /**
     * 修改
     *
     * @param memberAddress
     */
    @Transactional
    public void save(MemberAddress memberAddress, Integer memberId) {
        if (memberAddress.getId() == null) {
            memberAddressMapper.insert(memberAddress);
        } else {
            memberAddressMapper.update(memberAddress);
        }
    }

    /**
     * 获取用户地址
     *
     * @param memberId
     * @return
     */
    public List<MemberAddress> findMemberAddress(Integer memberId) {
        return memberAddressMapper.findByMemberId(memberId);
    }

    /**
     * 将地址设为默认
     *
     * @param memberId
     * @param addressId
     */
    @Transactional
    public void setAddressDefault(Integer memberId, Integer addressId) {
        //将所有地址取消默认
        memberAddressMapper.updateMemberAddressDefault(memberId, null, 0);
        //将地址变成默认
        memberAddressMapper.updateMemberAddressDefault(memberId, addressId, 1);
    }

    /**
     * 删除收货地址
     * @param memberId
     * @param addressId
     */
    @Transactional
    public void deleteAddress(Integer memberId,Integer addressId){
        memberAddressMapper.deleteByMemberId(memberId,addressId);
    }

}
