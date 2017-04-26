package kuidd.bot.commiton.json.bitbucket;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Target {

@SerializedName("hash")
@Expose
private String hash;
@SerializedName("links")
@Expose
private Links links;
@SerializedName("author")
@Expose
private Author author;
@SerializedName("parents")
@Expose
private List<Object> parents = null;
@SerializedName("date")
@Expose
private String date;
@SerializedName("message")
@Expose
private String message;
@SerializedName("type")
@Expose
private String type;

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

public Author getAuthor() {
return author;
}

public void setAuthor(Author author) {
this.author = author;
}

public List<Object> getParents() {
return parents;
}

public void setParents(List<Object> parents) {
this.parents = parents;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

}