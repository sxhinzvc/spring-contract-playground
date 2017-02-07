package com.julia;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MemberController {

    @RequestMapping(value = "/")
    public Member getMember() {
        return new Member("daniel", "paul");
    }

    @RequestMapping(value = "/", method = POST)
    public List<Member> searchMembers(@RequestBody MemberRequest request) {
        return new ArrayList<>();
    }

}
