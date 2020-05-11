package com.apollo;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/9
 */
public class CustomBlockHandler {
    public static String exceptionHandler(BlockException block) {
        return "------------- 不可用" + block;
    }
}
