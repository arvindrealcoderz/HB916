//BookEntity.java
package com.nt.entity;

import lombok.Data;

@Data
public class BookEntity {
	private Integer bookId;
	private String bookName;
	private String bookAuthor;
	private Double bookPrice;
	private String bookType;

}
