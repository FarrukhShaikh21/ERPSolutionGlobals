package erpsolglob.erpsolglobview.erpclass;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import oracle.adf.share.ADFContext;
import oracle.binding.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;

public class ERPSolGlobalViewBean {
    public ERPSolGlobalViewBean() {
        super();
    }
    public static String doGetUserCode(){
        return ERPSolGlobClassModel.doGetUserCode();
//        return ADFContext.getCurrent().getSessionScope().get("GLOB_USER_CODE").toString();
    }
    
    public static String doGetUserLocationCode(){
        return ERPSolGlobClassModel.doGetUserCode();
//        return ADFContext.getCurrent().getSessionScope().get("GLOB_USER_LOCATION").toString();
    }
    
    
    public static String doGetUserStoreCode(){
        return ERPSolGlobClassModel.doGetUserCode();
    }
  
    public static BindingContainer doGetERPBindings() {
           return BindingContext.getCurrent().getCurrentBindingsEntry();
       }   
    public static boolean doIsERPSolTransactionDirty() {
        //this will check do we have any unsaved changes on form
        BindingContext context = BindingContext.getCurrent();
        DCBindingContainer binding = (DCBindingContainer) context.getCurrentBindingsEntry();
        DCDataControl dc = binding.getDataControl();

        return dc.isTransactionDirty();
    }    
}
