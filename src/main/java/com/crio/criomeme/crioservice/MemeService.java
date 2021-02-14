package com.crio.criomeme.crioservice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crio.criomeme.crioRepository.MemeRepository;
import com.crio.criomeme.criomodel.MemeUser;

@Service
public class MemeService {
	
	@Resource
	public MemeRepository memeRepository;

	/**
	 * This method is used to get all meme details
	 * @param index based on this value only the no number of records to be fetch can be decided
	 * @return memeDetails list
	 */
	public List<MemeUser> getAllUser(Integer index) {
		Pageable page=PageRequest.of(index, 100);
		return memeRepository.findAllByOrderByCreatedOnDesc(page);
	}
	/**
	 * This method is used to save the meme 
	 * @param meme the MemeUser model contains meme details
	 * @return memeId -if meme saved successfully
	 * @throws Exception if user tried to post duplicate data then exception will be thrown
	 */
	public Integer saveMemeDetails(MemeUser meme) throws Exception {
		try {
		meme.setCreatedOn(new Date());
		MemeUser memeDetails= memeRepository.save(meme);
		return memeDetails.getId();
		}catch(DataIntegrityViolationException ex) {
			throw new Exception();
		}
	}
	/**
	 * This method is used to get meme detail for given memeId
	 * @param id memeId
	 * @return MemeUser model-contains meme detail
	 * @throws Exception if there is no meme details present for give id exception will be thrown
	 */
	public MemeUser getMemeDetailById(Integer id) throws Exception {
		try {
		Optional<MemeUser> memeDetails= memeRepository.findById(id);
		MemeUser meme =memeDetails.get();
		return meme;
		}catch(Exception ex) {
			throw new Exception();
		}	
	}
	/**
	 * This method is used to update meme details
	 * @param memeData MemeUser model containd meme details
	 * @param id the memeId 
	 * @throws Exception if any error occurs while updating meme details exception will be thrown
	 */
	public MemeUser updateMemeDetails(MemeUser memeData,Integer id) throws Exception {
		try {
		Optional<MemeUser> memeDetails= memeRepository.findById(id);
		MemeUser meme =memeDetails.get();
		meme.setCaption(memeData.getCaption());
		meme.setUrl(memeData.getUrl());
		return memeRepository.save(meme);
		}catch(Exception ex) {
			throw new Exception();
		}	
	}
	
}
