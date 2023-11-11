package erpsolglob.erpsolglobmodel.erpsolglobclasses;

import oracle.adf.share.ADFContext;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;

public class ERPSolGlobClassModel {
    public ERPSolGlobClassModel() {
        super();
    }

    public static String doGetModelUserName() {
            //return ERPGlobalPLSQLClass.doGetModelUserSno();
            return ADFContext.getCurrent().getPageFlowScope().get("GLOB_USER_NAME").toString();
        }
  

    public static String doGetUserCode(){
        return ADFContext.getCurrent().getPageFlowScope().get("GLOB_USER_CODE").toString();
    }  
  
 
    public static String doGetUserRegionCode(){
        return ADFContext.getCurrent().getPageFlowScope().get("GLOB_USER_REGION").toString();
    }  
    
    public static String doGetUserLocationCode(){
        return ADFContext.getCurrent().getPageFlowScope().get("GLOB_USER_LOCATION").toString();
    }  
  
    public static String doGetUserStoreCode(){
        return ADFContext.getCurrent().getPageFlowScope().get("GLOB_USER_STORE").toString();
    } 
 
    public static String doGetUserHLevel(){
        return ADFContext.getCurrent().getPageFlowScope().get("GLOB_H_LEVEL").toString();
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
  
    public static String doGetUserCompanyCode() {
           return 
             ADFContext.getCurrent().getPageFlowScope().get("GLOB_COMPANY_CODE").toString();
      }
  
    public static oracle.jbo.domain.Date doGetOracleJBOCurrentDate() {
         return new oracle.jbo.domain.Date(new java.sql.Timestamp(System.currentTimeMillis()));
     }
// 
    public static String doGetModuleId() {
           return 
             ADFContext.getCurrent().getPageFlowScope().get("GLOB_ERP_MODULE_ACTION").toString();
      }
    
    public static String doGetERPSolPrimaryKeyValueModel(DBTransaction pDbt, String pColumnName, String pTableName,
                                                 String pWhereColumn, String pWhereColumnValue) {
        String qry = "";
        try {
            ApplicationModule am = pDbt.getRootApplicationModule();
            ViewObject vo = am.findViewObject("ERPSolPkGen");
            if (vo != null) {
                vo.remove();
            }
            qry = "select  "+ pColumnName + " as pk from " + pTableName;
            if (pWhereColumn != null) {
                qry += " where " + pWhereColumn + "='" + pWhereColumnValue + "'";
            }
            vo = am.createViewObjectFromQueryStmt("ERPSolPkGen", qry);
            vo.executeQuery();
            
            if (vo.first().getAttribute(0)==null) {
                return "1";
           }
            return vo.first().getAttribute(0).toString();
        } catch (Exception e) {
            throw new JboException("Error While Execution Primary Key Query (" + qry + ")");
        }
    }
    
}
