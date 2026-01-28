package study.studyspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mysite.sbb.question.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}