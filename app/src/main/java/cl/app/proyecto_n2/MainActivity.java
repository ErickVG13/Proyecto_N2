package cl.app.proyecto_n2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner sp_de;
    private Spinner sp_para;
    private CalendarView cale_pas;
    private TextView txt_hora;
    private Button bt_reserva_1;

    private String De = "";
    private String Para = "";
    private String Calendario = "";
    private String Hora = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_reserva_1 = (Button)  findViewById(R.id.bt_reserva_1);

        sp_de = (Spinner)  findViewById(R.id.sp_de);
        sp_para = (Spinner)  findViewById(R.id.sp_para);

        cale_pas = (CalendarView)  findViewById(R.id.cale_pas);

        txt_hora = (TextView)  findViewById(R.id.txt_hora);

        bt_reserva_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

    }
}