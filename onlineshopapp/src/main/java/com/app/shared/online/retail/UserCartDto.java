package com.app.shared.online.retail;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserCartDto {

    private String productId;

    private Integer productStock;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String _productId) {
        this.productId = _productId;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer _productStock) {
        this.productStock = _productStock;
    }
}
