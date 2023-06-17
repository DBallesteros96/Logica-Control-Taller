package com.example.application.views.formulario;

import com.example.application.backend.Orden;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
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
        IntegerField numero = new IntegerField("Introduzca el numero");

        Button boton = new Button("Enviar");
        boton.addClickListener(buttonClickEvent -> {
            Orden nuevaOrden = new Orden(numero.getValue());
            Orden.listaOrdenes.add(nuevaOrden);
            Notification.show("Añadido: " + numero.getValue());
        });

        add(numero, boton);
    }

}
