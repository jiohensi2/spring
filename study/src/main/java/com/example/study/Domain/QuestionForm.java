package study.studyspring.domain;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class QuestionForm {

    @NotEmpty(message = "제목은 필수입니다.")
    @Size(max = 200)
    private String subject;   // 제목

    @NotEmpty(message = "내용은 필수입니다.")
    private String content;   // 내용

    // 업로드 파일 (DB 저장 X)
    private MultipartFile file;
}
