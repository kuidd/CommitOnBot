package kuidd.bot.commiton.json.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Old {

@SerializedName("type")
@Expose
private String type;
@SerializedName("name")
@Expose
private String name;
@SerializedName("links")
@Expose
private Links links;
@SerializedName("target")
@Expose
private Target target;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public Target getTarget() {
return target;
}

public void setTarget(Target target) {
this.target = target;
}

}