
package com.besa.PwAAgent.utils.personalization;

import com.besa.PwAAgent.db.model.PreferenciaXBaile;

public class CromosomaBaile extends Cromosoma{
    private PreferenciaXBaile baile;

    public CromosomaBaile(PreferenciaXBaile baile) {
        this.baile = baile;
    }

    public PreferenciaXBaile getBaile() {
        return baile;
    }
    
    @Override
    protected void calculateObjectiveValue() {
        objectiveValue = this.baile.getGusto();
    }
    
}
