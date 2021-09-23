package com.bacancy.spboot.dto;

public class CategoryDto {
	private Long id;
	private String categoryName;
	private String categoryPictureUrl;

	public CategoryDto() {

	}

	public CategoryDto(Long id, String categoryName, String categoryPictureUrl) {
		this.id = id;
		this.categoryName = categoryName;
		this.categoryPictureUrl = categoryPictureUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryPictureUrl() {
		return categoryPictureUrl;
	}

	public void setCategoryPictureUrl(String categoryPictureUrl) {
		this.categoryPictureUrl = categoryPictureUrl;
	}

}
