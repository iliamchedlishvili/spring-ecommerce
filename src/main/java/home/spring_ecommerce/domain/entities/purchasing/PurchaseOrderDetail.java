package home.spring_ecommerce.domain.entities.purchasing;

import jakarta.persistence.*;
import java.math.BigDecimal;

public class PurchaseOrderDetail {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id", nullable = false)
    private PurchaseOrder purchaseOrder;

    private int purchaseOrderDetailId;

    private BigDecimal price;

    private BigDecimal quantity;
}
