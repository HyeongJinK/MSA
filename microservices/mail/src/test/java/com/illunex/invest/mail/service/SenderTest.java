package com.illunex.invest.mail.service;

import com.illunex.invest.mail.dto.SenderDto;
import org.assertj.core.util.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

public class SenderTest {
    @Test
    public void send() {
        Sender sender = new Sender();
        SenderDto dto = new SenderDto("manager@illunex.com"
                , Lists.newArrayList("wkzkfmxk12@illunex.com")
                , "테스트"
                , "안녕하세요");

        sender.send(dto);
    }

}