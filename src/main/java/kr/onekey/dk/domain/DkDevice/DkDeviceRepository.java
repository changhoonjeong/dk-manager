package kr.onekey.dk.domain.DkDevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface DkDeviceRepository extends JpaRepository<DkDevice, Integer> {

    @Nullable
    DkDevice findByIdAndStatus(String id, int stauts);
}