package com.example.photoalbum;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = MyImages.class,version=1)
public  abstract class MyImageDatabase   extends RoomDatabase {



    private static MyImageDatabase instance;
    public abstract MyImageDao myImageDao(); // the necessary operations will be performed by room database



    //fallbacktoDestructiveMigration  if you dontwant migrations and you specifically want your database to be cleared when you upgrade the version//data is lost

    public static synchronized MyImageDatabase getInstance(Context context)

    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),MyImageDatabase.class,"my_images_database")
                    .fallbackToDestructiveMigration()
                    //.allowMainThreadQueries()//-->not recommended
                    .build();
        }


return instance;

    }


}
