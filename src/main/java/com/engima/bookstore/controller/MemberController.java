package com.engima.bookstore.controller;

import com.engima.bookstore.entity.Member;
import com.engima.bookstore.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public Member add(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable String id) {
        return memberService.getMemberById(id);
    }

    @GetMapping
    public List<Member> getAll(){
        return memberService.getAllMember();
    }

    @PutMapping
    public Member update(@RequestBody Member member){
        return memberService.updateMember(member);
    }

    @DeleteMapping
    public void delete(@RequestParam String id){
        memberService.deleteMember(id);
    }

}
