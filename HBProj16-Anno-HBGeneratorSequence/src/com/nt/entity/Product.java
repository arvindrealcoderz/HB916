package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity

@Table(name = "HB_Product_Sequence")
public class Product {
	@Id
	@GenericGenerator(name = "gen11",strategy = "sequence")
	@GeneratedValue(generator = "gen11")
//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	private String pname;
	private Double qty;
	private Double price;
	private String status;

}
