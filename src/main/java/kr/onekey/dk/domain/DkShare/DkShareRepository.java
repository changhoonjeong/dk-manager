package kr.onekey.dk.domain.DkShare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface DkShareRepository extends JpaRepository<DkShare, Integer> {

    @Nullable
    DkShare findBySenderAndReceiverAndStatus(String sender, String receiver, int status);
}