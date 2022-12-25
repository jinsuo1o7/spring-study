package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/signup")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/signup")
    public String signup(MemberForm form) { // input의 name값과 MemberForm의 필드 name이 매칭이 됨
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member.getName() = " + member.getName());

        memberService.signUp(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberService.findAllMember();
        model.addAttribute("members", members);
        return "members/memberlist";
    }
}
