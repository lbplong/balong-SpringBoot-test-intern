package com.BaLong.Payload.Response;

import java.util.List;

import com.BaLong.DTO.PostDTO;

public class PostResponse {
	private String date;
	private Integer page;
	private Integer amount;
	private List<PostDTO> listItems;

	public PostResponse(String date, Integer page, Integer amount, List<PostDTO> listItems) {
		this.date = date;
		this.page = page;
		this.amount = amount;
		this.listItems = listItems;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public List<PostDTO> getListItems() {
		return listItems;
	}

	public void setListItems(List<PostDTO> listItems) {
		this.listItems = listItems;
	}

}
