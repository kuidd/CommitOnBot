package kuidd.bot.commiton.json.bitbucket;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Change {

@SerializedName("forced")
@Expose
private Boolean forced;
@SerializedName("old")
@Expose
private Old old;
@SerializedName("links")
@Expose
private Links links;
@SerializedName("truncated")
@Expose
private Boolean truncated;
@SerializedName("commits")
@Expose
private List<Commit> commits = null;
@SerializedName("created")
@Expose
private Boolean created;
@SerializedName("closed")
@Expose
private Boolean closed;
@SerializedName("new")
@Expose
private New _new;

public Boolean getForced() {
return forced;
}

public void setForced(Boolean forced) {
this.forced = forced;
}

public Old getOld() {
return old;
}

public void setOld(Old old) {
this.old = old;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public Boolean getTruncated() {
return truncated;
}

public void setTruncated(Boolean truncated) {
this.truncated = truncated;
}

public List<Commit> getCommits() {
return commits;
}

public void setCommits(List<Commit> commits) {
this.commits = commits;
}

public Boolean getCreated() {
return created;
}

public void setCreated(Boolean created) {
this.created = created;
}

public Boolean getClosed() {
return closed;
}

public void setClosed(Boolean closed) {
this.closed = closed;
}

public New getNew() {
return _new;
}

public void setNew(New _new) {
this._new = _new;
}

}