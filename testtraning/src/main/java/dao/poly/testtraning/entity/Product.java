package dao.poly.testtraning.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = " produce_name")
    private String  produceName;

    @Column(name = "color")
    private String color;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name="origin_price")
    private Double originPrice;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "product_brand",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private List<Brand> brands;
}
