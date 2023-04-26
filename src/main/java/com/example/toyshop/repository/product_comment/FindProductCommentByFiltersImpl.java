package com.example.toyshop.repository.product_comment;

import com.example.toyshop.entity.ProductComment;
import com.example.toyshop.repository.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FindProductCommentByFiltersImpl implements FindProductCommentByFilters {
    EntityManager em;
    CategoryRepository repository;

    @Override
    public List<ProductComment> findByFilters(Long productId, Float min_rating, Float max_rating) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductComment> cq = cb.createQuery(ProductComment.class);
        Root<ProductComment> root = cq.from(ProductComment.class);
        List<Predicate> predicates = new ArrayList<>();
        if (productId != null) {
            predicates.add(cb.equal(root.get("product"), productId));
        }
        if (min_rating != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("rating"), min_rating));
        }
        if (max_rating != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("rating"), max_rating));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
