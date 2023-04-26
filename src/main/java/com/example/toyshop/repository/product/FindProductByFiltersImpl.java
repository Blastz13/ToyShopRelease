package com.example.toyshop.repository.product;

import com.example.toyshop.entity.Product;
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
public class FindProductByFiltersImpl implements FindProductByFilters {
    EntityManager em;
    CategoryRepository repository;

    @Override
    public List<Product> findByFilters(String title, Long categoryId, Float min_price, Float max_price,
                                       Short delivery_period, Float discount, Float min_rating, Float max_rating) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        if (title != null)
            predicates.add(cb.like(product.get("title"), "%" + title + "%"));
        if (categoryId != null)
            predicates.add(cb.equal(product.get("category"), categoryId));
        if (min_price != null)
            predicates.add(cb.greaterThanOrEqualTo(product.get("new_price"), min_price));
        if (max_price != null)
            predicates.add(cb.lessThanOrEqualTo(product.get("new_price"), max_price));
        if (delivery_period != null)
            predicates.add(cb.equal(product.get("delivery_period"), delivery_period));
        if (discount != null)
            predicates.add(cb.equal(product.get("discount"), discount));
        if (min_rating != null)
            predicates.add(cb.greaterThanOrEqualTo(product.get("rating"), min_rating));
        if (max_rating != null)
            predicates.add(cb.lessThanOrEqualTo(product.get("rating"), max_rating));
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
