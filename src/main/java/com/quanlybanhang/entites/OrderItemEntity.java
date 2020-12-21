package com.quanlybanhang.entites;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orderphone_item")
public class OrderItemEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemid")
    private ItemEntity item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    private OrderEntity order;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "totalprice", nullable = false)
    private int totalPrice;

    @Column(name = "amount", nullable = false)
    private int amount;
}
