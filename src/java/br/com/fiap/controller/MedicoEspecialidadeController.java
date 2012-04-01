/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

/**
 *
 * @author fsantiago
 */
import br.com.fiap.dao.MedicoEspecialidadeDao;
import br.com.fiap.dao.MedicoEspecialidadeDaoImp;
import br.com.fiap.model.Especialidade;
import br.com.fiap.model.Medico;
import br.com.fiap.model.MedicoEspecialidade;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "medicoEspecialidadeC")
@SessionScoped
public class MedicoEspecialidadeController {

    private MedicoEspecialidade mesp;
    private MedicoEspecialidade me;
    private Medico medico;
    private Especialidade especialidade;
    private MedicoController medicoC;
    private EspecialidadeController especialidadeC;
    private ListDataModel listaMedicoEspecialidades;
    private SortedMap<String, String> listMedicoEspecialidade = new TreeMap<String, String>();
    private SortedMap<String, String> listEspecialidadesMedico = new TreeMap<String, String>();

    public MedicoEspecialidadeController() {
    }

    public SortedMap<String, String> getMedicosEspecialidadesCmbBox() {
        List<MedicoEspecialidade> especialidades = new MedicoEspecialidadeDaoImp().list();
        for (MedicoEspecialidade listMedicoEspecialidades : especialidades) {
            listMedicoEspecialidade.put(listMedicoEspecialidades.getIdMedico().getNome(), String.valueOf(new Long(listMedicoEspecialidades.getIdMedico().getId())));
        }
        return listMedicoEspecialidade;
    }

    public SortedMap<String, String> getMedicosEspecialidadesCmbBox(Especialidade especialidade) {

        listMedicoEspecialidade.clear();

        List<MedicoEspecialidade> especialidades = new MedicoEspecialidadeDaoImp().findMedicos(especialidade.getId());
        for (MedicoEspecialidade listMedicoEspecialidades : especialidades) {
            listMedicoEspecialidade.put(listMedicoEspecialidades.getIdMedico().getNome(), String.valueOf(new Long(listMedicoEspecialidades.getIdMedico().getId())));
        }
        return listMedicoEspecialidade;

    }
    
    
    public SortedMap<String, String> getEspecialidadesMedicoCmbBox(Medico medico) {

        listMedicoEspecialidade.clear();

        List<MedicoEspecialidade> especialidades = new MedicoEspecialidadeDaoImp().findEspecialidades(medico.getId());
        for (MedicoEspecialidade listEspecialidadesMedicos : especialidades) {
            listEspecialidadesMedico.put(listEspecialidadesMedicos.getIdEspecialidade().getEspecialidade(), String.valueOf(new Long(listEspecialidadesMedicos.getIdEspecialidade().getId())));
        }
        return listEspecialidadesMedico;

    }

    public SortedMap<String, String> getMedicosCmbBox() {
        medicoC = new MedicoController();
        return medicoC.getMedicosCmbBox();
    }

    public SortedMap<String, String> getEspecialidadesCmbBox() {
        especialidadeC = new EspecialidadeController();
        return especialidadeC.getEspecialidadesCmbBox();
    }

    public EspecialidadeController getEspecialidadeC() {
        return especialidadeC;
    }

    public void setEspecialidadeC(EspecialidadeController especialidadeC) {
        this.especialidadeC = especialidadeC;
    }

    public MedicoController getMedicoC() {
        return medicoC;
    }

    public void setMedicoC(MedicoController medicoC) {
        this.medicoC = medicoC;
    }

    public DataModel getListarMedicoEspecialidades() {
        List<MedicoEspecialidade> lista = new MedicoEspecialidadeDaoImp().list();
        listaMedicoEspecialidades = new ListDataModel(lista);
        return listaMedicoEspecialidades;
    }

    public ListDataModel getListaMedicoEspecialidades() {
        return listaMedicoEspecialidades;
    }

    public void setListaMedicoEspecialidades(ListDataModel listaMedicoEspecialidades) {
        this.listaMedicoEspecialidades = listaMedicoEspecialidades;
    }

    public void prepararAdicionarMedicoEspecialidade(ActionEvent actionEvent) {
        mesp = new MedicoEspecialidade();
        medico = new Medico();
        especialidade = new Especialidade();
    }

    public void prepararAlterarMedicoEspecialidade(ActionEvent actionEvent) {
        mesp = (MedicoEspecialidade) (listaMedicoEspecialidades.getRowData());
        me = new MedicoEspecialidade(mesp.getIdEspecialidade(), mesp.getIdMedico());
        especialidade = new Especialidade();
        especialidade.setId(mesp.getIdEspecialidade().getId());
        medico = new Medico();
        medico.setId(mesp.getIdMedico().getId());

    }

    public String excluirMedicoEspecialidade() {
        MedicoEspecialidade medicoEspeciabilidadeTemp = (MedicoEspecialidade) (listaMedicoEspecialidades.getRowData());
        MedicoEspecialidadeDao dao = new MedicoEspecialidadeDaoImp();
        dao.remove(medicoEspeciabilidadeTemp);
        return "medicoEspeciabilidade";
    }

    public void adicionarMedicoEspecialidade(ActionEvent actionEvent) {
        MedicoEspecialidadeDao dao = new MedicoEspecialidadeDaoImp();
        mesp.setIdEspecialidade(especialidade);
        mesp.setIdMedico(medico);
        dao.save(mesp);
    }

    public void alterarMedicoEspecialidade(ActionEvent actionEvent) {

        MedicoEspecialidadeDao dao = new MedicoEspecialidadeDaoImp();
        mesp.setIdMedico(medico);
        mesp.setIdEspecialidade(especialidade);
        dao.remove(me);
        dao.save(mesp);
    }

    public MedicoEspecialidade getMesp() {
        return mesp;
    }

    public void setMesp(MedicoEspecialidade mesp) {
        this.mesp = mesp;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}