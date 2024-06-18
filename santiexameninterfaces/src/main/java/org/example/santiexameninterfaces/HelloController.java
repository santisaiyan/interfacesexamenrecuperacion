package org.example.santiexameninterfaces;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;

public class HelloController {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private Spinner<Double> AD;
    @FXML
    private Spinner<Double> SGE;
    @FXML
    private Spinner<Double> DI;
    @FXML
    private Spinner<Double> PMDM;
    @FXML
    private Spinner<Double> PSP;
    @FXML
    private Spinner<Double> EIE;
    @FXML
    private Spinner<Double> HLC;
    @FXML
    private Spinner<Double> MEDIA;
    @FXML
    private TableView<Alumno> tablaAlumnos;
    @FXML
    private TableColumn<Alumno, String> columnanombre;
    @FXML
    private TableColumn<Alumno, String> columnaapellido;
    @FXML
    private TableColumn<Alumno, Double> columnaad;
    @FXML
    private TableColumn<Alumno, Double> columnasge;
    @FXML
    private TableColumn<Alumno, Double> columnadi;
    @FXML
    private TableColumn<Alumno, Double> columnapmdm;
    @FXML
    private TableColumn<Alumno, Double> columnapsp;
    @FXML
    private TableColumn<Alumno, Double> columnaeie;
    @FXML
    private TableColumn<Alumno, Double> columnahlc;
    @FXML
    private TableColumn<Alumno, Double> columnamedia;
    @FXML
    private Button botondescarga;
    @FXML
    private Button botonañadir;
    @FXML
    private Button botonsalir;

    private ObservableList<Alumno> alumnos;

    @FXML
    public void initialize() {
        alumnos = FXCollections.observableArrayList();





        alumnos.add(new Alumno(null, "Sergio", "Ayala", 5.0, 6.0, 7.0, 8.0, 9.0, 5.0, 6.0, calcularMedia(5.0, 6.0, 7.0, 8.0, 9.0, 5.0, 6.0)));
        alumnos.add(new Alumno(null, "Alba", "Perez", 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, calcularMedia(7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0)));
        alumnos.add(new Alumno(null, "Esteban", "Ruiz", 5.0, 6.0, 5.0, 6.0, 5.0, 6.0, 5.0, calcularMedia(5.0, 6.0, 5.0, 6.0, 5.0, 6.0, 5.0)));

        columnanombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        columnaapellido.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getApellido()));
        columnaad.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAD()).asObject());
        columnasge.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSGE()).asObject());
        columnadi.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getDI()).asObject());
        columnapmdm.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPMDM()).asObject());
        columnapsp.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPSP()).asObject());
        columnaeie.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getEIE()).asObject());
        columnahlc.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getHLC()).asObject());
        columnamedia.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getMEDIA()).asObject());

        tablaAlumnos.setItems(alumnos);
        AD.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 0.1));
        SGE.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 0.1));
        DI.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 0.1));
        PMDM.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 0.1));
        PSP.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 0.1));
        EIE.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 0.1));
        HLC.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 0.1));
        MEDIA.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 0, 0.1));
    }
    @FXML
    public void salir(ActionEvent actionEvent) {
        Stage stage = (Stage) botonsalir.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void añadir(ActionEvent actionEvent) {
        String nombreAlumno = nombre.getText();
        String apellidoAlumno = apellido.getText();
        Double ad = AD.getValue();
        Double sge = SGE.getValue();
        Double di = DI.getValue();
        Double pmdm = PMDM.getValue();
        Double psp = PSP.getValue();
        Double eie = EIE.getValue();
        Double hlc = HLC.getValue();
        Double media = calcularMedia(ad, sge, di, pmdm, psp, eie, hlc);

        Alumno nuevoAlumno = new Alumno(null, nombreAlumno, apellidoAlumno, ad, sge, di, pmdm, psp, eie, hlc, media);
        alumnos.add(nuevoAlumno);
    }
    private Double calcularMedia(Double ad, Double sge, Double di, Double pmdm, Double psp, Double eie, Double hlc) {
        return (ad + sge + di + pmdm + psp + eie + hlc) / 7;
    }

    @FXML
    public void descargarreporte(ActionEvent actionEvent) {
        try {
            (new Report()).descargarreporte();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
