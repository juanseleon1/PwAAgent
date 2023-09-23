
package com.besa.PwAAgent.utils.personalization;

import com.besa.PwAAgent.db.model.PreferenciaXCuento;

/**
 *
 * @author ASUS
 */
public class CromosomaCuento extends Cromosoma{

    private PreferenciaXCuento cuento;

    public CromosomaCuento(PreferenciaXCuento cuento) {
        this.cuento = cuento;
    }
    
    @Override
    protected void calculateObjectiveValue() {
        objectiveValue =  this.cuento.getGusto();
    }

    public PreferenciaXCuento getCuento() {
        return cuento;
    }
    
}
