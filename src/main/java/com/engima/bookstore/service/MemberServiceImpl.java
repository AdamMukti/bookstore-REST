package com.engima.bookstore.service;

import com.engima.bookstore.constant.ResponseMessage;
import com.engima.bookstore.entity.Member;
import com.engima.bookstore.exception.DataNotFoundException;
import com.engima.bookstore.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(String id) {
        verify(id);
        return memberRepository.findById(id).get();
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMember(Member member) {
        verify(member.getId());
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(String id) {
        verify(id);
        memberRepository.deleteById(id);
    }

    private void verify(String id) {
        if (!memberRepository.findById(id).isPresent()) {
            String msg = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "member", id);
            throw new DataNotFoundException(msg);
        }
    }

}