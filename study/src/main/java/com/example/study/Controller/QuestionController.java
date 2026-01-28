package study.studyspring.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.question.domain.QuestionForm;
import com.mysite.sbb.question.service.QuestionService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    // 목록
    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    // 상세보기
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    // 글쓰기 폼
    @GetMapping("/create")
    public String createForm(QuestionForm form) {
        return "question_form";
    }

    // 글쓰기 처리
    @PostMapping("/create")
    public String create(@Valid QuestionForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "question_form";
        }
        questionService.create(form.getSubject(), form.getContent());
        return "redirect:/question/list";
    }

    // 수정 폼
    @GetMapping("/modify/{id}")
    public String modifyForm(@PathVariable Integer id, QuestionForm form) {
        Question q = questionService.getQuestion(id);
        form.setSubject(q.getSubject());
        form.setContent(q.getContent());
        return "question_form";
    }

    // 수정 처리
    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Integer id, @Valid QuestionForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "question_form";
        }
        Question q = questionService.getQuestion(id);
        questionService.modify(q, form.getSubject(), form.getContent());
        return "redirect:/question/detail/" + id;
    }

    // 삭제
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Question q = questionService.getQuestion(id);
        questionService.delete(q);
        return "redirect:/question/list";
    }
}