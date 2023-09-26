package com.besa.PwAAgent.agent.tasks.RutinaEjercicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.besa.PwAAgent.agent.goals.action.RutinaEjercicioContext;
import com.besa.PwAAgent.db.model.Ejercicio;
import com.besa.PwAAgent.db.model.FraseInspiracional;
import com.besa.PwAAgent.db.model.Historial;
import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionAxis;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

/**
 *
 * @author juan.amorocho
 */
public class RealizarEjercicios extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private long start = -1, startCardio = -1;
    private int currRepeticiones = 0;
    private int series = -1;
    private int currSeries = -1;
    List<Ejercicio> misEjercicios = new ArrayList<>();
    List<FraseInspiracional> currFrases = new ArrayList<>();
    Ejercicio currEjercicio = null;
    boolean firstTime = true;
    boolean dijoFrase = false;
    boolean isCardio = false;
    int noRepeticiones = 0;
    int randomIndex = 0;
    int duracionCardio = 100;
    boolean puedoProseguir = false;

    // --- variables locales para espera -- //
    private boolean estoyEsperando = false;
    private int millisecsParaEspera = 0;

    public RealizarEjercicios() {
    }

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        long now = System.currentTimeMillis();
        String userId = blvs.getActiveUsers().get(0);
        RutinaEjercicioContext context = (RutinaEjercicioContext) blvs.getServiceContext(RutinaEjercicioContext.class);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(userId);
        PwAExerciseProfile currPerfilEjercicio = miPerfil.getExerciseProfile();

        if (currSeries == -1) {
            System.out.println("EXERCISE - DEBUG: ...........................Entre a setup......................");
            // Revisar bien esta variable... (se reempleza?)
            if (firstTime) {
                misEjercicios = currPerfilEjercicio.getEjercicioList();
                firstTime = false;
            }
            context.setCurrEjercicios(misEjercicios);
            currRepeticiones = 0;
            isCardio = false;
            currEjercicio = misEjercicios.get(0);

            for (int i = 0; i < currEjercicio.getCategoriaEntrenamientoList().size(); i++) {
                if (currEjercicio.getCategoriaEntrenamientoList().get(i).getTipo()
                        .contains(currPerfilEjercicio.getNombrePrograma().getNombre())) {
                    if (!currEjercicio.getCategoriaEntrenamientoList().get(i).getIntensidadList().isEmpty()) {
                        noRepeticiones = currEjercicio.getCategoriaEntrenamientoList().get(i).getIntensidadList()
                                .get(currPerfilEjercicio.getIndexIntensidadActual()).getRepeticiones();
                        series = currEjercicio.getCategoriaEntrenamientoList().get(i).getIntensidadList()
                                .get(currPerfilEjercicio.getIndexIntensidadActual()).getSeries();
                        currSeries = 0;
                        if (currEjercicio.getCategoriaEntrenamientoList().get(i).getIntensidadList()
                                .get(currPerfilEjercicio.getIndexIntensidadActual()).getDuracionEjercicio() != null) {
                            duracionCardio = currEjercicio.getCategoriaEntrenamientoList().get(i).getIntensidadList()
                                    .get(currPerfilEjercicio.getIndexIntensidadActual()).getDuracionEjercicio() * 1000;
                        }
                        if (currEjercicio.getCategoriaEntrenamientoList().get(i).getIntensidadList()
                                .get(currPerfilEjercicio.getIndexIntensidadActual()).getPeso() != null
                                && currEjercicio.getNecesitaPeso()) {
                            infoServicio = new HashMap<>();
                            infoServicio.put("content", "Para este ejercicio, trabajaremos con un peso de "
                                    + currEjercicio.getCategoriaEntrenamientoList().get(i).getIntensidadList()
                                            .get(currPerfilEjercicio.getIndexIntensidadActual()).getPeso()
                                    + "libras. Si no las tienes contigo, tu cuidador te las acercará!");
                            sendActionRequest(infoServicio, "talk");
                            estoyEsperando = true;
                            millisecsParaEspera += 10000;

                        }
                        if (currEjercicio.getCategoriaEntrenamientoList().get(i).getTipo().contains("Cardiovascular")) {
                            isCardio = true;
                        }
                    }
                }
            }
            try {
                AddEmotionalFrases(blvs);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            randomIndex = ThreadLocalRandom.current().nextInt(0, currFrases.size());
            puedoProseguir = true;

        }
        if (estoyEsperando) {
            System.out.println("EXERCISE - DEBUG: ...........................Estoy esperando.....................");
            if (start == -1) {
                start = now;
            }
            if ((now - start > millisecsParaEspera) && !context.isEstaMoviendo()) {
                estoyEsperando = false;
                millisecsParaEspera = 0;
                infoServicio = new HashMap<>();
                infoServicio.put("content", "Listo, continuemos!");
                sendActionRequest(infoServicio, "talk");
                start = -1;
            }

        }
        if (!estoyEsperando) {
            double duracion = currEjercicio.getDuracion() * 1000;
            double roundedTime = (now - start) / 1000;
            if (((Math.round(roundedTime) == currFrases.get(randomIndex).getTiempoEjecucion())
                    || (currFrases.get(randomIndex).getTiempoEjecucion() == 0))
                    && !dijoFrase) {
                System.out.println(
                        "EXERCISE - DEBUG: ...........................Entre a decir mi frase......................");
                infoServicio = new HashMap<>();
                infoServicio.put("content", currFrases.get(randomIndex).getContenidos());
                sendActionRequest(infoServicio, "talk");
                randomIndex = ThreadLocalRandom.current().nextInt(0, currFrases.size());
                dijoFrase = true;

            }
            if ((now - start > duracion || start == -1) && !context.isEstaMoviendo()) {
                if (currRepeticiones == noRepeticiones) {
                    currRepeticiones = 0;
                    currSeries++;
                    estoyEsperando = true;
                    infoServicio = new HashMap<>();
                    if (currSeries == series) {

                        misEjercicios.remove(0);
                        System.out.println("Saqué ejercicio");
                        millisecsParaEspera += 60000;
                        if (misEjercicios.size() == 1) {
                            infoServicio.put("content",
                                    "Ya casí! Nos falta un ejercicio. Descansemos un minuto y le damos con toda!");
                        } else if (misEjercicios.isEmpty()) {
                            infoServicio.put("content", "Hemos terminado nuestra rutina para hoy! Que buen trabajo!");
                        } else {
                            infoServicio.put("content",
                                    "Estoy orgulloso de ti! Descansemos un minuto, y seguimos al siguiente ejercicio.");
                        }
                        GuardarHistorial(noRepeticiones, series, currEjercicio,
                                currPerfilEjercicio, blvs);
                        currSeries = -1;

                    } else {
                        infoServicio.put("content",
                                "Guau! Descansemos 30 segundos y seguimos a la siguiente serie. Lo estas haciendo super!");
                        millisecsParaEspera += 30000;
                    }
                    sendActionRequest(infoServicio, "talk");
                    dijoFrase = false;

                } else {

                    start = now;
                    // -- Run Animation -- //
                    infoServicio = new HashMap<>();
                    infoServicio.put("EXERCISE", currEjercicio.getNombre());
                    sendActionRequest(infoServicio, "runAnimationAction");
                    if (isCardio) {
                        if (startCardio == -1) {
                            startCardio = now;
                        }
                        if ((now - startCardio > duracionCardio)) {
                            startCardio = now;
                            currRepeticiones++;
                        }

                    } else {
                        currRepeticiones++;
                    }
                    if (currEjercicio.getUrlVideo() != null) {
                        infoServicio = new HashMap<>();
                        System.out.println(currEjercicio.getUrlVideo());
                        infoServicio.put("image", currEjercicio.getUrlVideo());
                        sendActionRequest(infoServicio, "showImage");
                    }
                    if (!(currRepeticiones == noRepeticiones)) {
                        dijoFrase = false;
                    }

                }
            }
        }

        // -- DEBUG -- Ejecuta movimientos sin necesidad de la BD. //
        // System.out.println("Tiempo actual - start: " + (now - start));
        /*
         * List<String> frases = new ArrayList<>();
         * frases.add("Hoo, tu no puedes!");
         * frases.add("Mueve esas mancuernas!");
         * frases.add("Yahoo Wahoo!");
         * frases.add("Me estoy cansando!!");
         * if ((now - start > 10000 || start == -1) &&
         * !blvs.getbEstadoActividad().isEstaMoviendo())
         * {
         * start = now;
         * infoServicio = new HashMap<>();
         * infoServicio.put("TAGSDANCE", "MANCUERNA");
         * ServiceDataRequest srb =
         * ServiceRequestBuilder.buildRequest(ActivityServiceRequestType.RUNANIMATION,
         * infoServicio);
         * ResPwaUtils.requestService(srb, blvs);
         * infoServicio = new HashMap<>();
         * infoServicio.put("content", frases.get(currRepeticiones % 4));
         * currRepeticiones++;
         * srb = ServiceRequestBuilder.buildRequest(VoiceServiceRequestType.SAY,
         * infoServicio);
         * ResPwaUtils.requestService(srb, (BeliefAgent) parameters);
         * infoServicio = new HashMap<>();
         * 
         * infoServicio = new HashMap<>();
         * infoServicio.put("SHOWIMG",
         * "http://10.195.40.154:49152/content/media/object_id/8/res_id/0");
         * srb = ServiceRequestBuilder.buildRequest(TabletServiceRequestType.SHOWIMG,
         * infoServicio);
         * ResPwaUtils.requestService(srb, blvs);
         * 
         * }
         */
    }

    @Override
    public void interruptTask(Believes believes) {
        System.out.println(" (RealizarEjercicio) - Interrupción de Meta.");
        infoServicio = new HashMap<>();
        infoServicio.put("EXERCISE", currEjercicio.getNombre());
        sendActionRequest(infoServicio, "showImage");

    }

    @Override
    public void cancelTask(Believes believes) {
        System.out.println(" (RealizarEjercicio) - Cancelación de Meta.");
        infoServicio = new HashMap<>();
        infoServicio.put("EXERCISE", currEjercicio.getNombre());
        sendActionRequest(infoServicio, "showImage");
    }

    @Override
    public boolean checkFinish(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        RutinaEjercicioContext context = (RutinaEjercicioContext) blvs.getServiceContext(RutinaEjercicioContext.class);
        if (misEjercicios.isEmpty() && (!context.isEstaMoviendo()) && puedoProseguir) {
            // TODO: ResPwaUtils.activateTopic(PepperTopicsNames.RETROEJERTOPIC, believes);
            return true;
        } else {
            setTaskWaitingForExecution();
            return false;
        }

    }

    private void GuardarHistorial(int repeticiones, int series, Ejercicio currEjercicio, PwAExerciseProfile miPerfil,
            BeliefAgent blvs) {
        Historial nHistorial = new Historial(currEjercicio.getNombre(), repeticiones * series);
        nHistorial.setPwaCedula(miPerfil);
        nHistorial.setNotas("-- Cambiar este campo para agregar notas personalizadas. --");
        RutinaEjercicioContext context = (RutinaEjercicioContext) blvs.getServiceContext(RutinaEjercicioContext.class);
        context.getCurrHistorialList().add(nHistorial);
    }

    private void AddEmotionalFrases(BeliefAgent blvs) throws CloneNotSupportedException {
        EmotionAxis axis = blvs.getPsychologicalState().getAgentEmotionalState().getMostActivatedEmotion();
        String emotionalTalk = axis.getCurrentValue() > 0 ? axis.getPositiveName() : axis.getNegativeName();
        String resulset[] = emotionalTalk.split(" ");
        currFrases.clear();
        if (resulset != null) {
            for (int i = 0; i < currEjercicio.getFraseInspiracionalList().size(); i++) {
                if (currEjercicio.getFraseInspiracionalList().get(i).getPwaEmocion().equals(resulset[0])) {
                    currFrases.add(currEjercicio.getFraseInspiracionalList().get(i));
                }
            }
        } else {
            currFrases = currEjercicio.getFraseInspiracionalList();
        }
        if (currFrases.isEmpty()) {
            currFrases = currEjercicio.getFraseInspiracionalList();
        }
    }
}
