package com.example.photoalbum;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyImageDao {






    @Insert
    void insert(MyImages myImages);



    @Delete
    void delete(MyImages myImages);


    @Update
    void update(MyImages myImages);



    @Query("SELECT * FROM my_images ORDER BY image_id ASC")
    LiveData<List<MyImages>>getAllImages();

    // Now from this query i have to import all the data into a list ,here * means All columuns



}
