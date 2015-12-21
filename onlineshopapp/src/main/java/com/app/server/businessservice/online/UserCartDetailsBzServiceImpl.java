package com.app.server.businessservice.online;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.online.UserCartDetails;
import java.lang.Override;
import java.util.List;

@Component
public class UserCartDetailsBzServiceImpl implements UserCartDetailsBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<UserCartDetails> executeQueryUserCartDetails(String userId1) throws Exception {
        java.util.List<com.app.shared.online.UserCartDetails> listDtoInterface = new java.util.ArrayList<com.app.shared.online.UserCartDetails>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "EEB68751-1621-4186-A398-F7A795133D3F");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectUserId1 = new atg.taglib.json.util.JSONObject();
            jsonObjectUserId1.put("name", "userId");
            jsonObjectUserId1.put("value", userId1);
            jsonObjectUserId1.put("datatype", "VARCHAR");
            jsonObjectUserId1.put("index", 1);
            jsonArray.add(jsonObjectUserId1);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.online.UserCartDetails", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
