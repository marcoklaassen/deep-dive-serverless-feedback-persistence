package click.klaassen.feedback;

import io.quarkus.funqy.Funq;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static click.klaassen.feedback.Feedback.builder;

@ApplicationScoped
@Slf4j
public class FeedbackFunction {

    @Inject
    EntityManager em;

    @Transactional
    @Funq
    public void feedback(Integer rating) {
        log.info("Feedback persistence got rating: {}", rating);
        em.persist(builder().rating(rating).build());
    }
}