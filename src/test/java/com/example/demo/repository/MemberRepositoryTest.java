package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각각의 태스트마다 돌려주는 AfterEach
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void saveTest(){
        Member member = new Member();
        member.setName("jinsuo");

        repository.saveMember(member);
        Member res = repository.findById(member.getId()).get();
        // Assertions.assertEquals(member, null); // expect는 member actual은 res
        assertThat(res).isEqualTo(member);
    }

    @Test
    public void findByNameTest(){
        Member member1 = new Member();
        member1.setName("sana");
        repository.saveMember(member1);

        Member member2 = new Member();
        member2.setName("jinsuo");
        repository.saveMember(member2);
        
        Member res = repository.findByName("sana").get();
        assertThat(res).isEqualTo(member1);
    }

    @Test
    public void findAllTest(){
        List<Member> list = new ArrayList<>();
        List<Member> res = new ArrayList<>();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();

        member1.setName("jinsuo");
        member1.setName("sana");
        member1.setName("jinsuo1");
        member1.setName("jinsuo2");

        list.add(member1);
        list.add(member2);
        list.add(member3);
        list.add(member4);

        repository.saveMember(member1);
        repository.saveMember(member2);
        repository.saveMember(member3);
        repository.saveMember(member4);

        res = repository.findAll();
        assertThat(res).isEqualTo(list);
    }
}
