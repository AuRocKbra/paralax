package br.com.canaltecnico.projetox;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    private TextView textoPirncipal;
    private Typeface fonte;
    private Button btoNewGame;
    private Button btoSair;
    private SoundPool som;

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
                else{
                    //quando não há alteração na tela
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
}
