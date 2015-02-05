 package com.example.fairy.set;


import android.content.Context;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public Deck deck;
    public Field field;
    public	Integer[] mThumbIds;

    public ImageAdapter(Context c, Game game) throws NoSuchFieldException, IllegalAccessException {
        mContext = c;
        deck = game.getDeck();
        field = game.getField();
        mThumbIds =setMTumbIds();
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(270, 270));
           // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
          //  imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }



    private Integer[] setMTumbIds() throws NoSuchFieldException, IllegalAccessException {
        Integer [] result = new Integer[field.size()];
        for (int i=0; i<result.length; i++){
            result[i]= R.drawable.class.getField(field.getCard(i).getPicLink()).getInt(null);
        }
        return result;
    }


    // references to our images


}