package com.engima.bookstore.service;

import com.engima.bookstore.entity.Member;

import java.util.List;

public interface MemberService {
    public Member addMember(Member member);
    public Member getMemberById(String id);
    public List<Member> getAllMember();
    public Member updateMember(Member member);
    public void deleteMember(String id);
}
