package erpsolglob.erpsolglobmodel.erpsolglobclasses;

import oracle.adf.share.ADFContext;

public class ERPSolGlobClassModel {
    public ERPSolGlobClassModel() {
        super();
    }

    public static String doGetModelUserName() {
            //return ERPGlobalPLSQLClass.doGetModelUserSno();
            return ADFContext.getCurrent().getPageFlowScope().get("G_USER_NAME").toString();
        }
  

    public static String doGetUserCode(){
        return ADFContext.getCurrent().getSessionScope().get("GLOB_USER_CODE").toString();
    }  
  
    
    public static String doGetUserLocationCode(){
        return ADFContext.getCurrent().getSessionScope().get("GLOB_USER_LOCATION").toString();
    }  
  
    public static String doGetUserStoreCode(){
        return ADFContext.getCurrent().getSessionScope().get("GLOB_USER_STORE").toString();
    } 
 
    public static String doGetUserPictureName() {
            //return ERPGlobalPLSQLClass.doGetModelUserSno();
            try {
                return ADFContext.getCurrent().getPageFlowScope().get("GLOB_USER_PICTURE").toString();
            } catch (NullPointerException e) {
                // TODO: Add catch code
                return null;
            }
        }   
  
    public static Integer doGetUserCompanyCode() {
           return 
             Integer.parseInt(ADFContext.getCurrent().getPageFlowScope().get("GLOB_COMPANY_CODE").toString());
      }
    
}
