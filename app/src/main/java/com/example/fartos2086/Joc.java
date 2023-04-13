package com.example.fartos2086;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joc extends AppCompatActivity{
    static TextView nomJugador;
    static int cantidadJugadores = 0;
    static int numJugadorActual = 0;
    static Jugador jugadorActual;
    Jugador jugadorSeleccionado;
    static int[] fotosJugadores = {R.drawable.bounty_hunter, R.drawable.tusk, R.drawable.earthshaker, R.drawable.antimage, R.drawable.dragon_knight, R.drawable.invoker};
    static int[] fotosInicio = {R.drawable.player1, R.drawable.player2, R.drawable.player3, R.drawable.player4, R.drawable.player5, R.drawable.player6};
    static List<Jugador> jugadores = new ArrayList<>();
    static List<Carta> baralla;
    static ImageView fotoJugador;
    static RecyclerView recyclerView;
    static RecyclerView recyclerViewFotos;
    static GameState estado = new GameState();
    static ImageView[] casillas1;
    static ImageView[] casillas2;
    static String efecto;
    static boolean casillaEspecial = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc_layout);
        Intent intent = this.getIntent();
        Bundle args = intent.getBundleExtra("NOMS_JUGADORS");
        ArrayList<String> nombresJugadores = (ArrayList<String>) args.getSerializable("ARRAYLIST");
        baralla = Carta.generarBaralla();

        ImageView ultimaCasilla = findViewById(R.id.casillaFinal);

        ImageView casillaInicio1 = findViewById(R.id.casillaInicio1);
        ImageView casillaInicio2 = findViewById(R.id.casillaInicio2);
        ImageView casillaInicio3 = findViewById(R.id.casillaInicio3);
        ImageView casillaInicio4 = findViewById(R.id.casillaInicio4);
        ImageView casillaInicio5 = findViewById(R.id.casillaInicio5);
        ImageView casillaInicio6 = findViewById(R.id.casillaInicio6);
        ImageView[] casillasInicio = {casillaInicio1, casillaInicio2, casillaInicio3, casillaInicio4, casillaInicio5, casillaInicio6};

        ImageView casilla1 = findViewById(R.id.casilla1_1);
        ImageView casilla2 = findViewById(R.id.casilla2_1);
        ImageView casilla3 = findViewById(R.id.casilla3_1);
        ImageView casilla4 = findViewById(R.id.casilla4_1);
        ImageView casilla5 = findViewById(R.id.casilla5_1);
        ImageView casilla6 = findViewById(R.id.casilla6_1);
        ImageView casilla7 = findViewById(R.id.casilla7_1);
        ImageView casilla8 = findViewById(R.id.casilla8_1);
        ImageView casilla9 = findViewById(R.id.casilla9_1);
        ImageView casilla10 = findViewById(R.id.casilla10_1);
        ImageView casilla11 = findViewById(R.id.casilla11_1);
        ImageView casilla12 = findViewById(R.id.casilla12_1);
        ImageView casilla13 = findViewById(R.id.casilla13_1);
        ImageView casilla14 = findViewById(R.id.casilla14_1);
        casillas1 = new ImageView[]{casilla1, casilla2, casilla3, casilla4, casilla5, casilla6, casilla7, casilla8, casilla9, casilla10, casilla11, casilla12, casilla13, casilla14, ultimaCasilla};


        ImageView casilla1_2 = findViewById(R.id.casilla1_2);
        ImageView casilla2_2 = findViewById(R.id.casilla2_2);
        ImageView casilla3_2 = findViewById(R.id.casilla3_2);
        ImageView casilla4_2 = findViewById(R.id.casilla4_2);
        ImageView casilla5_2 = findViewById(R.id.casilla5_2);
        ImageView casilla6_2 = findViewById(R.id.casilla6_2);
        ImageView casilla7_2 = findViewById(R.id.casilla7_2);
        ImageView casilla8_2 = findViewById(R.id.casilla8_2);
        ImageView casilla9_2 = findViewById(R.id.casilla9_2);
        ImageView casilla10_2 = findViewById(R.id.casilla10_2);
        ImageView casilla11_2 = findViewById(R.id.casilla11_2);
        ImageView casilla12_2 = findViewById(R.id.casilla12_2);
        ImageView casilla13_2 = findViewById(R.id.casilla13_2);
        ImageView casilla14_2 = findViewById(R.id.casilla14_2);
        casillas2 = new ImageView[]{casilla1_2, casilla2_2, casilla3_2, casilla4_2, casilla5_2, casilla6_2, casilla7_2, casilla8_2, casilla9_2, casilla10_2, casilla11_2, casilla12_2, casilla13_2, casilla14_2, ultimaCasilla};

        int i = 0;
        System.out.println(nombresJugadores);
        for (String nomJugador : nombresJugadores){
            if (!nomJugador.equals("")) {
                cantidadJugadores++;
                List<Carta> ma = baralla.subList(0, 6);
                Jugador jugador = new Jugador(nomJugador);
                jugador.setMa(ma);
                jugador.setFoto(fotosJugadores[i]);
                jugador.setCasillaInicial(casillasInicio[i]);
                jugador.setFotoInicial(fotosInicio[i]);
                casillasInicio[i].setImageResource(fotosInicio[i]);
                jugador.setImagenCasilla(casillasInicio[i]);
                jugadores.add(jugador);
                baralla.removeAll(ma);
                i++;
            }
        }

        jugadorActual = jugadores.get(numJugadorActual);
        nomJugador = findViewById(R.id.nomJugador);
        fotoJugador = findViewById(R.id.fotoJugador);
        nomJugador.setText(jugadorActual.getNom());
        fotoJugador.setImageResource(jugadorActual.getFoto());

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);

        recyclerView = findViewById(R.id.cartesRecycle);
        AdapterCartes adapterCartes = new AdapterCartes(jugadorActual.getMa());
        adapterCartes.setOnItemClickListener(gameState -> {
            estado = gameState;
            efecto = estado.getCardName();
            recyclerViewFotos.setVisibility(View.VISIBLE);
            switch (efecto){
                case "MOV_1":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para mover 1 casilla", Toast.LENGTH_SHORT).show();
                    break;
                case "MOV_2":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para mover 2 casillas", Toast.LENGTH_SHORT).show();
                    break;
                case "MOV_3":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para mover 3 casillas", Toast.LENGTH_SHORT).show();
                    break;
                case "TELEPORT":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para intercambiar posiciones", Toast.LENGTH_SHORT).show();
                    break;
                case "ZANCADILLA":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para aplicarle ZANCADILLA", Toast.LENGTH_SHORT).show();
                    break;
                case "PATADA":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para darle una PATADA", Toast.LENGTH_SHORT).show();
                    break;
                case "BROMA":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para hacer una BROMA", Toast.LENGTH_SHORT).show();
                    break;
                case "HUNDIMIENTO":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para aplicarle HUNDIMIENTO", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        recyclerView.setAdapter(adapterCartes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewFotos = findViewById(R.id.fotosRecycle);
        AdapterFotos adapterFotos = new AdapterFotos(jugadores);
        adapterFotos.setOnItemClickListener(jugador -> {
            jugadorSeleccionado = jugador;
            switch (efecto){
                case "MOV_1":
                    moverJugador(1);
                    break;
                case "MOV_2":
                    moverJugador(2);
                    break;
                case "MOV_3":
                    moverJugador(3);
                    break;
                case "TELEPORT":
                    int posJugadorActual = jugadorActual.getCasilla();
                    int posJugadorSeleccionado = jugadorSeleccionado.getCasilla();

                    jugadorActual.setCasilla(posJugadorSeleccionado);
                    jugadorActual.getImagenCasilla().setImageResource(0);

                    if (jugadorActual.getCasilla() <= -1){
                        jugadorActual.setImagenCasilla(jugadorActual.getCasillaInicial());
                        jugadorActual.getImagenCasilla().setImageResource(jugadorActual.getFoto());
                    }
                    else {
                        if (casillas1[jugadorActual.getCasilla()].getDrawable() == null){
                            casillas1[jugadorActual.getCasilla()].setImageResource(jugadorActual.getFoto());
                            jugadorActual.setImagenCasilla(casillas1[jugadorActual.getCasilla()]);
                        }
                        else {
                            casillas2[jugadorActual.getCasilla()].setImageResource(jugadorActual.getFoto());
                            jugadorActual.setImagenCasilla(casillas2[jugadorActual.getCasilla()]);
                        }
                    }

                    jugadorSeleccionado.setCasilla(posJugadorActual);
                    jugadorSeleccionado.getImagenCasilla().setImageResource(0);

                    if (jugadorSeleccionado.getCasilla() <= -1){
                        jugadorSeleccionado.setImagenCasilla(jugadorSeleccionado.getCasillaInicial());
                        jugadorSeleccionado.getCasillaInicial().setImageResource(jugadorSeleccionado.getFotoInicial());
                    }
                    else {
                        if (casillas1[jugadorSeleccionado.getCasilla()].getDrawable() == null){
                            casillas1[jugadorSeleccionado.getCasilla()].setImageResource(jugadorSeleccionado.getFoto());
                            jugadorSeleccionado.setImagenCasilla(casillas1[jugadorSeleccionado.getCasilla()]);
                        }
                        else {
                            casillas2[jugadorSeleccionado.getCasilla()].setImageResource(jugadorSeleccionado.getFoto());
                            jugadorSeleccionado.setImagenCasilla(casillas2[jugadorSeleccionado.getCasilla()]);
                        }
                    }
                    break;
                case "ZANCADILLA":
                    Random random = new Random();
                    if (jugadorSeleccionado.getMa().size() != 0){
                        jugadorSeleccionado.getMa().remove(random.nextInt(jugadorSeleccionado.getMa().size()));
                    }
                    break;
                case "PATADA":
                    jugadorSeleccionado.setPatada(true);
                    break;
                case "BROMA":
                    List<Carta> cartasJugador = jugadorActual.getMa();
                    List<Carta> cartasJugadorSeleccionado = jugadorSeleccionado.getMa();
                    jugadorActual.setMa(cartasJugadorSeleccionado);
                    jugadorSeleccionado.setMa(cartasJugador);
                    break;
                case "HUNDIMIENTO":
                    jugadorSeleccionado.setCasilla(-1);
                    jugadorSeleccionado.getImagenCasilla().setImageResource(0);
                    jugadorSeleccionado.setImagenCasilla(jugadorSeleccionado.getCasillaInicial());
                    jugadorSeleccionado.getImagenCasilla().setImageResource(jugadorSeleccionado.getFoto());
                    break;
            }
            if (estado.getCardName().equals("BROMA")) jugadorSeleccionado.getMa().remove(estado.getCardPosition());
            else jugadorActual.getMa().remove(estado.getCardPosition());
            checkGanador();
            if (!casillaEspecial){
                cambiarJugador();
                recyclerViewFotos.setVisibility(View.GONE);
            }
        });
        recyclerViewFotos.setAdapter(adapterFotos);
        recyclerViewFotos.setHasFixedSize(true);
        recyclerViewFotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
    public void cambiarJugador(){
        for (Jugador jugador : jugadores){
            System.out.println(jugador.getNom() + ": " + jugador.getCasilla());
        }
        if (checkCartasGeneral()) repartirBaraja();
        numJugadorActual++;
        if (numJugadorActual >= cantidadJugadores) numJugadorActual = 0;
        jugadorActual = jugadores.get(numJugadorActual);
        if (checkCartes(jugadorActual)) cambiarJugador();
        nomJugador.setText(jugadorActual.getNom());
        fotoJugador.setImageResource(jugadorActual.getFoto());
        AdapterCartes adapterCartes = new AdapterCartes(jugadorActual.getMa());
        recyclerView.setAdapter(adapterCartes);
        adapterCartes.setOnItemClickListener(gameState -> {
            estado = gameState;
            efecto = estado.getCardName();
            recyclerViewFotos.setVisibility(View.VISIBLE);
            switch (efecto){
                case "MOV_1":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para mover 1 casilla", Toast.LENGTH_SHORT).show();
                    break;
                case "MOV_2":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para mover 2 casillas", Toast.LENGTH_SHORT).show();
                    break;
                case "MOV_3":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para mover 3 casillas", Toast.LENGTH_SHORT).show();
                    break;
                case "TELEPORT":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para intercambiar posiciones", Toast.LENGTH_SHORT).show();
                    break;
                case "ZANCADILLA":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para aplicarle ZANCADILLA", Toast.LENGTH_SHORT).show();
                    break;
                case "PATADA":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para darle una PATADA", Toast.LENGTH_SHORT).show();
                    break;
                case "BROMA":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para hacer una BROMA", Toast.LENGTH_SHORT).show();
                    break;
                case "HUNDIMIENTO":
                    Toast.makeText(getApplicationContext(), "Escoje jugador para aplicarle HUNDIMIENTO", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
        AdapterFotos adapterFotos = new AdapterFotos(jugadores);
        adapterFotos.setOnItemClickListener(jugador -> {
            jugadorSeleccionado = jugador;
            switch (efecto){
                case "MOV_1":
                    moverJugador(1);
                    break;
                case "MOV_2":
                    //Si se escoje a si mismo avanza
                    moverJugador(2);
                    break;
                case "MOV_3":
                    //Si se escoje a si mismo avanza
                    moverJugador(3);
                    break;
                case "TELEPORT":
                    int posJugadorActual = jugadorActual.getCasilla();
                    int posJugadorSeleccionado = jugadorSeleccionado.getCasilla();

                    jugadorActual.setCasilla(posJugadorSeleccionado);
                    jugadorActual.getImagenCasilla().setImageResource(0);

                    if (jugadorActual.getCasilla() <= -1){
                        jugadorActual.setImagenCasilla(jugadorActual.getCasillaInicial());
                        jugadorActual.getImagenCasilla().setImageResource(jugadorActual.getFoto());
                    }
                    else {
                        if (casillas1[jugadorActual.getCasilla()].getDrawable() == null){
                            casillas1[jugadorActual.getCasilla()].setImageResource(jugadorActual.getFoto());
                            jugadorActual.setImagenCasilla(casillas1[jugadorActual.getCasilla()]);
                        }
                        else {
                            casillas2[jugadorActual.getCasilla()].setImageResource(jugadorActual.getFoto());
                            jugadorActual.setImagenCasilla(casillas2[jugadorActual.getCasilla()]);
                        }
                    }

                    jugadorSeleccionado.setCasilla(posJugadorActual);
                    jugadorSeleccionado.getImagenCasilla().setImageResource(0);

                    if (jugadorSeleccionado.getCasilla() <= -1){
                        jugadorSeleccionado.setImagenCasilla(jugadorSeleccionado.getCasillaInicial());
                        jugadorSeleccionado.getCasillaInicial().setImageResource(jugadorSeleccionado.getFotoInicial());
                    }
                    else {
                        if (casillas1[jugadorSeleccionado.getCasilla()].getDrawable() == null){
                            casillas1[jugadorSeleccionado.getCasilla()].setImageResource(jugadorSeleccionado.getFoto());
                            jugadorSeleccionado.setImagenCasilla(casillas1[jugadorSeleccionado.getCasilla()]);
                        }
                        else {
                            casillas2[jugadorSeleccionado.getCasilla()].setImageResource(jugadorSeleccionado.getFoto());
                            jugadorSeleccionado.setImagenCasilla(casillas2[jugadorSeleccionado.getCasilla()]);
                        }
                    }
                    break;
                case "ZANCADILLA":
                    Random random = new Random();
                    if (jugadorSeleccionado.getMa().size() != 0){
                        jugadorSeleccionado.getMa().remove(random.nextInt(jugadorSeleccionado.getMa().size()));
                    }
                    break;
                case "PATADA":
                    jugadorSeleccionado.setPatada(true);
                    break;
                case "BROMA":
                    List<Carta> cartasJugador = jugadorActual.getMa();
                    List<Carta> cartasJugadorSeleccionado = jugadorSeleccionado.getMa();
                    jugadorActual.setMa(cartasJugadorSeleccionado);
                    jugadorSeleccionado.setMa(cartasJugador);
                    break;
                case "HUNDIMIENTO":
                    jugadorSeleccionado.setCasilla(-1);
                    jugadorSeleccionado.getImagenCasilla().setImageResource(0);
                    jugadorSeleccionado.setImagenCasilla(jugadorSeleccionado.getCasillaInicial());
                    jugadorSeleccionado.getImagenCasilla().setImageResource(jugadorSeleccionado.getFoto());
                    break;
            }
            if (estado.getCardName().equals("BROMA")) jugadorSeleccionado.getMa().remove(estado.getCardPosition());
            else jugadorActual.getMa().remove(estado.getCardPosition());
            checkGanador();
            if (!casillaEspecial) {
                cambiarJugador();
                recyclerViewFotos.setVisibility(View.GONE);
            }
        });
        recyclerViewFotos.setAdapter(adapterFotos);
        recyclerViewFotos.setHasFixedSize(true);
        recyclerViewFotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
    public void checkCasilla8(){
        AdapterFotos adapterFotos = new AdapterFotos(jugadores);
        if (jugadorActual.getCasilla() == 7){
            casillaEspecial = true;
            Toast.makeText(this, "Escoje jugador para moverle 5 casillas", Toast.LENGTH_SHORT).show();
            efecto = "";
            System.out.println(jugadores);
            adapterFotos.setOnItemClickListener(jugador -> {
                if (jugador == jugadorActual) {
                    jugadorActual.getImagenCasilla().setImageResource(0);
                    jugadorActual.setCasilla(jugadorActual.getCasilla() + 5);
                    if (casillas1[jugadorActual.getCasilla()].getDrawable() == null){
                        casillas1[jugadorActual.getCasilla()].setImageResource(jugadorActual.getFoto());
                        jugadorActual.setImagenCasilla(casillas1[jugadorActual.getCasilla()]);
                        cambiarJugador();
                        casillaEspecial = false;
                    }
                    else {
                        casillas2[jugadorActual.getCasilla()].setImageResource(jugadorActual.getFoto());
                        jugadorActual.setImagenCasilla(casillas2[jugadorActual.getCasilla()]);
                        cambiarJugador();
                        casillaEspecial = false;
                    }
                }
                else {
                    jugador.getImagenCasilla().setImageResource(0);
                    jugador.setCasilla(jugador.getCasilla() - 5);
                    if (jugador.getCasilla() < -1) jugador.setCasilla(-1);
                    jugador.getImagenCasilla().setImageResource(0);
                    if (jugador.getCasilla() <= -1){
                        jugador.getCasillaInicial().setImageResource(jugador.getFoto());
                        jugador.setImagenCasilla(jugador.getCasillaInicial());
                        cambiarJugador();
                        casillaEspecial = false;
                    } else {
                        if (casillas1[jugador.getCasilla()].getDrawable() == null) {
                            casillas1[jugador.getCasilla()].setImageResource(jugador.getFoto());
                            jugador.setImagenCasilla(casillas1[jugador.getCasilla()]);
                            cambiarJugador();
                            casillaEspecial = false;
                        } else if (casillas1[jugador.getCasilla()].getDrawable() != null) {
                            casillas2[jugador.getCasilla()].setImageResource(jugador.getFoto());
                            jugador.setImagenCasilla(casillas2[jugador.getCasilla()]);
                            cambiarJugador();
                            casillaEspecial = false;
                        }
                    }
                }
            });
        }
        recyclerViewFotos.setAdapter(adapterFotos);
        recyclerViewFotos.setHasFixedSize(true);
        recyclerViewFotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
    public void checkGanador(){
        if (jugadorActual.getCasilla() == 14){
            Intent intent = new Intent(Joc.this, Ganador.class);
            intent.putExtra("GanadorNombre", jugadorActual.getNom());
            intent.putExtra("GanadorFoto", jugadorActual.getFoto());
            startActivity(intent);
        }
    }
    public boolean checkCartes(Jugador jugadorActual){
        return jugadorActual.getMa().size() == 0;
    }
    public void moverJugador(int casillas){
        if (jugadorActual.isPatada()) casillas--;
        if (jugadorSeleccionado == jugadorActual) {
            jugadorActual.setCasilla(jugadorActual.getCasilla() + casillas);
            jugadorActual.getImagenCasilla().setImageResource(0);
            if (casillas1[jugadorActual.getCasilla()].getDrawable() == null) {
                casillas1[jugadorActual.getCasilla()].setImageResource(jugadorActual.getFoto());
                jugadorActual.setImagenCasilla(casillas1[jugadorActual.getCasilla()]);
            } else if (casillas2[jugadorActual.getCasilla()].getDrawable() == null) {
                casillas2[jugadorActual.getCasilla()].setImageResource(jugadorActual.getFoto());
                jugadorActual.setImagenCasilla(casillas2[jugadorActual.getCasilla()]);
            }
            else {
                if (casillas1[jugadorActual.getCasilla() - 1].getDrawable() == null){
                    casillas1[jugadorActual.getCasilla()-1].setImageResource(jugadorActual.getFoto());
                    jugadorActual.setImagenCasilla(casillas1[jugadorActual.getCasilla()-1]);
                }
                else {
                    casillas2[jugadorActual.getCasilla()-1].setImageResource(jugadorActual.getFoto());
                    jugadorActual.setImagenCasilla(casillas2[jugadorActual.getCasilla()-1]);
                }
            }
        }
        //Si no hace retroceder al adversario
        else {
            jugadorSeleccionado.setCasilla(jugadorSeleccionado.getCasilla() - casillas);
            if (jugadorSeleccionado.getCasilla() < -1) jugadorSeleccionado.setCasilla(-1);
            jugadorSeleccionado.getImagenCasilla().setImageResource(0);
            if (jugadorSeleccionado.getCasilla() <= -1){
                jugadorSeleccionado.getCasillaInicial().setImageResource(jugadorSeleccionado.getFoto());
                jugadorSeleccionado.setImagenCasilla(jugadorSeleccionado.getCasillaInicial());
            } else {
                if (casillas1[jugadorSeleccionado.getCasilla()].getDrawable() == null) {
                    casillas1[jugadorSeleccionado.getCasilla()].setImageResource(jugadorSeleccionado.getFoto());
                    jugadorSeleccionado.setImagenCasilla(casillas1[jugadorSeleccionado.getCasilla()]);
                } else if (casillas1[jugadorSeleccionado.getCasilla()].getDrawable() != null) {
                    casillas2[jugadorSeleccionado.getCasilla()].setImageResource(jugadorSeleccionado.getFoto());
                    jugadorSeleccionado.setImagenCasilla(casillas2[jugadorSeleccionado.getCasilla()]);
                }
            }
        }
        if (jugadorActual.getCasilla() == 7){
            checkCasilla8();
        }
    }
    public void repartirBaraja(){
        for (Jugador jugador : jugadores){
            jugador.setMa(baralla.subList(0, 6));
        }
    }
    public boolean checkCartasGeneral(){
        for (Jugador jugador : jugadores){
            if (jugador.getMa().size() != 0){
                return false;
            }
        }
        return true;
    }
}