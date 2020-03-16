package com.illunex.invest.communication.service.file;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;

public class FileServiceImplTest {
    @Test
    public void timeString() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yMdHmsn")));
    }
}