package erpsolglob.erpsolglobmodel.erpsolglobclasses;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.server.ViewDefImpl;
import oracle.jbo.server.ViewObjectImpl;

public class ERPSolGlobalsViewObjectImpl extends ViewObjectImpl {
    public ERPSolGlobalsViewObjectImpl(String string, ViewDefImpl viewDefImpl) {
        super(string, viewDefImpl);
    }
String ERPSolCheckDirty="ERPSOLYES";
    
    public ERPSolGlobalsViewObjectImpl() {
        super();
    }


    public void setERPSolCheckDirty(String ERPSolCheckDirty) {
        this.ERPSolCheckDirty = ERPSolCheckDirty;
    }

    public String getERPSolCheckDirty() {
        return ERPSolCheckDirty;
    }

    @Override
    public Row next() {
        // TODO Implement this method
        if (getERPSolCheckDirty().equals("ERPSOLYES")) {
            if (getApplicationModule().getTransaction().isDirty()) {
                throw new JboException("Please Save/Undo Transaction First.");
            }
        }
        return super.next();
    }
    
    @Override
    public Row previous() {
        // TODO Implement this method
        if (getERPSolCheckDirty().equals("ERPSOLYES")) {
            if (getApplicationModule().getTransaction().isDirty()) {
                throw new JboException("Please Save/Undo Transaction First.");
            }
        }
        return super.previous();
    }
}