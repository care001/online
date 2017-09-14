package com.line.onlineweb.service.impl;

import com.line.onlineweb.service.FootShowService;
import com.line.onlineweb.service.dto.FootShowDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FootShowServiceImpl implements FootShowService{

    @Override
    public List<FootShowDTO> findAllNextFoot() {
        return null;
    }

    @Override
    public List<FootShowDTO> findBySeachMap(Map<String, Object> map) {
        return null;
    }

}
