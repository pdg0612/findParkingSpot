package com.project.pdh.repostitory;

import com.project.pdh.entity.NeedInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NeedInfoRepository extends JpaRepository<NeedInfoEntity, Long> {
    Page<NeedInfoEntity> findByPrkplceNmContainingOrAndRdnmadrContaining(Pageable pageable, String PrkplceNm, String Rdnmadr);
}
