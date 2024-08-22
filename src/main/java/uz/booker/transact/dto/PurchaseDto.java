package uz.booker.transact.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDto {

    private Long id;
    private Long customerId;
    private Double price;
}
