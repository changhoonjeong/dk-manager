package kr.onekey.dk.domain.DkManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface DkManagerRepository extends JpaRepository<DkManager, Integer> {
    
    @Nullable
    DkManager findByLoginId(String loginId);
}