package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ModelBlocDeNotas;
import views.ViewBlocDeNotas;

/**
 *
 * @author Norberto
 */
public class ControllerBlocDeNotas implements ActionListener {

    ModelBlocDeNotas modelBlocDeNotas;
    ViewBlocDeNotas viewBlocDeNotas;

    public ControllerBlocDeNotas(ModelBlocDeNotas modelBlocDeNotas, ViewBlocDeNotas viewBlocDeNotas) {
        this.modelBlocDeNotas = modelBlocDeNotas;
        this.viewBlocDeNotas = viewBlocDeNotas;
        this.viewBlocDeNotas.jMenuItemRead.addActionListener(this);
        this.viewBlocDeNotas.jMenuItemReadSave.addActionListener(this);
        inComp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewBlocDeNotas.jMenuItemRead) {
            jmiRead();
        } else if (e.getSource() == viewBlocDeNotas.jMenuItemReadSave) {
            jmiSave();
        }
    }

    public void jmiRead() {
        try {
            modelBlocDeNotas.setPath("C:\\Users\\Norberto\\Desktop\\Norberto\\UTEC\\4._ Cuarto Cuatrimestre\\Desarrollo de Aplicaciones II\\MVC Practicas\\BlocDeNotasV1\\src\\file\\newfile.npr");
            modelBlocDeNotas.fileRead(modelBlocDeNotas.getPath());
            viewBlocDeNotas.jtaFile.setText(modelBlocDeNotas.getText());
        } catch (Exception ex) {
            Logger.getLogger(ControllerBlocDeNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jmiSave() {
        try {
            modelBlocDeNotas.setPath("C:\\Users\\Norberto\\Desktop\\Norberto\\UTEC\\4._ Cuarto Cuatrimestre\\Desarrollo de Aplicaciones II\\MVC Practicas\\BlocDeNotasV1\\src\\file\\newfile.npr");
            modelBlocDeNotas.setText(viewBlocDeNotas.jtaFile.getText());
            modelBlocDeNotas.writeFile(modelBlocDeNotas.getPath(), modelBlocDeNotas.getText());
        } catch (Exception ex) {
            Logger.getLogger(ControllerBlocDeNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inComp() {
        viewBlocDeNotas.setTitle("Leer y guardar archivo");
        viewBlocDeNotas.setLocationRelativeTo(null);
        viewBlocDeNotas.setResizable(false);
        viewBlocDeNotas.setVisible(true);
    }

}
