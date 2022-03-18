package com.example.mcsefa.DAO.specifications;

import com.example.mcsefa.entities.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerSpecifications {

    public static Specification<Customer> phoneNumber(String phoneNumber) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("phoneNumber"), phoneNumber);
            }
        };
    }

    public static Specification<Customer> withPhoneNumber(String phoneNumber) {
        return (root, query, cb) -> phoneNumber == null ? null : cb.like(root.get("phoneNumber"), phoneNumber);
    }

    public static Specification<Customer> withNameContains(String name) {
        return (root, query, cb) -> name == null ? null : cb.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Customer> name(String name) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name"), name);
            }
        };
    }

    public static Specification<Customer> bankCode(String bankCode) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("bankCode"), bankCode);
            }
        };
    }
}
