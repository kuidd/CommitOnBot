package kuidd.bot.commiton.json.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

@SerializedName("commits")
@Expose
private Commits commits;
@SerializedName("self")
@Expose
private Self self;
@SerializedName("comments")
@Expose
private Comments comments;
@SerializedName("patch")
@Expose
private Patch patch;
@SerializedName("html")
@Expose
private Html html;
@SerializedName("diff")
@Expose
private Diff diff;
@SerializedName("approve")
@Expose
private Approve approve;
@SerializedName("statuses")
@Expose
private Statuses statuses;
@SerializedName("avatar")
@Expose
private Avatar avatar;

public Commits getCommits() {
return commits;
}

public void setCommits(Commits commits) {
this.commits = commits;
}

public Self getSelf() {
return self;
}

public void setSelf(Self self) {
this.self = self;
}

public Comments getComments() {
return comments;
}

public void setComments(Comments comments) {
this.comments = comments;
}

public Patch getPatch() {
return patch;
}

public void setPatch(Patch patch) {
this.patch = patch;
}

public Html getHtml() {
return html;
}

public void setHtml(Html html) {
this.html = html;
}

public Diff getDiff() {
return diff;
}

public void setDiff(Diff diff) {
this.diff = diff;
}

public Approve getApprove() {
return approve;
}

public void setApprove(Approve approve) {
this.approve = approve;
}

public Statuses getStatuses() {
return statuses;
}

public void setStatuses(Statuses statuses) {
this.statuses = statuses;
}

public Avatar getAvatar() {
return avatar;
}

public void setAvatar(Avatar avatar) {
this.avatar = avatar;
}

}