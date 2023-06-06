package test;

import java.nio.charset.StandardCharsets;

public class MainTest {

    public static void main(String[] args) {

        String str = "中文";
        byte[] strByte = str.getBytes(StandardCharsets.UTF_8);
        System.out.println("");

    }
}
