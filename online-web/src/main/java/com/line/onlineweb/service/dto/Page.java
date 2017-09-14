package com.line.onlineweb.service.dto;

import java.util.List;

public class Page<T> {

    private static final int PAGE_SIZE = 10;

    public int pageSize = PAGE_SIZE;
    public int pageNo = 1;
    public long totalSum = -1;
    public int totalPage = -1;

    public List<T> results;

}
