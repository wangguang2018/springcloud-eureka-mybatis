package com.wgs.api.controller;

import com.wgs.api.service.MemberService;
import com.wgs.dto.BaseResult;
import com.wgs.entity.MemberToken;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/member")
public class MemberController extends BaseApiController {

    @Resource
    private MemberService memberService;

    /**
     * 小程序登录
     * @param code
     * @param nickname
     * @param avatar
     * @return
     */
    @RequestMapping("/login")
    public ResponseDTO login(@RequestParam("code") String code, @RequestParam("nickname") String nickname, @RequestParam("avatar") String avatar){
        BaseResult<MemberToken> memberToken = memberService.login(code,nickname,avatar);
        return ResponseDTO.ok().addAttribute("data",memberToken.getContent());
    }

}
