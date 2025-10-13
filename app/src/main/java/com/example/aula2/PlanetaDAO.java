package com.example.aula2;

import java.util.ArrayList;

public class PlanetaDAO {
    ArrayList<Planeta> arrayListPlanetas;
    public PlanetaDAO() {
        arrayListPlanetas = new ArrayList<Planeta>();
        arrayListPlanetas.add(new Planeta("Mercúrio", R.drawable.mercury));
        arrayListPlanetas.add(new Planeta("Venus", R.drawable.venus));
        arrayListPlanetas.add(new Planeta("Terra", R.drawable.earth));
        arrayListPlanetas.add(new Planeta("Mars", R.drawable.mars));
        arrayListPlanetas.add(new Planeta("Júpter", R.drawable.jupter));
        arrayListPlanetas.add(new Planeta("Netuno", R.drawable.neptune));
        arrayListPlanetas.add(new Planeta("Urano", R.drawable.uranus));
        arrayListPlanetas.add(new Planeta("Sol", R.drawable.sun));
    }

    public ArrayList<Planeta> getPlanetas() {
        return arrayListPlanetas;
    }
}
