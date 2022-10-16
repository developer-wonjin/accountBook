package com.payhere.accountbook.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "email", "password"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String email;

    private String password;

    @OneToMany(mappedBy = "member")
    private List<AccountBook> accountBooks = new ArrayList<>();

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
