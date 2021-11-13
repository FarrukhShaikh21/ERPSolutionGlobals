package erpsolglob.erpsolglobmodel.erpsolglobclasses;

import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;

public class ERPSolGlobalsEntityImpl extends EntityImpl {
    public ERPSolGlobalsEntityImpl() {
        super();
    }
    @Override
    protected void doDML(int i, TransactionEvent transactionEvent) {
        // TODO Implement this method
        if (i == DML_INSERT) {
                   // System.out.println("dml_insert_new_02");
                    populateAttributeAsChanged(getAttributeIndexOf("CreatedBy"),ERPSolGlobClassModel.doGetUserCode());
//                    populateAttributeAsChanged(getAttributeIndexOf("CreatedDate"),ERPGlobalPLSQLClass.doGetOracleSQLTSDate());
                    
                }        
        super.doDML(i, transactionEvent);
    }
}
