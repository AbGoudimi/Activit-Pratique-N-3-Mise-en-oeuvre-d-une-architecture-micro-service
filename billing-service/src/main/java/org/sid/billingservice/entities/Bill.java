package org.sid.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingservice.model.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
    public double getTotal(){
        double somme=0;
        for(ProductItem pi:productItems){
            somme+=pi.getAmount();
        }
        return somme;
    }
}
