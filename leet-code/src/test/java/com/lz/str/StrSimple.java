package com.lz.str;

/**
 * 字符串 -- 简单
 * @author lihao
 * @date 2022-01-18 21:07
 */
public class StrSimple {

    /**
     * 13. 罗马数字转整数
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int pre = findValue(chars[0]);
        int result = 0;
        for (int i = 1; i < chars.length; i++) {
            int num = findValue(chars[i]);
            if (pre<num) result -= pre;
            else result += pre;

            pre = num;
        }
        return result + pre;
    }

    private int findValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:return 0;
        }
    }
}
