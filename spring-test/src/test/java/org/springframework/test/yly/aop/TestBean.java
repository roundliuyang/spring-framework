package org.springframework.test.yly.aop;

public class TestBean {
    private String testStr = "testStr";

    public TestBean() {
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("test");
    }
}