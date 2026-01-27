package study.studyspring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String subject;   // 제목

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;   // 내용

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // 업로드된 파일 원본 이름
    private String originalFileName;

    // 서버에 저장된 파일 경로
    private String filePath;
}
