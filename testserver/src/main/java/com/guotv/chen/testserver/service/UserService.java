package com.guotv.chen.testserver.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guotv.chen.testserver.entity.User;
import com.guotv.chen.testserver.repository.UserRepository;

@Service
@Transactional
public class UserService {
	private static Logger Log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	public String addUser(User user){
		try{
			userRepository.save(user);
			return "添加成功";
		}catch(Exception e){
			Log.error(e.getMessage(),e);
			return "失败";
		}
		
	}
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	public Page<User> queryUsers(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	public Page<User> queryByUser(Pageable pageable){
		return userRepository.findAll(new Specification<User>(){

			@Override
			public Predicate toPredicate(Root<User> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				query.where(cb.like(root.get("name"),"%1%"),cb.like(root.get("pwd"), "%1%"));
				return null;
			}
			
		}, pageable);
	}
}
