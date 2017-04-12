
package kuidd.bot.commiton.json.github;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeadCommit {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("tree_id")
    @Expose
    private String treeId;
    @SerializedName("distinct")
    @Expose
    private boolean distinct;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("committer")
    @Expose
    private Committer committer;
    @SerializedName("added")
    @Expose
    private List<String> added = null;
    @SerializedName("removed")
    @Expose
    private List<Object> removed = null;
    @SerializedName("modified")
    @Expose
    private List<Object> modified = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HeadCommit withId(String id) {
        this.id = id;
        return this;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public HeadCommit withTreeId(String treeId) {
        this.treeId = treeId;
        return this;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public HeadCommit withDistinct(boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HeadCommit withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public HeadCommit withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HeadCommit withUrl(String url) {
        this.url = url;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public HeadCommit withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Committer getCommitter() {
        return committer;
    }

    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    public HeadCommit withCommitter(Committer committer) {
        this.committer = committer;
        return this;
    }

    public List<String> getAdded() {
        return added;
    }

    public void setAdded(List<String> added) {
        this.added = added;
    }

    public HeadCommit withAdded(List<String> added) {
        this.added = added;
        return this;
    }

    public List<Object> getRemoved() {
        return removed;
    }

    public void setRemoved(List<Object> removed) {
        this.removed = removed;
    }

    public HeadCommit withRemoved(List<Object> removed) {
        this.removed = removed;
        return this;
    }

    public List<Object> getModified() {
        return modified;
    }

    public void setModified(List<Object> modified) {
        this.modified = modified;
    }

    public HeadCommit withModified(List<Object> modified) {
        this.modified = modified;
        return this;
    }

}
