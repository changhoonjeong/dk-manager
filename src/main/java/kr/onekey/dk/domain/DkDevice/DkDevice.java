package kr.onekey.dk.domain.DkDevice;

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
        name = "DkDevice"
)
public class DkDevice extends BaseEntity {

    private static final long serialVersionUID = -3671088385704267414L;

    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private int type;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String bleAddress;

    @Column(nullable = false)
    private String macAddress;

    @Override
    public int getStatus() {
        status = super.getStatus();
        return status;
    }

    @Builder
    private DkDevice(
            String id,
            int type,
            String uuid,
            String bleAddress,
            String macAddress
            ) {
        this.id = id;
        this.type = type;
        this.uuid = uuid;
        this.bleAddress = bleAddress;
        this.macAddress = macAddress;
    }
}