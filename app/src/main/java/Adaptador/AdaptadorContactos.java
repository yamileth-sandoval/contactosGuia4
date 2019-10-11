package Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.contactosguia4.R;
import java.util.List;

import Entidades.Contacto;

public class AdaptadorContactos extends BaseAdapter {
    private List<Contacto> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;

    public List<Contacto> GetData(){
        return this.datasource;
    }

    /**
     * Constructor que permite inicializar las variables de la clase
     * @param context
     * @param IdPlantilla
     * @param sources
     */

    public AdaptadorContactos(Context context, int IdPlantilla, List<Contacto> sources){
        //Inicializamos las variables
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
    }

    @Override
    public int getCount() {
        return this.datasource.size();
    }

    @Override
    public Contacto getItem(int position) {
        return this.datasource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            //Creamos el Administrador de Layout
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);
            //Le damos vida al archivo xml ahora es un Layout
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            //Buscamos los controles de nuestra plantilla
            TextView texNombre = convertView.findViewById(R.id.texNombre);
            TextView texOrganizacion = convertView.findViewById(R.id.texOrganizacion);
            TextView texTelefono = convertView.findViewById(R.id.texTelefono);
            ImageView icono=convertView.findViewById(R.id.icono);

            //Obtenemos el dato a mostrar
            texNombre.setText(this.datasource.get(position).getNombre());
            texOrganizacion.setText(this.datasource.get(position).getOrganizacion());
            texTelefono.setText(this.datasource.get(position).getTelefono());
            icono.setImageResource(this.datasource.get(position).getImg());
        return convertView;
    }
}
