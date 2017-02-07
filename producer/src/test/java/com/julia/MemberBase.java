package com.julia;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class MemberBase {

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(new MemberController());
    }

    public void assertThatRejectionReasonIsNull(Object rejectionReason) {
        assert rejectionReason == null;
    }
}
