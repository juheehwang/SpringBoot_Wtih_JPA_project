package jpabook.jpashop.service;

import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void signUp()throws Exception{
        //given
        Member member = new Member();
        member.setName("hwang");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member,memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void duplicatedMemberException() throws Exception{

        //given
        Member member1 = new Member();
        member1.setName("hwang");

        Member member2 = new Member();
        member2.setName("hwang");
        //when
        memberService.join(member1);
        memberService.join(member2);

        //then
        fail("예외가 발생해야한다.");
    }
}