package erpsolglob.erpsolglobview.erpclass;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import oracle.adf.share.ADFContext;
import oracle.binding.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

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
           return (BindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
       }   
    public static boolean doIsERPSolTransactionDirty() {
        //this will check do we have any unsaved changes on form
        BindingContext context = BindingContext.getCurrent();
        DCBindingContainer binding = (DCBindingContainer) context.getCurrentBindingsEntry();
        DCDataControl dc = binding.getDataControl();

        return dc.isTransactionDirty();
    }
    
    public  static OperationBinding doIsERPSolGerOperationBinding(String pEERPOperationName ) {
        //this will check do we have any unsaved changes on form
        oracle.binding.BindingContainer erpbc = doGetERPBindings();
        return (OperationBinding)erpbc.getOperationBinding(pEERPOperationName);
    }
    
    
    public String doExecuteOperationBindingNew() {
        System.out.println("zero");
        doIsERPSolGerOperationBinding("Commit").execute();
        System.out.println("one");
        return null;
    }
    
    public String doExecuteOperationBinding() {
        System.out.println("zero");
        doIsERPSolGerOperationBinding("Commit1").execute();
        System.out.println("one");
        return null;
    }
    

    public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList = new ArrayList<SelectItem>();
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCDataControl ERPSoldc = bc.getDataControl();
        ApplicationModule ERPSolam = ERPSoldc.getApplicationModule();
        ViewObject vo = ERPSolam.findViewObject(pViewObjectName);
        vo.getViewObject().reset();
        vo.getViewObject().setWhereClause(pWhereColumn + " LIKE UPPER('%" + pSearch + "%') AND ROWNUM<="+pNoOfRecordsSuggest);
        vo.executeQuery();
        //System.out.println(vo.getEstimatedRowCount()+ " ERC");
        while (vo.getViewObject().hasNext()) {
            Row suggestedRow = vo.next();
            ResultList.add(new SelectItem(suggestedRow.getAttribute(pAttribute1), suggestedRow.getAttribute(pAttribute1)+(pAttribute2.equals("-") ? "" : " ("+suggestedRow.getAttribute(pAttribute2))+")"));
        }
        
        return ResultList;
        
    }
    
    
    public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest,String pERPSolDCName) {
        List<SelectItem> ResultList = new ArrayList<SelectItem>();
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCDataControl ERPSoldc = bc.findDataControl(pERPSolDCName);
        ApplicationModule ERPSolam = ERPSoldc.getApplicationModule();
        ViewObject vo = ERPSolam.findViewObject(pViewObjectName);
        vo.getViewObject().reset();
        vo.getViewObject().setWhereClause(pWhereColumn + " LIKE UPPER('%" + pSearch + "%') AND ROWNUM<="+pNoOfRecordsSuggest);
        vo.executeQuery();
        //System.out.println(vo.getEstimatedRowCount()+ " ERC");
        while (vo.getViewObject().hasNext()) {
            Row suggestedRow = vo.next();
            ResultList.add(new SelectItem(suggestedRow.getAttribute(pAttribute1), suggestedRow.getAttribute(pAttribute1)+(pAttribute2.equals("-") ? "" : " ("+suggestedRow.getAttribute(pAttribute2))+")"));
        }
        
        return ResultList;
        
    }    
}
