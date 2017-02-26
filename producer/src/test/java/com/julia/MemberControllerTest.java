package com.julia;

import org.junit.Rule;
import org.springframework.restdocs.JUnitRestDocumentation;

import static org.junit.Assert.*;

public class MemberControllerTest {

    @Rule
    public JUnitRestDocumentation restDocumentation =
            new JUnitRestDocumentation("build/generated-snippets");
}