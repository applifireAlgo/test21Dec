package com.app.shared.online;
import com.athena.server.bizService.DTOMapperInterface;

public class UserCartDetails implements DTOMapperInterface {

    private Integer productQty;

    private Double cartTotal;

    private String userId;

    private String productName;

    private String productDesc;

    private Double productUnitPrice;

    private Integer productStock;

    public UserCartDetails(Object[] aryObject) {
        if (aryObject != null) {
            productQty = (java.lang.Integer) aryObject[0];
            cartTotal = (java.lang.Double) aryObject[1];
            userId = (java.lang.String) aryObject[2];
            productName = (java.lang.String) aryObject[3];
            productDesc = (java.lang.String) aryObject[4];
            productUnitPrice = (java.lang.Double) aryObject[5];
            productStock = (java.lang.Integer) aryObject[6];
        } else {
            productQty = null;
            cartTotal = null;
            userId = null;
            productName = null;
            productDesc = null;
            productUnitPrice = null;
            productStock = null;
        }
    }

    public Integer getProductQty() {
        return productQty;
    }

    public Double getCartTotal() {
        return cartTotal;
    }

    public String getUserId() {
        return userId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public Double getProductUnitPrice() {
        return productUnitPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }
}
