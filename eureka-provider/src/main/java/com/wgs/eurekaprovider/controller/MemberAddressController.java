package com.wgs.eurekaprovider.controller;

import com.wgs.entity.MemberAddress;
import com.wgs.eurekaprovider.service.member.MemberAddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController("/address")
public class MemberAddressController {

    @Resource
    private MemberAddressService memberAddressService;

    @RequestMapping("/save")
    public void save(MemberAddress memberAddress,@RequestParam("memberId") Integer memberId){
        memberAddressService.save(memberAddress,memberId);
    }

    /**
     * 获取用户地址
     *
     * @param memberId
     * @return
     */
    @RequestMapping("/list")
    public List<MemberAddress> findMemberAddress(@RequestParam("memberId")Integer memberId) {
        return memberAddressService.findMemberAddress(memberId);
    }

    /**
     * 将地址设为默认
     *
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/default")
    public void setAddressDefault(@RequestParam("memberId")Integer memberId, @RequestParam("addressId") Integer addressId) {
        memberAddressService.setAddressDefault(memberId,addressId);
    }

    /**
     * 删除收货地址
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/delete")
    public void deleteAddress(@RequestParam("memberId") Integer memberId,@RequestParam("addressId") Integer addressId){
        memberAddressService.deleteAddress(memberId,addressId);
    }

}
