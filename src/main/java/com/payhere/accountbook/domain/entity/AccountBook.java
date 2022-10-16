package com.payhere.accountbook.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class AccountBook {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;
    private String name;
    private String purpose;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public AccountBook(String name, String purpose) {
        this.name = name;
        this.purpose = purpose;
    }

    public AccountBook(String name, String purpose, Member member) {
        this.name = name;
        this.purpose = purpose;
        this.member = member;
    }
}
