package com.example.application.views.formulario;

import com.example.application.backend.Orden;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

import java.awt.*;

@PageTitle("Formulario")
@Route(value = "", layout = MainLayout.class)
public class Formulario extends VerticalLayout {

    public Formulario() {

        Dialog dialog = new Dialog();
        dialog.add(new Label("Datos no válidos. Completar todos los campos."));
        IntegerField numero = new IntegerField("Introduzca el numero");

        Button boton = new Button("Enviar");
        boton.addClickListener(buttonClickEvent -> {
            if(numero.getValue()==null){
                dialog.open();
            }else{
                Orden nuevaOrden = new Orden(numero.getValue());
                Orden.listaOrdenes.add(nuevaOrden);
                Notification.show("Añadido: " + numero.getValue());
                numero.clear();
                numero.setInvalid(false);
            }

        });

        add(numero, boton);
    }

}
