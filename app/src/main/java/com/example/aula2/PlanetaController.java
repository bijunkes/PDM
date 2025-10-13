package com.example.aula2;

import java.util.ArrayList;

public class PlanetaController {
    PlanetaDAO planetaDAO;
    public PlanetaController() {
        planetaDAO = new PlanetaDAO();
    }
    public ArrayList<Planeta> getPlaneta() {
        return planetaDAO.getPlanetas();
    }

    public ArrayList<String> getNomePlanetas() {
        ArrayList<String> nomes = new ArrayList<String>();
        for (Planeta p : planetaDAO.getPlanetas()){
            nomes.add(p.nome);
        }
        return nomes;
    }
}
