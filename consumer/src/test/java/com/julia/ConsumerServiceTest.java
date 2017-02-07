package com.julia;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE, properties="server.context-path=/app")
@AutoConfigureStubRunner(ids = {"com.hcsc.experience:producer:+:stubs:6565"}, workOffline = true)
@DirtiesContext
public class ConsumerServiceTest {

    @Autowired
    private ConsumerService service;

    @Test
    @Ignore
    public void shouldSuccessfullyGetAMember() throws Exception {
        ProducerResponse response = service.callProducer();

        assertEquals(response.getFirstName(), "daniel");
        assertEquals(response.getLastName(), "paul");
    }
}