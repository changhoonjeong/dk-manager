package kr.onekey.dk.domain.DkEntrance;

import kr.onekey.dk.domain.Base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
@ToString
@Table(
        name = "DkEntrance"
)
public class DkEntrance extends BaseEntity {

    private static final long serialVersionUID = -3671088385704267414L;

    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String deviceId;

    @Override
    public int getStatus() {
        status = super.getStatus();
        return status;
    }

    @Builder
    private DkEntrance(
            String id,
            String name,
            String deviceId) {
        this.id = id;
        this.name = name;
        this.deviceId = deviceId;
    }
}