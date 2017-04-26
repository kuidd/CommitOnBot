package kuidd.bot.commiton.json.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

@SerializedName("raw")
@Expose
private String raw;
@SerializedName("type")
@Expose
private String type;
@SerializedName("user")
@Expose
private User user;

public String getRaw() {
return raw;
}

public void setRaw(String raw) {
this.raw = raw;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public User getUser() {
return user;
}

public void setUser(User user) {
this.user = user;
}

}