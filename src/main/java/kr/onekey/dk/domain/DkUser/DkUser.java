package kr.onekey.dk.domain.DkUser;

import kr.onekey.dk.domain.Base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
@ToString
@Table(
        name = "DkUser"
)
public class DkUser extends BaseEntity {

    private static final long serialVersionUID = -3671088385704267414L;

    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private int type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String authToken;

    @Column(nullable = true)
    private Date lastLoginAt;

    @Column(nullable = true)
    private Date lastValidTryAt;

    @Override
    public int getStatus() {
        status = super.getStatus();
        return status;
    }

    @Builder
    private DkUser(
            String id,
            int type,
            String name,
            String phoneNumber,
            String email,
            String authToken,
            Date lastLoginAt,
            Date lastValidTryAt) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.authToken = authToken;
        this.lastLoginAt = lastLoginAt;
        this.lastValidTryAt = lastValidTryAt;
    }
}