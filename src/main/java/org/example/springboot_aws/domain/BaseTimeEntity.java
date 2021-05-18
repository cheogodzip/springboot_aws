package org.example.springboot_aws.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 이 클래스를 상속받는 경우, 여기 필드들도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함
public class BaseTimeEntity { // 생성, 수정 시간을 자동으로 관리하는 역할.

    @CreatedDate // entity가 생성되고 저장될 때 시간이 자동으로 저장됨.
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회환 entity 값을 변경할 때 시간이 자동으로 저장됨.
    private LocalDateTime modifiedDate;
}
