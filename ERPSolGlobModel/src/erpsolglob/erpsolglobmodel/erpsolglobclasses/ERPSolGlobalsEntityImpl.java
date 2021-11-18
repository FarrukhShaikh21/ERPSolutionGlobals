package erpsolglob.erpsolglobmodel.erpsolglobclasses;

import oracle.jbo.AttributeList;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;

public class ERPSolGlobalsEntityImpl extends EntityImpl {
    String ERPSolPKSeqName;
    String ERPSolPKColumnName;
    String ERPISGenertePK="YES";
    public ERPSolGlobalsEntityImpl() {
        super();
    }
    @Override
    protected void create(AttributeList attributeList) {
        // TODO Implement this method
        
        if (getERPISGenertePK().equals("YES")) {
            SequenceImpl seq = new SequenceImpl(ERPSolPKSeqName, getDBTransaction());
            setAttribute(getERPSolPKColumnName(), seq.getSequenceNumber().intValue());
        }
        super.create(attributeList);

    }
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

    public void setERPSolPKSeqName(String ERPSolPKSeqName) {
        this.ERPSolPKSeqName = ERPSolPKSeqName;
    }

    public String getERPSolPKSeqName() {
        return ERPSolPKSeqName;
    }

    public void setERPSolPKColumnName(String ERPSolPKColumnName) {
        this.ERPSolPKColumnName = ERPSolPKColumnName;
    }

    public String getERPSolPKColumnName() {
        return ERPSolPKColumnName;
    }

    public void setERPISGenertePK(String ERPISGenertePK) {
        this.ERPISGenertePK = ERPISGenertePK;
    }

    public String getERPISGenertePK() {
        return ERPISGenertePK;
    }
}
