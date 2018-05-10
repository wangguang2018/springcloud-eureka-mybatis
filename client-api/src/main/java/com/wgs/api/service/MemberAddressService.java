package com.wgs.api.service;

import com.wgs.entity.MemberAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-api")
public interface MemberAddressService {
    /**
     * 保存收货地址
     *
     * @param memberAddress
     */
    @RequestMapping("/address/save")
    void save(MemberAddress memberAddress, @RequestParam("memberId") Integer memberId);

    /**
     * 获取用户地址
     *
     * @param memberId
     * @return
     */
    @RequestMapping("/address/list")
    List<MemberAddress> findMemberAddress(@RequestParam("memberId")Integer memberId);


    /**
     * 将地址设为默认
     *
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/address/default")
    void setAddressDefault(@RequestParam("memberId")Integer memberId, @RequestParam("addressId") Integer addressId);

    /**
     * 删除收货地址
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/address/delete")
    void deleteAddress(@RequestParam("memberId") Integer memberId,@RequestParam("addressId") Integer addressId);
}
