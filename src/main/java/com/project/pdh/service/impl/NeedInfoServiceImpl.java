package com.project.pdh.service.impl;


import com.project.pdh.domain.NeedInfo;
import com.project.pdh.entity.NeedInfoEntity;
import com.project.pdh.repostitory.NeedInfoRepository;
import com.project.pdh.service.NeedInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NeedInfoServiceImpl implements NeedInfoService {

    private final NeedInfoRepository needInfoRepository;

    public NeedInfoServiceImpl(NeedInfoRepository needInfoRepository) {
        this.needInfoRepository = needInfoRepository;
    }

    @Override
    public Page<NeedInfo> readAll(int pageNumber, String search) {
        // 페이지 번호와 페이지 사이즈를 설정하여 페이지네이션을 위한 Pageable 객체 생성
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.ASC, "id");

        // Spring Data JPA를 사용하여 페이지네이션된 데이터 가져오기
        Page<NeedInfoEntity> page = null;
        if(search == null){
            page = needInfoRepository.findAll(pageable);
        }else {
            page = needInfoRepository.findByPrkplceNmContainingOrAndRdnmadrContaining(pageable, search, search);
        }

        // 가져온 엔티티를 도메인 객체로 변환하여 반환
        return page.map(NeedInfo::toDomain);
    }

}
