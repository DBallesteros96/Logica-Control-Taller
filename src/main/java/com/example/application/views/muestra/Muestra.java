package com.example.application.views.muestra;

import com.example.application.backend.Orden;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSelectionColumn;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.util.Iterator;

@PageTitle("Muestra")
@Route(value = "muestra", layout = MainLayout.class)
public class Muestra extends VerticalLayout {

    public Muestra() {
        // Crea el Grid
        Grid<Orden> grid = new Grid<>(Orden.class);
        grid.removeColumnByKey("numero");
        grid.removeColumnByKey("tubos");

        // Añade la columna para el campo 'numero'
        grid.addColumn(Orden::getNumero).setHeader("Número");

        // Añade la columna para el campo 'tubos' representado como Checkbox
        grid.addComponentColumn(orden -> {
            Checkbox checkbox = new Checkbox();
            checkbox.setValue(orden.isTubos());
            checkbox.addValueChangeListener(event -> {
                boolean value = event.getValue();
                orden.setTubos(value);
            });
            return checkbox;
        }).setHeader("Tubos");

        // Agrega los elementos al Grid
        grid.setItems(Orden.listaOrdenes);

        Button botonProduccion = new Button("Enviar a produccion");
        botonProduccion.addClickListener(buttonClickEvent -> {
            Iterator<Orden> iterator = Orden.listaOrdenes.iterator();
            while (iterator.hasNext()) {
                Orden orden = iterator.next();
                if (orden.isTubos()) {
                    Orden.listaProduccion.add(orden);
                    iterator.remove();
                }
            }
            grid.setItems(Orden.listaOrdenes);
        });

        add(grid, botonProduccion);
    }



}


