package com.project.pdh.service;

import com.project.pdh.domain.NeedInfo;
import org.springframework.data.domain.Page;

public interface NeedInfoService {

    Page<NeedInfo> readAll(int pageNumber, String search);
}
