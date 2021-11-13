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
            try {
                populateAttributeAsChanged(getAttributeIndexOf("CreatedBy"), ERPSolGlobClassModel.doGetUserCode());
            } catch (Exception e) {
                // TODO: Add catch code
                try {
                    populateAttributeAsChanged(getAttributeIndexOf("Createdby"), ERPSolGlobClassModel.doGetUserCode());
                } catch (Exception ex) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
            }
            //                    populateAttributeAsChanged(getAttributeIndexOf("CreatedDate"),ERPSolGlobClassModel.doGetUserCode());
            try {
                populateAttributeAsChanged(getAttributeIndexOf("CreatedDate"),
                                           ERPSolGlobClassModel.doGetOracleJBOCurrentDate());
            } catch (Exception e) {
                // TODO: Add catch code
                try {
                    populateAttributeAsChanged(getAttributeIndexOf("Createddate"),
                                               ERPSolGlobClassModel.doGetOracleJBOCurrentDate());
                } catch (Exception ex) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
            }

        }

        else if (i == DML_UPDATE) {
            // System.out.println("dml_insert_new_02");
            try {
                populateAttributeAsChanged(getAttributeIndexOf("Modifiedby"), ERPSolGlobClassModel.doGetUserCode());
            } catch (Exception e) {
                // TODO: Add catch code
                try {
                    populateAttributeAsChanged(getAttributeIndexOf("ModifiedBy"), ERPSolGlobClassModel.doGetUserCode());
                } catch (Exception ex) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
            }
            //                    populateAttributeAsChanged(getAttributeIndexOf("CreatedDate"),ERPSolGlobClassModel.doGetUserCode());
            try {
                populateAttributeAsChanged(getAttributeIndexOf("ModifiedDate"),
                                           ERPSolGlobClassModel.doGetOracleJBOCurrentDate());
            } catch (Exception e) {
                // TODO: Add catch code
                try {
                    populateAttributeAsChanged(getAttributeIndexOf("Modifieddate"),
                                               ERPSolGlobClassModel.doGetOracleJBOCurrentDate());
                } catch (Exception ex) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
            }

        }
        super.doDML(i, transactionEvent);
    }
}