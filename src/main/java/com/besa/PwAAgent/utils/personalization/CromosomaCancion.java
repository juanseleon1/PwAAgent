
package com.besa.PwAAgent.utils.personalization;

import com.besa.PwAAgent.db.model.PreferenciaXCancion;

/**
 *
 * @author ASUS
 */
public class CromosomaCancion extends Cromosoma{
    
    private PreferenciaXCancion cancion;

    public CromosomaCancion(PreferenciaXCancion cancion ) {
      this.cancion = cancion;
    }
    
    @Override
    protected void calculateObjectiveValue() {
        objectiveValue = (float) this.cancion.getGusto();
        
        if ( cancion.getReminiscencia()==1f){
            objectiveValue += 0.4;
        }
    }

    public PreferenciaXCancion getCancion() {
        return cancion;
    }
    
     
    
}
