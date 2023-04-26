package com.example.toyshop.repository.feed;

import com.example.toyshop.entity.Feed;
import com.example.toyshop.repository.FeedCategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FindFeedByFiltersImpl implements FindFeedByFilters {
    EntityManager em;
    FeedCategoryRepository repository;

    @Override
    public List<Feed> findByFilters(String title, Long categoryId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Feed> cq = cb.createQuery(Feed.class);
        Root<Feed> feed = cq.from(Feed.class);
        List<Predicate> predicates = new ArrayList<>();
        if (title != null) {
            predicates.add(cb.like(feed.get("title"), "%" + title + "%"));
        }
        if (categoryId != null) {
            predicates.add(cb.equal(feed.get("category"), categoryId));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
