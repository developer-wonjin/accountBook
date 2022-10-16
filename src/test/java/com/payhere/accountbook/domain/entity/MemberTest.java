package com.payhere.accountbook.domain.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(false)
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void 멤버_가계부_생성한다(){
        Member memberA = new Member("aaa@gmail.com", "1234");
        em.persist(memberA);

        AccountBook accountBook1 = new AccountBook("a", "aa", memberA);
        AccountBook accountBook2 = new AccountBook("b", "bb", memberA);
        em.persist(accountBook1);
        em.persist(accountBook2);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member.accoutBook = " + member.getAccountBooks());
        }
        ;
    }
}