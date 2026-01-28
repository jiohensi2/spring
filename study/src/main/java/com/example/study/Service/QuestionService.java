package study.studyspring.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.question.repository.QuestionRepository;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    // 전체 목록
    public List<Question> getList() {
        return questionRepository.findAll();
    }

    // 단건 조회
    public Question getQuestion(Integer id) {
        Optional<Question> q = questionRepository.findById(id);
        return q.orElseThrow(() -> new RuntimeException("Question not found"));
    }

    // 생성
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);
    }

    // 수정
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        questionRepository.save(question);
    }

    // 삭제
    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
