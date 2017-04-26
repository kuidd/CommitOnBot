package kuidd.bot.commiton.json.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {

@SerializedName("website")
@Expose
private String website;
@SerializedName("scm")
@Expose
private String scm;
@SerializedName("name")
@Expose
private String name;
@SerializedName("links")
@Expose
private Links links;
@SerializedName("project")
@Expose
private Project project;
@SerializedName("full_name")
@Expose
private String fullName;
@SerializedName("owner")
@Expose
private Owner owner;
@SerializedName("type")
@Expose
private String type;
@SerializedName("is_private")
@Expose
private Boolean isPrivate;
@SerializedName("uuid")
@Expose
private String uuid;

public String getWebsite() {
return website;
}

public void setWebsite(String website) {
this.website = website;
}

public String getScm() {
return scm;
}

public void setScm(String scm) {
this.scm = scm;
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

public Project getProject() {
return project;
}

public void setProject(Project project) {
this.project = project;
}

public String getFullName() {
return fullName;
}

public void setFullName(String fullName) {
this.fullName = fullName;
}

public Owner getOwner() {
return owner;
}

public void setOwner(Owner owner) {
this.owner = owner;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public Boolean getIsPrivate() {
return isPrivate;
}

public void setIsPrivate(Boolean isPrivate) {
this.isPrivate = isPrivate;
}

public String getUuid() {
return uuid;
}

public void setUuid(String uuid) {
this.uuid = uuid;
}

}