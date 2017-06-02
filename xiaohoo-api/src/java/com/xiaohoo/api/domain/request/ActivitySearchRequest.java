/**
 * 
 */
package com.xiaohoo.api.domain.request;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author haojwang
 *
 */
public class ActivitySearchRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8596566487201804068L;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date date;
	private String location;
	private String keywords;
	/**
	 * 默认1,第一页
	 */
	private Integer page = 1;
	private Integer start;
	private Integer count;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActivitySearchRequest [date=");
		builder.append(date);
		builder.append(", location=");
		builder.append(location);
		builder.append(", keywords=");
		builder.append(keywords);
		builder.append(", page=");
		builder.append(page);
		builder.append(", start=");
		builder.append(start);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}

}
