package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void signUpTest() {
        // given
        Member member = new Member();
        member.setName("jinsuo");

        // when
        Long id = memberService.signUp(member);

        // then
        Member findMember = memberService.findById(id).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateSignUp(){
        // given
        Member member1 = new Member();
        member1.setName("sana");
        Member member2= new Member();
        member2.setName("sana");

        // when
        memberService.signUp(member1);

        // then
        // 예외처리 방법 try catch
//        try {
//            memberService.signUp(member2); // exception 발생 !
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("Already Exist name");
//        }

        //  예외처리 방법 assertThrow
        // 람다식이 실행할 때 기대되는 예외를 지정
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.signUp(member2));
        assertThat(e.getMessage()).isEqualTo("Already Exist name");
    }

    @Test
    void findAllMemberTest() {
    }

    @Test
    void findByIdTest() {
    }
}