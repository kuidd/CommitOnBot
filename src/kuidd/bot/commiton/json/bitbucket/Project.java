package kuidd.bot.commiton.json.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

@SerializedName("links")
@Expose
private Links links;
@SerializedName("type")
@Expose
private String type;
@SerializedName("uuid")
@Expose
private String uuid;
@SerializedName("key")
@Expose
private String key;
@SerializedName("name")
@Expose
private String name;

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getUuid() {
return uuid;
}

public void setUuid(String uuid) {
this.uuid = uuid;
}

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

}