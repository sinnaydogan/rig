package com.example.rig.entity;

import com.example.rig.log.OrderLoggerListener;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(OrderLoggerListener.class)
public class Order implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_order", allocationSize = 1)
    @GeneratedValue(generator = "seq_order", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private List<Book> bookList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_date")
    private Date orderDate;

}
