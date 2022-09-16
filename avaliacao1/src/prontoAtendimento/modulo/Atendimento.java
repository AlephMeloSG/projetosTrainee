package prontoAtendimento.modulo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Atendimento {
    private int id;
    private Date data;
    private int pacienteId;
    private int medicoId;

    private String pacienteNome;
    private String medicoNome;
    private ArrayList<String> servicos;
    private ArrayList<String> medicamentos;

    public Atendimento(String data, int pacienteId, int medicoId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.data = simpleDateFormat.parse(data);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
    }

    public Date getData() {
        return data;
    }
    public int getPacienteId() {
        return pacienteId;
    }
    public int getMedicoId() {
        return medicoId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }
    public void setMedicoNome(String medicoNome) {
        this.medicoNome = medicoNome;
    }
    public void addServicos(String servico) {
        this.servicos.add(servico);
    }
    public void addMedicamentos(String medicamentos) {
        this.medicamentos.add(medicamentos);
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "  data=" + data +
                ", pacienteId=" + pacienteId +
                ", pacienteNome='" + pacienteNome + '\'' +
                ", medicoNome='" + medicoNome + '\'' +
                ", servicos=" + servicos +
                ", medicamentos=" + medicamentos +
                '}';
    }
}
