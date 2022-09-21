package com.example.bestquotes.Screen.HomePage.Controller;

import static android.provider.Settings.System.getString;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ClipboardManager;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bestquotes.R;
import com.example.bestquotes.Screen.HomePage.Model.Model_Quotes;
import com.example.bestquotes.Screen.HomePage.View.Quotes_Activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter_Quotes extends RecyclerView.Adapter<Adapter_Quotes.ViewData> {

    Activity activity;
    List<Model_Quotes> l1 = new ArrayList<>();

    public Adapter_Quotes(Quotes_Activity quotes_activity, List<Model_Quotes> l1) {
        activity = quotes_activity;
        this.l1 = l1;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.item_quotes,parent,false);

        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
//        Glide.with(activity).load(l1.get(position).getImage()).into(holder.img_2);
        holder.txt.setText(l1.get(position).getTemp());

        holder.img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(activity, "Done", Toast.LENGTH_SHORT).show();

                Random random = new Random();
                int a = random.nextInt(10);
                Glide.with(activity).load(l1.get(a).getImage()).into(holder.img_2);
            }
        });

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                holder.like.setImageResource(R.drawable.red_heart);
            }
        });

        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, "Copy to Clipboard", Toast.LENGTH_SHORT).show();

                ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", l1.get(position).getTemp());
                clipboard.setPrimaryClip(clip);
            }
        });

        holder.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, "Save Image", Toast.LENGTH_SHORT).show();

                holder.img_view.setDrawingCacheEnabled(true);
                Bitmap bitamp = holder.img_view.getDrawingCache();

                try {
                    saveBitmap(activity,bitamp, Bitmap.CompressFormat.PNG,"image/*","newimg.png");
                }catch(Exception e) {

                }

                holder.img_view.destroyDrawingCache();
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.img_view.setDrawingCacheEnabled(true);
                Bitmap bitamp = holder.img_view.getDrawingCache();

            }
        });
    }

    @Override
    public int getItemCount() {
        return l1.size();
    }

    class ViewData extends RecyclerView.ViewHolder {

        ImageView img_2,like;
        LinearLayout copy,save,share;
        TextView txt;
        FrameLayout img_view;

        public ViewData(@NonNull View itemView) {
            super(itemView);

            img_2 = itemView.findViewById(R.id.img_2);
            txt = itemView.findViewById(R.id.txt);
            like = itemView.findViewById(R.id.like);
            copy = itemView.findViewById(R.id.copy);
            save = itemView.findViewById(R.id.save);
            img_view = itemView.findViewById(R.id.img_view);
            share = itemView.findViewById(R.id.share);
        }
    }

    @NonNull
    public Uri saveBitmap(@NonNull final Context context, @NonNull final Bitmap bitmap, @NonNull final Bitmap.CompressFormat format, @NonNull final String mimeType, @NonNull final String displayName) throws IOException {

        final String relativeLocation = Environment.DIRECTORY_DCIM + File.separator + "PhotoMaker";
        final ContentValues values = new ContentValues();
        values.put(MediaStore.MediaColumns.DISPLAY_NAME, displayName);
        values.put(MediaStore.MediaColumns.MIME_TYPE, mimeType);
        values.put(MediaStore.MediaColumns.RELATIVE_PATH, relativeLocation);

        final ContentResolver resolver = context.getContentResolver();
        Uri uri = null;

        try {
            final Uri contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            uri = resolver.insert(contentUri, values);

            if (uri == null)
                throw new IOException("Failed to create new MediaStore record.");

            try (final OutputStream stream = resolver.openOutputStream(uri)) {
                if (stream == null)
                    throw new IOException("Failed to open output stream.");

                if (!bitmap.compress(format, 95, stream))
                    throw new IOException("Failed to save bitmap.");
            }

//            Toast.makeText(context, ""+uri, Toast.LENGTH_SHORT).show();

            return uri;
        }
        catch (IOException e) {

            if (uri != null) {
                // Don't leave an orphan entry in the MediaStore
                resolver.delete(uri, null, null);
            }

            throw e;
        }
    }


}


