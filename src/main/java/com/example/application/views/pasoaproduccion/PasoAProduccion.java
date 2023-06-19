package com.example.application.views.pasoaproduccion;

import com.example.application.backend.Orden;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
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
public class PasoAProduccion extends VerticalLayout {

    public PasoAProduccion() {

      /*Grid<Orden> grid = new Grid<>();
       grid.addColumn(Orden::getNumero).setHeader("Número");

       grid.setItems(Orden.listaProduccion);

       add(grid);*/


        List<Orden> orden1 = new ArrayList<>();
        List<Orden> orden3 = new ArrayList<>();
        List<Orden> orden5 = new ArrayList<>();
        List<Orden> orden7 = new ArrayList<>();

        for (Orden orden : Orden.listaProduccion){
            if (orden.getNumero() == 1){
                orden1.add(orden);
            } else if (orden.getNumero() == 3) {
                orden3.add(orden);
            } else if (orden.getNumero() == 5) {
                orden5.add(orden);
            }
            else if (orden.getNumero() == 7) {
                orden7.add(orden);
            }
        }

        VerticalLayout layoutNavarro = new VerticalLayout();
        Label tituloNavarro = new Label("Navarro");

        Grid<Orden> grid1 = new Grid<>();
        grid1.addColumn(Orden::getNumero).setHeader("Número");
        //add column tiempo también
        //Columna añadida para poder marcar las ordenes terminadas y que se borren automáticamente al marcarlas
        //Se añadirán a una lista de ordenes terminadas y se mostrarán en otra pestaña todas en un grid
        //En ese grid solo se mostrara el códigoOT, el montador y las fechas
        grid1.addComponentColumn(orden -> {
            Checkbox checkbox = new Checkbox();
            checkbox.setValue(orden.isOrdenTerminada());
            checkbox.addValueChangeListener(event -> {
                boolean value = event.getValue();
                orden.setOrdenTerminada(value);
                if(orden.isOrdenTerminada()){
                    Orden.listaOrdenesCompletadas.add(orden);
                    orden1.remove(orden);
                    grid1.setItems(orden1);
                }
            });
            return checkbox;
        }).setHeader("Orden Finalizada");
        grid1.setItems(orden1);

        layoutNavarro.add(tituloNavarro, grid1);

        VerticalLayout layoutPaco = new VerticalLayout();
        Label tituloPaco = new Label("Paco");

        Grid<Orden> grid3 = new Grid<>();
        grid3.addColumn(Orden::getNumero).setHeader("Número");
        grid3.setItems(orden1);

        layoutPaco.add(tituloPaco, grid3);


        VerticalLayout layoutHector = new VerticalLayout();
        Label tituloHector= new Label("Hector");

        Grid<Orden> grid5 = new Grid<>();
        grid5.addColumn(Orden::getNumero).setHeader("Número");
        grid5.setItems(orden5);

        layoutHector.add(tituloHector, grid5);


        VerticalLayout layoutGerman = new VerticalLayout();
        Label tituloGerman= new Label("German");

        Grid<Orden> grid7 = new Grid<>();
        grid7.addColumn(Orden::getNumero).setHeader("Número");
        grid7.setItems(orden7);

        layoutGerman.add(tituloGerman, grid7);


        //Poner debajo de cada grid
        grid1.setWidth("300px");
        grid3.setWidth("300px");
        grid5.setWidth("300px");
        grid7.setWidth("300px");


        HorizontalLayout fila1 = new HorizontalLayout(layoutNavarro, layoutPaco);
        HorizontalLayout fila2 = new HorizontalLayout(layoutHector, layoutGerman);



        add(fila1, fila2);





    }


}