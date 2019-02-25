package com.dao;

import com.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 09:45:11
 */
@Mapper
public interface UserDao extends JpaRepository<UserInfo,Long> {

	Page<UserInfo> findAll(Pageable pageable);

	/**通过username查找用户信息;*/
	UserInfo findByUsername(String username);

	UserInfo findByUserCode(String userCode);

	UserInfo findById(Integer id);
}
