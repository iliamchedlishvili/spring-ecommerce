package home.spring_ecommerce.domain.entities.purchasing;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailComposeId implements Serializable {

    private Long purchaseOrderId;

    private Long purchaseOrderDetailId;

    public OrderDetailComposeId(Long purchaseOrderId, Long purchaseOrderDetailId    ) {
        this.purchaseOrderDetailId = purchaseOrderDetailId;
        this.purchaseOrderId = purchaseOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailComposeId that = (OrderDetailComposeId) o;
        return Objects.equals(purchaseOrderId, that.purchaseOrderId) &&
                Objects.equals(purchaseOrderDetailId, that.purchaseOrderDetailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseOrderId, purchaseOrderDetailId);
    }
}
