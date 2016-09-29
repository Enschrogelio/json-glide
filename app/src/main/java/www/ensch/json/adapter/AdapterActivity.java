package www.ensch.json.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

import www.ensch.json.R;
import www.ensch.json.model.DataActivity;

/**
 * Created by x on 9/28/2016.
 */

public class AdapterActivity extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataActivity> data= Collections.emptyList();
    DataActivity current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterActivity(Context context, List<DataActivity> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        DataActivity current=data.get(position);
        myHolder.textSize.setText("Datos: " + current.sizeName);

        // load image into imageview using glide

        Glide.with(context).load("http://pruebaganagana.esy.es/img/" + current.fishImage)
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(myHolder.ivFish);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        ImageView ivFish;
        TextView textSize;


        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            ivFish= (ImageView) itemView.findViewById(R.id.ivFish);
            textSize = (TextView) itemView.findViewById(R.id.textSize);
        }

    }

}
