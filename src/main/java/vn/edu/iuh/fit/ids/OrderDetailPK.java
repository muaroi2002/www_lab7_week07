package vn.edu.iuh.fit.ids;

import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.Product;

import java.io.Serializable;

public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
