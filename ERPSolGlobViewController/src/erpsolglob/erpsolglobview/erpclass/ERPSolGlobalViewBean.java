package erpsolglob.erpsolglobview.erpclass;

import oracle.adf.share.ADFContext;

public class ERPSolGlobalViewBean {
    public ERPSolGlobalViewBean() {
        super();
    }
    public static String doGetUserCode(){
        return ADFContext.getCurrent().getSessionScope().get("GLOB_USER_CODE").toString();
    }
    
    public static String doGetUserLocation(){
        return ADFContext.getCurrent().getSessionScope().get("GLOB_USER_LOCATION").toString();
    }
    
    
    public static String doGetUserStore(){
        return ADFContext.getCurrent().getSessionScope().get("GLOB_USER_STORE").toString();
    }
    
   
}
