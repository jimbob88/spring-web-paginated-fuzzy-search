package uk.ac.sheffield.genericsearchdemo.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericSearchService {
    private final EntityManager entityManager;

    @Autowired
    public GenericSearchService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private <T> Predicate predicate(CriteriaBuilder criteriaBuilder, Root<T> root, String column, String searchTerm) {
        return criteriaBuilder.like(
                criteriaBuilder.lower(root.get(column)),
                "%" + searchTerm.toLowerCase() + "%"
        );
    }

    private <T> Long count(CriteriaBuilder criteriaBuilder, Class<T> entityType, String column, String searchTerm) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);

        Root<T> table = countQuery.from(entityType);

        countQuery.select(criteriaBuilder.count(table)).where(predicate(criteriaBuilder, table, column, searchTerm));
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private <T> Page<T> page(CriteriaBuilder criteriaBuilder, Class<T> entityType, String column, String searchTerm, Pageable pageable, Long totalResults) {
        CriteriaQuery<T> query = criteriaBuilder.createQuery(entityType);
        Root<T> table = query.from(entityType);
        query.where(predicate(criteriaBuilder, table, column, searchTerm));

        TypedQuery<T> typedQuery = entityManager
                .createQuery(query)
                .setFirstResult(Math.toIntExact(pageable.getOffset()))
                .setMaxResults(pageable.getPageSize());
        List<T> results = typedQuery.getResultList();
        return new PageImpl<>(results, pageable, totalResults);
    }

    public <T> Page<T> search(Class<T> entityType, String column, String searchTerm, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        Long totalResults = count(criteriaBuilder, entityType, column, searchTerm);

        return page(criteriaBuilder, entityType, column, searchTerm, pageable, totalResults);
    }
}
