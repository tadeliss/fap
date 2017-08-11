package com.example.tadsr.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RecentPhotosResponse {

    @Expose
    private Photos photos;

    public Photos getPhotosObject() {
        return photos;
    }

    public class Photos {

        @Expose
        private List<Photo> photo = new ArrayList<>();

        public List<Photo> getPhotoArrayList() {
            return photo;
        }
    }

    public class Photo {

        @Expose
        private String id;

        @Expose
        private String owner;

        @Expose
        private String title;

        @Expose
        private String ownername;

        @Expose
        private String iconserver;

        @Expose
        private String iconfarm;

        @SerializedName("url_c")
        @Expose
        private String urlC;

        @SerializedName("url_z")
        @Expose
        private String urlZ;

        @SerializedName("url_n")
        @Expose
        private String urlN;

        /**
         * @return The id
         */
        public String getId() {
            return id;
        }

        /**
         * @return The owner
         */
        public String getOwner() {
            return owner;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @return The ownername
         */
        public String getOwnername() {
            return ownername;
        }

        /**
         * @return The iconserver
         */
        public String getIconserver() {
            return iconserver;
        }

        /**
         * @return The iconfarm
         */
        public String getIconfarm() {
            return iconfarm;
        }

        /**
         * @return The urlC
         */
        public String getUrlC() {
            return urlC;
        }

        /**
         * @return The urlZ
         */
        public String getUrlZ() {
            return urlZ;
        }

        /**
         * @return The urlN
         */
        public String getUrlN() {
            return urlN;
        }
    }
}