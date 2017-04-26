package kuidd.bot.commiton.json.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BitBucket {

@SerializedName("push")
@Expose
private Push push;
@SerializedName("actor")
@Expose
private Actor actor;
@SerializedName("repository")
@Expose
private Repository repository;

public Push getPush() {
return push;
}

public void setPush(Push push) {
this.push = push;
}

public Actor getActor() {
return actor;
}

public void setActor(Actor actor) {
this.actor = actor;
}

public Repository getRepository() {
return repository;
}

public void setRepository(Repository repository) {
this.repository = repository;
}

}