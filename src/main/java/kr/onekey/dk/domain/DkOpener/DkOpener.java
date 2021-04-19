package kr.onekey.dk.domain.DkOpener;

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
        name = "DkOpener"
)
public class DkOpener extends BaseEntity {

    private static final long serialVersionUID = -3671088385704267414L;

    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String entranceId;

    @Override
    public int getStatus() {
        status = super.getStatus();
        return status;
    }

    @Builder
    private DkOpener(
            String id,
            String deviceId,
            String entranceId) {
        this.id = id;
        this.deviceId = deviceId;
        this.entranceId = entranceId;
    }
}