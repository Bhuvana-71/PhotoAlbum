package com.example.photoalbum;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyImageRepository {

    private MyImageDao myImageDao;
    private LiveData<List<MyImages>> imagesList;

//Executor
    ExecutorService executorService = Executors.newSingleThreadExecutor();





    public MyImageRepository(Application application)
    {

        MyImageDatabase database=MyImageDatabase.getInstance(application);
        myImageDao= database.myImageDao();

        imagesList=myImageDao.getAllImages();

    }
    public void insert(MyImages myImages)
    {
               // new InsertImageAsyncTask(myImageDao).execute(myImages);


           executorService.execute(new Runnable() {
               @Override
               public void run() {
                   myImageDao.insert(myImages);
               }
           });


    }
    public void delete(MyImages myImages)
    {
               //  new DeleteImageAsyncTask(myImageDao).execute(myImages);


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myImageDao.delete(myImages);
            }
        });

    }
    public void update(MyImages myImages)
    {


       // new   UpdateImageAsyncTask(myImageDao).execute(myImages);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myImageDao.update(myImages);
            }
        });



    }
    public LiveData<List<MyImages>>   getAllImages()
    {
        return imagesList;
    }





     //first parameter -->doInbacground() class ki parameter

    //second parameter  -->onProgressUpdate()  to track the transcation

    //third parameter  -->return type of doInBacground() method as we do not want to return anthing

    /*

    private static class InsertImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {
     MyImageDao imagesDao;

        public InsertImageAsyncTask(MyImageDao imagesDao) {
            this.imagesDao = imagesDao;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            imagesDao.insert(myImages[0]);



            return null;
        }
    }


    private static class UpdateImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {
        MyImageDao imagesDao;

        public UpdateImageAsyncTask(MyImageDao imagesDao) {
            this.imagesDao = imagesDao;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            imagesDao.update(myImages[0]);



            return null;
        }
    }
    private static class DeleteImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {
        MyImageDao imagesDao;

        public DeleteImageAsyncTask(MyImageDao imagesDao) {
            this.imagesDao = imagesDao;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            imagesDao.delete(myImages[0]);



            return null;
        }
    }

*/

}
