package com.springboot.masterclass.util;

import com.springboot.masterclass.util.Sample;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    Sample sample = new Sample();

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.arguments("a", "short"),
                Arguments.arguments("asdflhjhas", "long"),
                Arguments.arguments("malli", "normal")
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testCheckStringType(String value, String expectedValue) {

        assertEquals(expectedValue, sample.checkStingType(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "hello", "howareyou"})
    @EmptySource
    @NullSource
        //@NullAndEmptySource //combination of above two
    void testCheckStringShouldBeNormal(String value) {
        assertEquals("normal", sample.checkStingType(value));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/test.csv", numLinesToSkip = 1)
    void testCheckStringTypeWithCSV(String value, String expectedValue) {
        assertEquals(expectedValue, sample.checkStingType(value));
    }

    @ParameterizedTest
    @CsvSource(value = {"h:short", "hello:normal", "howareyou?:long"}, delimiter = ':')
    void testCheckStringTypeWithInlineCSV(String value, String expectedValue) {
        assertEquals(expectedValue, sample.checkStingType(value));
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void testCheckStringTypeWithEnum(Month val) {
        assertEquals("normal", sample.checkStingType(val.name()));
    }

}