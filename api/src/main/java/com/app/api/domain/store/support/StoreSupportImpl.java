package com.app.api.domain.store.support;

import com.app.api.domain.store.Store;
import com.app.api.web.dto.StoreDto;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static com.app.api.domain.store.QStore.store;

@Repository
public class StoreSupportImpl extends QuerydslRepositorySupport implements StoreSupport {

        private final JPAQueryFactory jpaQueryFactory;

        private final EntityManager entityManager;


        public StoreSupportImpl(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
                super(Store.class);
                this.jpaQueryFactory = jpaQueryFactory;
                this.entityManager = entityManager;
        }

        @Override
        public void update(long seq, StoreDto dto) {

                UpdateClause<JPAUpdateClause> update = update(store);


                update.where(store.seq.eq(seq)).execute();

        }

}
