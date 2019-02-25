package com.base;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * NoRepositoryBean注解一般用作父类的repository，有这个注解，spring不会去实例化该repository。
 * 如果不加此注解则会报：Not a managed type: interface java.io.Serializable 异常
 */
@NoRepositoryBean
public interface BaseDao<T extends Serializable> extends JpaRepository<T, Integer> {

    /**
     * JPA-查询全部带分页
     * @param pageable
     * @return
     */
    public Page<T> findAll(Pageable pageable);

    /**
     * JPA-查询全部
     * @return
     */
    public List<T> findAll();

    /**
     * JPA-根据id查询
     * @param id
     * @return
     */
    T findById(Integer id);


}
