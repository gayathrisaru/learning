package com.crio.criomeme.crioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crio.criomeme.criomodel.MemeUser;

@Repository
public interface MemeRepository extends JpaRepository<MemeUser,Integer>{

	public List<MemeUser> findAllByOrderByCreatedOnDesc(Pageable page);
	
	public Optional<MemeUser> findById(Integer id);
}
