package com.wgs.eurekaprovider.controller;

import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.entity.MemberToken;
import com.wgs.eurekaprovider.service.goods.GoodsCarService;
import com.wgs.eurekaprovider.service.member.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MemberController{

    @Resource
    private MemberService memberService;

    @Resource
    private GoodsCarService goodsCarService;

    @RequestMapping("/login")
    public MemberToken login(@RequestParam("code") String code, @RequestParam("nickname") String nickname, @RequestParam("avatar") String avatar){
        return memberService.loginWithXcx(code,nickname,avatar);
    }

    @RequestMapping("/findGoodsCarByMemberId")
    public List<GoodsCarDTO> findByMemberId(@RequestParam("memberId") Integer memberId){
        return goodsCarService.findGoodsCarByMember(memberId);
    }

}
