package com.root.algo;/**
 * CreateBy zxmao on  2020/11/12 0012 09:44
 */

import java.nio.charset.Charset;

/**
 * Copyright (C) zhongda
 *
 * @author zx
 * @date 2020/11/12 0012 09:44
 * @description:
 */
public class BinaryTest {
    public static void main(String[] args) {
        String s = "你好";

        //获取系统默认编码
        System.out.println("系统默认编码：" + System.getProperty("file.encoding")); //查询结果GBK
        //系统默认字符编码
        System.out.println("系统默认字符编码：" + Charset.defaultCharset()); //查询结果GBK
        //操作系统用户使用的语言
        System.out.println("系统默认语言：" + System.getProperty("user.language")); //查询结果zh
    }
}
