package kr.onekey.dk.domain.DkUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface DkUserRepository extends JpaRepository<DkUser, Integer> {

    @Nullable
    List<DkUser> findByStatus(int status);
}