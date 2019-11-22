package br.com.arcadiam.projetox;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Typeface fonte;
    private Button btoNewGame;
    private Button btoSair;
    private MediaPlayer playerMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        final View decorVeiw = getWindow().getDecorView();
        final int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        decorVeiw.setSystemUiVisibility( uiOptions );
        decorVeiw.setOnSystemUiVisibilityChangeListener( new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) ==0){
                    try{//quando o usuário prescionar partes da barras de função ou status do smart, irá disparar um timer para esconder novamente.
                        Thread.sleep(2000);
                        decorVeiw.setSystemUiVisibility( uiOptions );
                    }catch (InterruptedException e){
                        System.out.println( e );
                    }
                }
                else{//quando não há alteração na tela

                }
            }
        } );
        setContentView( R.layout.activity_main );

    //Definição de atributos
        this.fonte = Typeface.createFromAsset( getAssets(),"Computerfont.ttf");
        this.btoNewGame = findViewById( R.id.newGame );
        this.btoNewGame.setTypeface( this.fonte );
        this.btoSair = findViewById( R.id.sairGame );
        this.btoSair.setTypeface( this.fonte );
    ////////////////////////

    //Metodos
        this.btoSair.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
    ///////////////////////
    }

    @Override
    protected void onPause(){
        /*
        * O metodo onPause é usado para definir os atributos da activity quando o usuário faz
        * alteração das telas ou até mesmo do aplicativo.
        * */
        super.onPause();
        this.playerMusica.release();//Liberar recursos de memória usados pelo MediaPlayer
        this.playerMusica = null;
    }

    @Override
    protected  void onResume(){
        /*
        * O metodo onResume é executado sempre que a activity é executada. Sua interação acontece em
        * tempo de execução, ou seja, a criação de variáveis e atribuição de valores acontece aqui
        * em tempo de execução.
        * */
        super.onResume();
        this.playerMusica = MediaPlayer.create( this, R.raw.theme );//Carrega arquivo de áudio na memória
        this.playerMusica.start(); //inicia a execução do arquivo de áudio
        this.playerMusica.setLooping( true ); // se o valor informado for true a execução do arquivo ficará em looping
    }
}
