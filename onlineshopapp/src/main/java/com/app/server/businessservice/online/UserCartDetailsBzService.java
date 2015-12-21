package com.app.server.businessservice.online;
import com.app.shared.online.UserCartDetails;
import java.util.List;

public interface UserCartDetailsBzService {

    public List<UserCartDetails> executeQueryUserCartDetails(String userId1) throws Exception;
}
