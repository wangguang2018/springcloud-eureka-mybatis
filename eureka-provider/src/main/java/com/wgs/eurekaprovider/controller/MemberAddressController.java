package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
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
    public BaseResult save(MemberAddress memberAddress, @RequestParam("memberId") Integer memberId){
        memberAddressService.save(memberAddress,memberId);
        return new BaseResult();
    }

    /**
     * 获取用户地址
     *
     * @param memberId
     * @return
     */
    @RequestMapping("/list")
    public BaseResult<List<MemberAddress>> findMemberAddress(@RequestParam("memberId")Integer memberId) {
        return new BaseResult(memberAddressService.findMemberAddress(memberId));
    }

    /**
     * 将地址设为默认
     *
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/default")
    public BaseResult setAddressDefault(@RequestParam("memberId")Integer memberId, @RequestParam("addressId") Integer addressId) {
        memberAddressService.setAddressDefault(memberId,addressId);
        return new BaseResult();
    }

    /**
     * 删除收货地址
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/delete")
    public BaseResult deleteAddress(@RequestParam("memberId") Integer memberId,@RequestParam("addressId") Integer addressId){
        memberAddressService.deleteAddress(memberId,addressId);
        return new BaseResult();
    }

}
