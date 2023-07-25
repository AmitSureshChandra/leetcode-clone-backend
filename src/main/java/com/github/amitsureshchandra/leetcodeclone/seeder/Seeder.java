package com.github.amitsureshchandra.leetcodeclone.seeder;

import com.github.amitsureshchandra.leetcodeclone.dto.core.Example;
import com.github.amitsureshchandra.leetcodeclone.entity.Question;
import com.github.amitsureshchandra.leetcodeclone.enums.Difficulty;
import com.github.amitsureshchandra.leetcodeclone.enums.Tag;
import com.github.amitsureshchandra.leetcodeclone.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class Seeder {

    final QuestionRepo questionRepo;

    @Value("${run-seeder}")
    private boolean runSeeder;

    public Seeder(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @PostConstruct
    void init() {
        if(runSeeder) {
            seed();
        }
    }

    private void seed() {
        seedQuestions();
    }

    private void seedQuestions() {
        Question q = new Question();

        q.setTitle("addition of 2 numbers");
        q.setCode("add-two-no");
        q.setDescription("Addition of two numbers");
        q.setTags(Arrays.asList(Tag.ARITHMETIC, Tag.MATH));
        q.setDifficulty(Difficulty.BASIC);
        q.setExamples(
                Arrays.asList(
                        new Example("10\n20", "30", "addition of 10 & 20 is 30"),
                        new Example("10\n0", "10", "addition of 10 & 0 is 10")
                )
        );

        q.setConstraints(
                Arrays.asList(
                        "-2^31 <= n1 <= 2^31-1",
                        "-2^31 <= n2 <= 2^31-1"
                )
        );

        questionRepo.save(q);
    }
}