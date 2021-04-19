package kr.onekey.dk.domain.DkManager;

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
        name = "DKManager"
)
public class DkManager extends BaseEntity {

    private static final long serialVersionUID = -3671088385704267414L;

    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String locationId;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = true)
    private String passwordHash;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private Date lastLoginAt;

    @Column(nullable = true)
    private int loginFailCount;

    @Column(nullable = true)
    private String department;

    @Column(nullable = true)
    private String phoneNumber;

    @Override
    public int getStatus() {
        status = super.getStatus();
        return status;
    }

    @Builder
    private DkManager(
            String id,
            String locationId,
            String loginId,
            String passwordHash,
            String name,
            Date lastLoginAt,
            int loginFailCount,
            String department,
            String phoneNumber) {
        this.id = id;
        this.locationId = locationId;
        this.loginId = loginId;
        this.passwordHash = passwordHash;
        this.name = name;
        this.lastLoginAt = lastLoginAt;
        this.loginFailCount = loginFailCount;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }
}