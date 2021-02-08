package xyz.itclay.randomNumber;

import org.junit.Test;
import xyz.itclay.usermanager.utils.RandomCodeUtils;

public class TestNumber {
    @Test
    public void test1(){
        String s = RandomCodeUtils.randomNumber(6);
        System.out.println(s);
    }
}
