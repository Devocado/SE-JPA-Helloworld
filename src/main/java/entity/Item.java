package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	private String manufacturer;
	
	private Integer partnumber;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private LocalDateTime created;
	
	public Item(String name, BigDecimal price, String manufacturer, Integer partnumber) {
		this.name = name;
		this.price = price;
		this.manufacturer = manufacturer;
		this.partnumber = partnumber;
	}
	
	public Item() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getPartnumber() {
		return partnumber;
	}

	public void setPartnumber(Integer partnumber) {
		this.partnumber = partnumber;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getCreated() {
		return created;
	}
}
