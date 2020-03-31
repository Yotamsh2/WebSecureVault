package com.securevault.websecurevault.utilities;

/**User class is the class that holds our User object in the system, the user that has logged in to the system.*/
public class User {
    private String user_id;
    private String first_name;
    private String last_name;
    private String master_pass;

    public User(String user_id, String first_name, String last_name, String master_pass) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.master_pass = master_pass;
    }
    public User(){
    }

    /**User toString method is responsible to return the user as a string to be printed.*/
    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMaster_pass() {
        return master_pass;
    }

    public void setMaster_pass(String master_pass) {
        this.master_pass = master_pass;
    }
}
