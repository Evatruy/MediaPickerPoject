package com.linking.mediapicker.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by linking on 2018/7/4.
 */

public class Media implements Parcelable {
    public String path;
    public String name;
    public String extension;
    public long time;
    /**
     * 多媒体类型，0-NONE，1-IMAGE，2-AUDIO，3-VIDEO，4-PLAYLIST
     * Constant for the MediaStore.Files.FileColumns.MEDIA_TYPE column indicating that file
     * is not an audio, image, video or playlist file.
     */
    public int mediaType;
    public long size;
    public int id;
    public String parentDir;

    public Media(String path, String name, long time, int mediaType, long size, int id, String parentDir) {
        this.path = path;
        this.name = name;
        if (!TextUtils.isEmpty(name) && name.contains(".")) {
            this.extension = name.substring(name.lastIndexOf("."), name.length());
        } else {
            this.extension = "null";
        }
        this.time = time;
        this.mediaType = mediaType;
        this.size = size;
        this.id = id;
        this.parentDir = parentDir;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.path);
        dest.writeString(this.name);
        dest.writeString(this.extension);
        dest.writeLong(this.time);
        dest.writeInt(this.mediaType);
        dest.writeLong(this.size);
        dest.writeInt(this.id);
        dest.writeString(this.parentDir);
    }

    protected Media(Parcel in) {
        this.path = in.readString();
        this.name = in.readString();
        this.extension = in.readString();
        this.time = in.readLong();
        this.mediaType = in.readInt();
        this.size = in.readLong();
        this.id = in.readInt();
        this.parentDir = in.readString();
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel source) {
            return new Media(source);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };
}
