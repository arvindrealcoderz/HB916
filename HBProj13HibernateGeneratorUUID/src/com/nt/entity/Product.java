package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data

public class Product implements Serializable {
	private String pid;
	private String pname;
	private Double qty;
	private Double price;
	private String status;

}
