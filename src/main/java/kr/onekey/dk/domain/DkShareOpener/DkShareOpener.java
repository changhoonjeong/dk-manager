package kr.onekey.dk.domain.DkShareOpener;

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
        name = "DkShareOpener"
)
public class DkShareOpener extends BaseEntity {

    private static final long serialVersionUID = -3671088385704267414L;

    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String openerId;

    @Column(nullable = false)
    private String shareId;

    @Override
    public int getStatus() {
        status = super.getStatus();
        return status;
    }

    @Builder
    private DkShareOpener(
            String id,
            String openerId,
            String shareId,
            int status) {
        this.id = id;
        this.openerId = openerId;
        this.shareId = shareId;
        this.status = status;
    }
}