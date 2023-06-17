package com.example.application.views.pasoaproduccion;

import com.example.application.backend.Orden;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Paso a Produccion")
@Route(value = "produccion", layout = MainLayout.class)
public class PasoAProduccion extends HorizontalLayout {

    public PasoAProduccion() {

      /*Grid<Orden> grid = new Grid<>();
       grid.addColumn(Orden::getNumero).setHeader("Número");

       grid.setItems(Orden.listaProduccion);

       add(grid);*/


        List<Orden> orden1 = new ArrayList<>();
        List<Orden> orden5 = new ArrayList<>();
        List<Orden> orden7 = new ArrayList<>();

        for (Orden orden : Orden.listaProduccion){
            if (orden.getNumero() == 1){
                orden1.add(orden);
            } else if (orden.getNumero() == 5) {
                orden5.add(orden);
            }else if (orden.getNumero() == 7) {
                orden7.add(orden);
            }
        }

        Grid<Orden> grid1 = new Grid<>();
        grid1.addColumn(Orden::getNumero).setHeader("Número");
        grid1.setItems(orden1);

        Grid<Orden> grid5 = new Grid<>();
        grid5.addColumn(Orden::getNumero).setHeader("Número");
        grid5.setItems(orden5);

        Grid<Orden> grid7 = new Grid<>();
        grid7.addColumn(Orden::getNumero).setHeader("Número");
        grid7.setItems(orden7);

        add(grid1, grid5, grid7);



    }


}