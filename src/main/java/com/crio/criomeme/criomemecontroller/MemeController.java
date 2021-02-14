package com.crio.criomeme.criomemecontroller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crio.criomeme.criomodel.MemeUser;
import com.crio.criomeme.crioservice.MemeService;

@RestController
@CrossOrigin()
public class MemeController {

	@Resource
	public MemeService memeService;

	/**
	 * 
	 * This Method used to get all memes
	 * @param index is used to fetch given number of records returns list of
	 * @return list of memes with status 200.
	 */
	@GetMapping("/memes")
	public ResponseEntity<List<MemeUser>> getMemes(
			@RequestParam(value = "fromValue", required = false, defaultValue = "0") Integer index) {
		List<MemeUser> memeuser = memeService.getAllUser(index);
		return new ResponseEntity<>(memeuser, HttpStatus.OK);

	}
	/**
	 * This method is used to get the meme for givenId
	 * @param id is used to fetch single meme
	 * @return single mememodel with 200 
	 * @exception if there is no record found for given id then exception will be  thrown
	 */
	@GetMapping("memes/{id}")
	public ResponseEntity<MemeUser> getMeme(@PathVariable("id") Integer id) {
		try {
			MemeUser memedetails = memeService.getMemeDetailById(id);
			return new ResponseEntity<>(memedetails, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	/**
	 * This methos is used to save the memedetails
	 * @param meme MemeUser model contains meme details
	 * @return id as response
	 * @exception if there is error occurs while save exception will be thrown. 
	 */
	@PostMapping("/memes")
	public ResponseEntity<MemeUser> saveMeme(@RequestBody MemeUser meme) {
		try {
			Integer id = memeService.saveMemeDetails(meme);
			MemeUser saveMeme = new MemeUser();
			saveMeme.setId(id);
			return new ResponseEntity<>(saveMeme, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	/**
	 * This method is used to update the meme detail
	 * @param memedetails MemeUser model contains meme details
	 * @param id memeId 
	 * @return 200 if update happens without error
	 * @exception if there is any error occurs while update memedetails exception will be thrown
	 */
	@PatchMapping("memes/{id}")
	public ResponseEntity<MemeUser> updateMeme(@RequestBody MemeUser memedetails, @PathVariable("id") Integer id) {
		try {
			MemeUser updatedMemedetails = memeService.updateMemeDetails(memedetails, id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
