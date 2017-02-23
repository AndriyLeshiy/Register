package com.leshiy.registerapp.registerapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bogdan on 19.02.17.
 */

public class User implements Parcelable {
    private String firstName;
    private String lastName;
    private String birthday;
    private String about;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.birthday);
        dest.writeString(this.about);
    }

    public User() {
        firstName = "";
        lastName = "";
        birthday = "";
        about = "";
    }

    protected User(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.birthday = in.readString();
        this.about = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public boolean checkData() {
        if (!(firstName.equals("") || lastName.equals("") || birthday.equals("") || about.equals(""))) {
            return true;
        }
        return false;
    }
}
