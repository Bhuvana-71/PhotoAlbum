package com.example.photoalbum;
//MyImages is a Entity Class Which defines what what data need to be stored in Table


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "my_images")
public class MyImages {

    @PrimaryKey(autoGenerate = true)
    public int image_id;
    public String  image_title;
    public String image_description;

    public byte[] image;

    public MyImages( String image_title, String image_description, byte[] image) {

        this.image_title = image_title;
        this.image_description = image_description;
        this.image = image;
    }


    public int getImage_id() {
        return image_id;
    }

    public String getImage_title() {
        return image_title;
    }

    public String getImage_description() {
        return image_description;
    }

    public byte[] getImage() {
        return image;
    }


    //while updating we should not update id thats why we keep setter for id


    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
