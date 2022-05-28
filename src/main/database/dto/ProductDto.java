package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private long id;
    private String name;
    private Double price;

    public ProductDto(long id, String name,double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
