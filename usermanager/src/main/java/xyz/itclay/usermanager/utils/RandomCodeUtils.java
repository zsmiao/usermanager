package xyz.itclay.usermanager.utils;

import java.util.Random;

/**
 * 生成随机验证码
 *
 * @author ZhangSenmiao
 * @date 2021/2/8 21:53
 **/
public class RandomCodeUtils {
    /**
     * @param length 验证码的长度
     * @return 验证码
     */
    public static String randomNumber(int length) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
