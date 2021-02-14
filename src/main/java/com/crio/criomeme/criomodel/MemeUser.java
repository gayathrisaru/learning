package com.crio.criomeme.criomodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meme_det")
public class MemeUser {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@Column(name="name")
	String name;
	@Column(name="caption")
	String caption;
	@Column(name="url")
	String url;
	@Column(name="created_on")
	Date createdOn;
	@Column(name="updated_on")
	Date updatedOn;

	/**
	 * Method is used to get the MemeId
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Method is used to set the MemeId
	 * @param id MemeId
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Method is used to get the Memename
	 * @return memeName as name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method is used to set the MemeName
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * Method is used to set the MemeCaption
     * @return caption
     */
	public String getCaption() {
		return caption;
	}
	/**
	 * Method is used to set the MemeCaption
	 * @param caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * Method is used to set the MemeUrl
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Method is used to get the MemeUrl
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * Method is used to get the MemmeCreatedOn date
	 * @return createdOndate
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * Method is used to set the MemmeCreatedOn date
	 * @param createdOn
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * Method is used to get the MemmeupdatedOn date
	 * @return updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}
	/**
	 * Method is used to set the MemmeupdatedOn date
	 * @param updatedOn
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
