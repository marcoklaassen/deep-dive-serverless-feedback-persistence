package click.klaassen.feedback;

import io.quarkus.funqy.Funq;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
public class FeedbackFunction {

    @Inject
    EntityManager em;

    @Transactional
    @Funq
    public Integer feedback(Integer rating) {
        log.info("Feedback persistence got rating: {}", rating);
        em.persist(Feedback.builder().rating(rating).build());
        return rating;
    }
}