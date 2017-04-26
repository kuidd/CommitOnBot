package kuidd.bot.commiton.json.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parent {

@SerializedName("type")
@Expose
private String type;
@SerializedName("hash")
@Expose
private String hash;
@SerializedName("links")
@Expose
private Links links;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getHash() {
return hash;
}

public void setHash(String hash) {
this.hash = hash;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

}