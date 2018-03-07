package com.xwbing.util;

import com.alibaba.fastjson.JSONArray;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者: xiangwb
 * 说明: 列表分页工具类
 */
public class PageUtil {
    private int start;

    public static Map<String, Object> page(JSONArray array, int currentPage, int pageSize) {
        Map<String, Object> pageMap = new HashMap<>();
        int size = array.size();
        pageMap.put("count", size);
        int start = (currentPage - 1) * pageSize;
        if (start >= size) {
            pageMap.put("data", Collections.emptyList());
        }
        int end = pageSize * currentPage>size?size:pageSize * currentPage;
        pageMap.put("data", array.subList(start, end));
        int totalPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
        pageMap.put("totalPage", totalPage);
        return pageMap;
    }
}
