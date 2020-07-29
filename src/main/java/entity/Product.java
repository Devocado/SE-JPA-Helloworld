package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Objects;

@Entity
@Table(name = "products")
//@NamedQuery(name = Product.SET_QUANTITY, query = "update ")
public class Product {
    public static final String SET_QUANTITY = "Product.setQuantity";

    @Id
    @Column(name = "part_no")
    private Long partNo;

    private String name;

    private BigDecimal price;

    private String manufacturer;

    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime created;

    public Product(Long partnumber, String name, BigDecimal price) {
            this.partNo = partnumber;
            this.name = name;
            this.price = price;
    }

    protected Product() {}

    public Long getPartnumber() {
            return partNo;
    }

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

    public LocalDateTime getCreated() {
            return created;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.partNo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.partNo, other.partNo)) {
            return false;
        }
        return true;
    }
        
        
}
