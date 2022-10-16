package com.payhere.accountbook.repository;

import com.payhere.accountbook.domain.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() {
        Member member = new Member("aaa@google.com", "1234");
        Member savedMember = memberRepository.save(member);
        Member findMember  = memberRepository.findById(savedMember.getId()).get();

        Assertions.assertThat(findMember).isEqualTo(member); // 두 엔티티 객체가 같다
    }

}