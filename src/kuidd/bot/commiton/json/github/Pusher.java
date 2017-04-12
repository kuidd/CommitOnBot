
package kuidd.bot.commiton.json.github;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pusher {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pusher withName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pusher withEmail(String email) {
        this.email = email;
        return this;
    }

}
