package kr.onekey.dk.domain.DkShareOpener;

import kr.onekey.dk.domain.DkShare.DkShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface DkShareOpenerRepository extends JpaRepository<DkShareOpener, Integer> {
}