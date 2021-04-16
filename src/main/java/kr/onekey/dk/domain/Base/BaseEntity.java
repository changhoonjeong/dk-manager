package kr.onekey.dk.domain.Base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@ToString
public abstract class BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int seqNo;

    @Column(nullable = false)
    protected int status = 1;

    @Column(nullable = true)
    protected String description;

    @Column(nullable = true)
    private String etc1;

    @Column(nullable = true)
    private String etc2;
}
