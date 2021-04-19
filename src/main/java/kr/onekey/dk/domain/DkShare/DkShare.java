package kr.onekey.dk.domain.DkShare;

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
        name = "DkShare"
)
public class DkShare extends BaseEntity {

    private static final long serialVersionUID = -3671088385704267414L;

    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = true)
    private Date startAt;

    @Column(nullable = true)
    private Date endAt;

    @Override
    public int getStatus() {
        status = super.getStatus();
        return status;
    }

    @Builder
    private DkShare(
            String id,
            String sender,
            String receiver,
            Date startAt,
            Date endAt,
            int status) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.startAt = startAt;
        this.endAt = endAt;
        this.status = status;
    }
}