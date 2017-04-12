
package kuidd.bot.commiton.json.github;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitHubResponse {

    @SerializedName("ref")
    @Expose
    private String ref;
    @SerializedName("before")
    @Expose
    private String before;
    @SerializedName("after")
    @Expose
    private String after;
    @SerializedName("created")
    @Expose
    private boolean created;
    @SerializedName("deleted")
    @Expose
    private boolean deleted;
    @SerializedName("forced")
    @Expose
    private boolean forced;
    @SerializedName("base_ref")
    @Expose
    private Object baseRef;
    @SerializedName("compare")
    @Expose
    private String compare;
    @SerializedName("commits")
    @Expose
    private List<Commit> commits = null;
    @SerializedName("head_commit")
    @Expose
    private HeadCommit headCommit;
    @SerializedName("repository")
    @Expose
    private Repository repository;
    @SerializedName("pusher")
    @Expose
    private Pusher pusher;
    @SerializedName("organization")
    @Expose
    private Organization organization;
    @SerializedName("sender")
    @Expose
    private Sender sender;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public GitHubResponse withRef(String ref) {
        this.ref = ref;
        return this;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public GitHubResponse withBefore(String before) {
        this.before = before;
        return this;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public GitHubResponse withAfter(String after) {
        this.after = after;
        return this;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public GitHubResponse withCreated(boolean created) {
        this.created = created;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public GitHubResponse withDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public boolean isForced() {
        return forced;
    }

    public void setForced(boolean forced) {
        this.forced = forced;
    }

    public GitHubResponse withForced(boolean forced) {
        this.forced = forced;
        return this;
    }

    public Object getBaseRef() {
        return baseRef;
    }

    public void setBaseRef(Object baseRef) {
        this.baseRef = baseRef;
    }

    public GitHubResponse withBaseRef(Object baseRef) {
        this.baseRef = baseRef;
        return this;
    }

    public String getCompare() {
        return compare;
    }

    public void setCompare(String compare) {
        this.compare = compare;
    }

    public GitHubResponse withCompare(String compare) {
        this.compare = compare;
        return this;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    public GitHubResponse withCommits(List<Commit> commits) {
        this.commits = commits;
        return this;
    }

    public HeadCommit getHeadCommit() {
        return headCommit;
    }

    public void setHeadCommit(HeadCommit headCommit) {
        this.headCommit = headCommit;
    }

    public GitHubResponse withHeadCommit(HeadCommit headCommit) {
        this.headCommit = headCommit;
        return this;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public GitHubResponse withRepository(Repository repository) {
        this.repository = repository;
        return this;
    }

    public Pusher getPusher() {
        return pusher;
    }

    public void setPusher(Pusher pusher) {
        this.pusher = pusher;
    }

    public GitHubResponse withPusher(Pusher pusher) {
        this.pusher = pusher;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public GitHubResponse withOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public GitHubResponse withSender(Sender sender) {
        this.sender = sender;
        return this;
    }

}
