package com.app.server.businessservice.online.portal;
import com.app.server.repository.ProductRepository;
import com.app.server.repository.UserCartRepository;
import com.app.shared.portal.UserCart;
import com.app.shared.retail.Product;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.online.retail.UserCartDto;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class UserCartService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ProductRepository<Product> productRepository;

    @Autowired
    private UserCartRepository<UserCart> userCartRepository;

    public void processCart(UserCartDto userCart) throws SpartanPersistenceException, Exception {
        if ((userCart != null && userCart.getProductId() != null && userCart.getProductStock() != null)) {
            com.app.shared.retail.Product product = productRepository.findById(userCart.getProductId());
            com.app.shared.portal.UserCart userCart2 = new com.app.shared.portal.UserCart();
            userCart2.setProductId(userCart.getProductId());
            userCart2.setProductQty(userCart.getProductStock());
            userCart2.setCartTotal(userCart.getProductStock() * product.getProductUnitPrice());
            userCart2.setUserId(runtimeLogInfoHelper.getRuntimeLogInfo().getUserId());
            com.app.shared.portal.UserCart userCart3 = userCartRepository.save(userCart2);
        }
    }
}
