package com.besa.PwAAgent.agent.goals.action;

import java.util.Map;

import com.besa.PwAAgent.agent.utils.UserEvaluableContext;
import com.besa.PwAAgent.db.model.PreferenciaXCuento;

import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class CuenteriaContext extends UserEvaluableContext {
    private int indexCuento;
    private PreferenciaXCuento cuentoActual;
    private String retroalimentacionValue;

    public CuenteriaContext() {
        super();
        indexCuento = 0;
        retroalimentacionValue = null;
        cuentoActual = null;
    }

    @Override
    public boolean update(InfoData data) {
        boolean update = false;
        RobotData robotData = (RobotData) data;
        Map<String, ?> response = robotData.getParameters();
        if (response.containsKey("retroValue")) {
            retroalimentacionValue = (String) response.get("retroValue");
            update = true;
        }
        return update;
    }

    public PreferenciaXCuento getCuentoActual() {
        return cuentoActual;
    }

    public int getIndexCuento() {
        return indexCuento;
    }

    public void setIndexCuento(int i) {
        indexCuento = i;
    }

    public String getRetroalimentacionValue() {
        return retroalimentacionValue;
    }

    public void feedbackActivity(Double respuestaRetroalimentacion) {
    }

    public void setCuentoActual(PreferenciaXCuento cuentoSelected) {
        cuentoActual = cuentoSelected;
    }

    @Override
    public CuenteriaContext clone() {
        CuenteriaContext cloned = new CuenteriaContext();
        cloned.indexCuento = indexCuento;
        cloned.cuentoActual = cuentoActual == null ? cuentoActual
                : new PreferenciaXCuento(cuentoActual.getPreferenciaXCuentoPK());
        return cloned;
    }

    @Override
    public void updateTasteForRelatedObjs(double factor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTasteForRelatedObjs'");
    }

}
