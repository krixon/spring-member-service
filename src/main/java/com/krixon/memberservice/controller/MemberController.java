package com.krixon.memberservice.controller;

import com.krixon.memberservice.dto.Member;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MemberController
{
    @RequestMapping("/members")
    @PreAuthorize("#oauth2.hasScope('member:read')")
    public ArrayList<Member> getPanelList() {

        // TODO: Real persistence.

        ArrayList<Member> members = new ArrayList<>();

        members.add(new Member("1", "Foo Member"));
        members.add(new Member("2", "Bar Member"));
        members.add(new Member("3", "Baz Member"));

        return members;
    }
}
