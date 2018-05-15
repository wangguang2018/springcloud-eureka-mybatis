package com.wgs.api.service;

import com.wgs.dto.BaseResult;
import com.wgs.dto.member.MemberInfoDTO;
import com.wgs.entity.MemberAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-api")
public interface MemberAddressService {
    /**
     * 保存收货地址
     *
     * @param memberAddress
     */
    @RequestMapping(value = "/address/save",method = RequestMethod.POST)
    BaseResult save(@RequestBody MemberAddress memberAddress);

    /**
     * 获取用户地址
     *
     * @param memberId
     * @return
     */
    @RequestMapping("/address/list")
    BaseResult<List<MemberAddress>> findMemberAddress(@RequestParam("memberId") Integer memberId);


    /**
     * 将地址设为默认
     *
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/address/default")
    BaseResult setAddressDefault(@RequestParam("memberId") Integer memberId, @RequestParam("addressId") Integer addressId);

    /**
     * 删除收货地址
     *
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/address/delete")
    BaseResult deleteAddress(@RequestParam("memberId") Integer memberId, @RequestParam("addressId") Integer addressId);




}
