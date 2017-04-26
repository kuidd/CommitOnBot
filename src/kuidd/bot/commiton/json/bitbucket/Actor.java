package kuidd.bot.commiton.json.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actor {

@SerializedName("username")
@Expose
private String username;
@SerializedName("type")
@Expose
private String type;
@SerializedName("display_name")
@Expose
private String displayName;
@SerializedName("uuid")
@Expose
private String uuid;
@SerializedName("links")
@Expose
private Links links;

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getDisplayName() {
return displayName;
}

public void setDisplayName(String displayName) {
this.displayName = displayName;
}

public String getUuid() {
return uuid;
}

public void setUuid(String uuid) {
this.uuid = uuid;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

}